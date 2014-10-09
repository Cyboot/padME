package de.timweb.padme.input;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import net.java.games.input.Controller;
import net.java.games.input.Controller.Type;
import net.java.games.input.ControllerEnvironment;

import org.apache.log4j.Logger;

import de.timweb.padme.listner.IGamepadListener;
import de.timweb.padme.listner.RobotListener;
import de.timweb.padme.util.Init;
import de.timweb.padme.util.Utils;

public class ControllerLoop extends Thread {
	private static final int		SLEEP_TIME	= 3 * 1000;
	private static ControllerLoop	instance;
	private static final Logger		logger		= Logger.getLogger(ControllerLoop.class);

	private boolean					isRunning	= true;
	private GamepadUpdater			updater;
	private ControllerEnvironment	env;
	private Map<String, IGamepad>	gamepadMap;

	private List<IGamepadListener>	gamepadListner;

	private ControllerLoop() {
		env = ControllerEnvironment.getDefaultEnvironment();
		gamepadMap = new HashMap<String, IGamepad>();
		gamepadListner = new ArrayList<>();
		gamepadListner.add(new RobotListener());

		updater = new GamepadUpdater();

		java.util.logging.Logger.getLogger("net.java.games.input").setLevel(Level.OFF);
	}

	public static void main(String[] args) {
		ControllerLoop.getInstance().start();
	}

	@Override
	public void run() {
		Init.setLibraryPath();

		long delta = 0;

		while (isRunning) {
			long start = System.currentTimeMillis();
			Utils.sleep(500);

			checkForNewController();
			updateController();

			delta = System.currentTimeMillis() - start;

			for (IGamepadListener listener : gamepadListner) {
				for (IGamepad gamepad : gamepadMap.values()) {
					listener.update(gamepad, delta);
				}
			}

		}
	}


	private void updateController() {
		for (Controller controller : env.getControllers()) {
			IGamepad gamepad = gamepadMap.get(controller.getName());

			boolean isAlive = true;
			if (gamepad != null)
				isAlive = updater.update(gamepad, controller);

			if (!isAlive) {
				gamepadMap.remove(controller.getName());
				// removeController(ga);
			}
		}
		// reloadControllerEnvironment();
	}

	private void reloadControllerEnvironment() {
		try {
			@SuppressWarnings("unchecked")
			Constructor<ControllerEnvironment> constructor = (Constructor<ControllerEnvironment>) Class
					.forName("net.java.games.input.DefaultControllerEnvironment")
					.getDeclaredConstructors()[0];

			constructor.setAccessible(true);

			env = constructor.newInstance();
			// logger.info("reloading JInput Plugins");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private void checkForNewController() {
		// reloadControllerEnvironment();

		for (Controller controller : env.getControllers()) {
			if (controller.getType() == Type.GAMEPAD || controller.getType() == Type.STICK) {
				String name = controller.getName();

				if (!gamepadMap.containsKey(name) && controller.poll()) {
					gamepadMap.put(name, new DefaultGamepad());
				}
			}
		}
	}

	public static ControllerLoop getInstance() {
		if (null == instance) {
			instance = new ControllerLoop();
		}
		return instance;
	}
}

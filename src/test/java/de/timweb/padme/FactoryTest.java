package de.timweb.padme;

import net.java.games.input.Controller;
import net.java.games.input.Controller.Type;
import net.java.games.input.ControllerEnvironment;
import de.timweb.padme.input.GamepadFactory;
import de.timweb.padme.util.Init;

public class FactoryTest {

	public static void main(String[] args) {
		Init.setLibraryPath();
		Init.useDirectInputPlugin();

		Controller[] controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();

		for (Controller controller : controllers) {
			if (controller.getType() == Type.GAMEPAD || controller.getType() == Type.STICK) {
				GamepadFactory.createGamepad(controller);
			}
		}
	}
}

package de.timweb.padme.input;

import net.java.games.input.Component;
import net.java.games.input.Component.Identifier;
import net.java.games.input.Controller;
import de.timweb.padme.input.IGamepad.Button;
import de.timweb.padme.util.Utils;

public class GamepadUpdater {
	public boolean update(IGamepad gamepad, Controller controller) {
		if (!controller.poll())
			return false;

		Component[] components = controller.getComponents();

		for (Component component : components) {
			Identifier id = component.getIdentifier();
			float data = component.getPollData();

			if (id instanceof Identifier.Axis) {
				if (id.equals(Identifier.Axis.POV))
					updatePOV(gamepad, data);
				else
					updateAxis(gamepad, id, data);
			} else if (id instanceof Identifier.Button) {
				updateButton(gamepad, id, data);
			}
		}

		// String str = "";
		// if (gamepad.getButton(Button.POV_LEFT).isPressed())
		// str += "<<<   ";
		// else
		// str += "      ";
		// if (gamepad.getButton(Button.POV_UP).isPressed())
		// str += "^^^^  ";
		// else
		// str += "      ";
		// if (gamepad.getButton(Button.POV_DOWN).isPressed())
		// str += "vvv   ";
		// else
		// str += "      ";
		// if (gamepad.getButton(Button.POV_RIGHT).isPressed())
		// str += ">>>   ";
		// else
		// str += "      ";
		//
		// System.out.println(str);

		return true;
	}

	private void updateButton(IGamepad gamepad, Identifier id, float data) {

	}

	private void updateAxis(IGamepad gamepad, Identifier id, float data) {

	}

	private void updatePOV(IGamepad gamepad, float data) {
		gamepad.getButton(Button.POV_UP).setPressed(Utils.between(0.125f, 0.375f, data));
		gamepad.getButton(Button.POV_RIGHT).setPressed(Utils.between(0.375f, 0.625f, data));
		gamepad.getButton(Button.POV_DOWN).setPressed(Utils.between(0.625f, 0.875f, data));

		boolean left = Utils.between(0.875f, 1f, data) || Utils.between(0.1f, 0.125f, data);
		gamepad.getButton(Button.POV_LEFT).setPressed(left);

		// System.out.print(data + "   ");
	}
}

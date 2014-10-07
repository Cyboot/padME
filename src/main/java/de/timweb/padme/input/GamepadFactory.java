package de.timweb.padme.input;

import net.java.games.input.Component;
import net.java.games.input.Component.Identifier;
import net.java.games.input.Component.Identifier.Axis;
import net.java.games.input.Controller;

public class GamepadFactory {

	public Gamepad createGamepad(Controller controller) {
		int axisCount = 0;
		int buttonCount = 0;
		System.out.println(controller);

		for (Component component : controller.getComponents()) {
			Identifier identifier = component.getIdentifier();

			if (identifier instanceof Axis) {
				if (identifier.equals(Identifier.Axis.POV)) {

				} else if (identifier.equals(Identifier.Axis.UNKNOWN)) {

				} else {
					checkAxis(component, identifier);
					System.out.println(identifier.getName());
					axisCount++;
				}
			}
			if (identifier instanceof net.java.games.input.Component.Identifier.Button) {
				buttonCount++;
			}

		}

		System.out.println("Axis-count: " + axisCount);
		System.out.println("button-count: " + buttonCount);
		return null;
	}

	private void checkAxis(Component component, Identifier identifier) {
		if (identifier.equals(Identifier.Axis.X)) {
		}
		if (identifier.equals(Identifier.Axis.Y)) {
		}
		if (identifier.equals(Identifier.Axis.Z)) {
		}
		if (identifier.equals(Identifier.Axis.RX)) {
		}
		if (identifier.equals(Identifier.Axis.RY)) {
		}
		if (identifier.equals(Identifier.Axis.RZ)) {
		}
	}

}

package de.timweb.padme.input;

import java.util.List;

public interface Gamepad {

	public List<Axis> getAxiss();

	public int getAxisCount();

	public Axis getAxis(String name);

	public List<Button> getButtons();

	public int getButtonCount();

	public Button getButton(String name);


	public static class Axis {
		private String	name;
		private float	value;

		public String getName() {
			return name;
		}

		public float getValue() {
			return value;
		}
	}

	public static class Button {
		private String	name;
		private boolean	pressed;

		public String getName() {
			return name;
		}

		public boolean isPressed() {
			return pressed;
		}
	}
}

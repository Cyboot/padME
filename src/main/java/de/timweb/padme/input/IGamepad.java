package de.timweb.padme.input;

import java.util.List;

public interface IGamepad {

	public List<Axis> getAxiss();

	public int getAxisCount();

	public Axis getAxis(String type);

	public List<Button> getButtons();

	public int getButtonCount();

	public Button getButton(String type);


	public static class Axis {
		public static final String	STICK_LEFT_X	= "";
		public static final String	STICK_LEFT_Y	= "";
		public static final String	STICK_RIGHT_X	= "";
		public static final String	STICK_RIGHT_Y	= "";

		private String				type;
		private float				value;

		public Axis(String type) {
			this.type = type;
		}

		public String getType() {
			return type;
		}

		public float getValue() {
			return value;
		}

		public void setValue(float value) {
			this.value = value;
		}
	}

	public static class Button {//@formatter:off
		public static final String	POV_UP					= "POV_UP";
		public static final String	POV_DOWN				= "POV_DOWN";
		public static final String	POV_LEFT				= "POV_LEFT";
		public static final String	POV_RIGHT				= "POV_RIGHT";

		public static final String	BUTTON_UP				= net.java.games.input.Component.Identifier.Axis.RX.getName();
		public static final String	BUTTON_DOWN				= net.java.games.input.Component.Identifier.Axis.RX.getName();
		public static final String	BUTTON_LEFT				= net.java.games.input.Component.Identifier.Axis.RX.getName();
		public static final String	BUTTON_RIGHT			= net.java.games.input.Component.Identifier.Axis.RX.getName();

		public static final String	STICK_LEFT				= net.java.games.input.Component.Identifier.Axis.RX.getName();
		public static final String	STICK_RIGHT				= net.java.games.input.Component.Identifier.Axis.RX.getName();
 
		public static final String	SHOULDER_LEFT_TOP		= net.java.games.input.Component.Identifier.Axis.RX.getName();
		public static final String	SHOULDER_LEFT_BOTTOM	= net.java.games.input.Component.Identifier.Axis.RX.getName();
		public static final String	SHOULDER_RIGHT_TOP		= net.java.games.input.Component.Identifier.Axis.RX.getName();
		public static final String	SHOULDER_RIGHT_BOTTOM	= net.java.games.input.Component.Identifier.Axis.RX.getName();

		public static final String	SPECIAL_1				= net.java.games.input.Component.Identifier.Axis.RX.getName();
		public static final String	SPECIAL_2				= net.java.games.input.Component.Identifier.Axis.RX.getName();
		public static final String	SPECIAL_3				= net.java.games.input.Component.Identifier.Axis.RX.getName();
		public static final String	SPECIAL_4				= net.java.games.input.Component.Identifier.Axis.RX.getName();
		public static final String	SPECIAL_5				= net.java.games.input.Component.Identifier.Axis.RX.getName();
		//@formatter:on

		private String				type;
		private boolean				pressed;

		public Button(String type) {
			this.type = type;
		}

		public String getType() {
			return type;
		}

		public boolean isPressed() {
			return pressed;
		}

		public void setPressed(boolean pressed) {
			this.pressed = pressed;
		}
	}
}

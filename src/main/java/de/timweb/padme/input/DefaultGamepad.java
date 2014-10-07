package de.timweb.padme.input;

import java.util.List;

public class DefaultGamepad extends AbstractGamepad {

	public DefaultGamepad(List<Axis> axises, List<Button> buttons) {
		super(axises, buttons);
	}

	public static class POV {
		int	x, y;

		public boolean isLeft() {
			return x < 0;
		}

		public boolean isRight() {
			return x > 0;
		}

		public boolean isUp() {
			return y < 0;
		}

		public boolean isDown() {
			return y > 0;
		}
	}
}

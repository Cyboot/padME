package de.timweb.padme.input;

import java.util.List;

abstract class AbstractGamepad implements Gamepad {
	private final List<Axis>	axises;
	private final List<Button>	buttons;

	public AbstractGamepad(List<Axis> axises, List<Button> buttons) {
		super();
		this.axises = axises;
		this.buttons = buttons;
	}

	@Override
	public List<Axis> getAxiss() {
		return axises;
	}

	@Override
	public int getAxisCount() {
		return axises.size();
	}

	@Override
	public Axis getAxis(String name) {
		for (Axis stick : axises) {
			if (stick.getName().equals(name))
				return stick;
		}

		return null;
	}

	@Override
	public List<Button> getButtons() {
		return buttons;
	}

	@Override
	public int getButtonCount() {
		return buttons.size();
	}

	@Override
	public Button getButton(String name) {
		for (Button button : buttons) {
			if (button.getName().equals(name))
				return button;
		}

		return null;
	}

}

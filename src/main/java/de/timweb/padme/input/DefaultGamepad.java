package de.timweb.padme.input;

import java.util.ArrayList;
import java.util.List;

public class DefaultGamepad implements IGamepad {
	protected List<Axis>	axises;
	protected List<Button>	buttons;

	public DefaultGamepad() {
		initFields();
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
	public Axis getAxis(String type) {
		for (Axis stick : axises) {
			if (stick.getType() == type)
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
	public Button getButton(String type) {
		for (Button button : buttons) {
			if (button.getType() == type)
				return button;
		}

		return null;
	}

	private void initFields() {
		axises = new ArrayList<>();
		buttons = new ArrayList<>();

		axises.add(new Axis(Axis.STICK_LEFT_X));
		axises.add(new Axis(Axis.STICK_LEFT_Y));
		axises.add(new Axis(Axis.STICK_RIGHT_X));
		axises.add(new Axis(Axis.STICK_RIGHT_Y));

		buttons.add(new Button(Button.POV_UP));
		buttons.add(new Button(Button.POV_DOWN));
		buttons.add(new Button(Button.POV_LEFT));
		buttons.add(new Button(Button.POV_RIGHT));
		buttons.add(new Button(Button.BUTTON_UP));
		buttons.add(new Button(Button.BUTTON_DOWN));
		buttons.add(new Button(Button.BUTTON_LEFT));
		buttons.add(new Button(Button.BUTTON_RIGHT));
		buttons.add(new Button(Button.STICK_LEFT));
		buttons.add(new Button(Button.STICK_RIGHT));
		buttons.add(new Button(Button.SHOULDER_LEFT_TOP));
		buttons.add(new Button(Button.SHOULDER_LEFT_BOTTOM));
		buttons.add(new Button(Button.SHOULDER_RIGHT_TOP));
		buttons.add(new Button(Button.SHOULDER_RIGHT_BOTTOM));
		buttons.add(new Button(Button.SPECIAL_1));
		buttons.add(new Button(Button.SPECIAL_2));
		buttons.add(new Button(Button.SPECIAL_3));
		buttons.add(new Button(Button.SPECIAL_4));
		buttons.add(new Button(Button.SPECIAL_5));
	}
}

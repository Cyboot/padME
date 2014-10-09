package de.timweb.padme.listner;

import de.timweb.padme.input.IGamepad;

public class RobotListener implements IGamepadListener {

	@Override
	public void update(IGamepad gamepad, long delta) {
		System.out.println(gamepad);
	}

}

package de.timweb.padme.listner;

import de.timweb.padme.input.IGamepad;

public interface IGamepadListener {
	public void update(IGamepad gamepad, long delta);
}

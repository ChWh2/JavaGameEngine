package EngineUtils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Basic2D.Vector2;

public class Input implements KeyListener {
	public boolean wPressed = false;
	public boolean aPressed = false;
	public boolean sPressed = false;
	public boolean dPressed = false;
	
	@Override
	public void keyTyped(KeyEvent e) {
		if (testInput(e, 'w', 'W')) {
			wPressed = true;
		}
		else if (testInput(e, 'a', 'A')) {
			aPressed = true;
		}
		else if (testInput(e, 's', 'S')) {
			sPressed = true;
		}
		else if (testInput(e, 'd', 'D')) {
			dPressed = true;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {
		if (testInput(e, 'w', 'W')) {
			wPressed = false;
		}
		else if (testInput(e, 'a', 'A')) {
			aPressed = false;
		}
		else if (testInput(e, 's', 'S')) {
			sPressed = false;
		}
		else if (testInput(e, 'd', 'D')) {
			dPressed = false;
		}
	}
	
	private boolean testInput(KeyEvent e, char character1, char character2) {
		return e.getKeyChar() == character1 || e.getKeyChar() == character2;
	}
	
	public Vector2 getWASDInputAxis() {
		Vector2 inputDir = new Vector2(0,0);
		if(Engine.InputManager.wPressed) {
			inputDir.y -= 1;
		}
		if(Engine.InputManager.aPressed) {
			inputDir.x -= 1;
		}
		if(Engine.InputManager.sPressed) {
			inputDir.y += 1;
		}
		if(Engine.InputManager.dPressed) {
			inputDir.x += 1;
		}
		inputDir = inputDir.normalize();
		return inputDir;
	}
}

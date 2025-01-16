package EngineUtils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Basic2D.Vector2;

public class Input implements KeyListener {
	private static InputAction[] actions = new InputAction[0];
	
	@Override
	public void keyTyped(KeyEvent e) {
		//Loops Through each Action
		for(int actionIndex = 0; actionIndex < actions.length; actionIndex++) {
			InputAction action = actions[actionIndex];
			//Loops Through Each Key in A Action
			for(int keyIndex = 0; keyIndex < action.keys.length; keyIndex++) {
				if(action.keys[keyIndex] == e.getKeyChar()) {
					action.isDown = true;
					action.isJustDown = true;
					return;
				}
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {
		//Loops Through each Action
		for(int actionIndex = 0; actionIndex < actions.length; actionIndex++) {
			InputAction action = actions[actionIndex];
			//Loops Through Each Key in A Action
			for(int keyIndex = 0; keyIndex < action.keys.length; keyIndex++) {
				if(action.keys[keyIndex] == e.getKeyChar()) {
					action.isDown = false;
					return;
				}
			}
		}
	}
	
	public static void proccess() {
		for(var i = 0; i < actions.length; i++) {
			actions[i].isJustDown = false;
		}
	}
	
	public static Vector2 getInputAxis(String up, String Down, String left, String right) {
		Vector2 inputDir = new Vector2(0,0);
		if(isActionDown(up)) {
			inputDir.y -= 1;
		}
		if(isActionDown(left)) {
			inputDir.x -= 1;
		}
		if(isActionDown(Down)) {
			inputDir.y += 1;
		}
		if(isActionDown(right)) {
			inputDir.x += 1;
		}
		inputDir = inputDir.normalize();
		return inputDir;
	}
	
	public static boolean isActionDown(String action) {
		for(var i = 0; i < actions.length; i++) {
			if(actions[i].name == action) {
				return actions[i].isDown;
			}
		}
		return false;
	}
	
	public static boolean isActionJustPressed(String action) {
		for(var i = 0; i < actions.length; i++) {
			if(actions[i].name == action) {
				return actions[i].isJustDown;
			}
		}
		return false;
	}
	
	public static void createAction(String action, char[] keys) {
		InputAction[] newActions = new InputAction[actions.length + 1];
		for(var i = 0; i < actions.length; i++) {
			newActions[i] = actions[i];
		}
		newActions[actions.length] = new InputAction(action, keys);
		actions = newActions;
	}
}

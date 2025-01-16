package EngineUtils;

import java.nio.file.Path;
import java.nio.file.Paths;

import Game.gameManager;

public class Engine {	
	private static long lastTime;
	public static int deltaTime;
	
	public static Input InputManager;
	public static Window CurrentWindow;	
	public static Path projectRoot = Paths.get("").toAbsolutePath();
	
	public static void main(String[] args) {
		InputManager = new Input();
		
		CurrentWindow = new Window("Game");
		CurrentWindow.addKeyListener(InputManager);
		
		gameManager Game = new gameManager();
		
		lastTime = System.currentTimeMillis();
		Game.ready();
		
		while(true) {
			calculateDeltaTime();
			Game.proccess(deltaTime);
		}
		
	}
	
	protected static void calculateDeltaTime() {
		deltaTime = (int)(System.currentTimeMillis() - lastTime);
		lastTime = System.currentTimeMillis();
	}
}
package EngineUtils;

import java.nio.file.Path;
import java.nio.file.Paths;

import Game.ProjectSettings;
import Game.gameManager;
import Nodes.HitBox;
import Nodes.Vector;

public class Engine {	
	private static long lastTime;
	public static float deltaTime;
	
	//public static Input InputManager;
	public static Window CurrentWindow;	
	public static Path projectRoot = Paths.get("").toAbsolutePath();
	
	public static SceneTree sceneTree;
	
	public static HitBox[] hitboxes = new HitBox[0];
	
	public static void main(String[] args) {
		sceneTree = new SceneTree();
		
		CurrentWindow = new Window(ProjectSettings.Name);
		Input Inputmanager = new Input();
		CurrentWindow.addKeyListener(Inputmanager);
		gameManager Game = new gameManager();
		
		lastTime = System.currentTimeMillis();
		Game.ready();
		
		while(true) {
			calculateDeltaTime();
			Game.proccess(deltaTime);
			sceneTree.CalculateGlobals(new Vector(0.0,0.0));
			Input.proccess();
			
			sceneTree.drawChildren();
			
			for(int i = 0; i<hitboxes.length; i++) {
				hitboxes[i].updateCollision();
			}
		}
		
	}
	
	protected static void calculateDeltaTime() {
		deltaTime = (float)((System.currentTimeMillis() - lastTime) / 1000.0);
		lastTime = System.currentTimeMillis();
	}
}
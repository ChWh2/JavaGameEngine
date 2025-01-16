package Game;

import Basic2D.Vector2;
import EngineUtils.Engine;
import EngineUtils.Script;

public class gameManager extends Script{
	Player player;

	@Override
	public void ready() {
		player = new Player(Engine.CurrentWindow, new Vector2(0,0), new Vector2(100,100), 0.0);
	}
	
	@Override 
	public void proccess(float delta) {
		Vector2 inputDir = Engine.InputManager.getWASDInputAxis();
		player.move(inputDir.multiply(0.1 * delta));
		
		player.display();
	}

}

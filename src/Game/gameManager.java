package Game;

import Basic2D.Vector2;
import EngineUtils.Input;
import EngineUtils.Script;

public class gameManager extends Script{
	Player player;

	@Override
	public void ready() {
		player = new Player(new Vector2(0,0), new Vector2(100,100), 0.0);
		
		Input.createAction("Up", new char[]{'w', 'W'});
		Input.createAction("Down", new char[]{'s', 'S'});
		Input.createAction("Left", new char[]{'a', 'A'});
		Input.createAction("Right", new char[]{'d', 'D'});
	}
	
	@Override 
	public void proccess(float delta) {
		Vector2 inputDir = Input.getInputAxis("Up","Down","Left","Right");
		player.move(inputDir.multiply(0.1 * delta));
		
		player.display();
	}

}

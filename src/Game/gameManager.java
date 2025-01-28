package Game;

import java.nio.file.Paths;

import EngineUtils.Input;
import Nodes.HitBox;
import Nodes.Sprite;
import Nodes.Vector;

public class gameManager{
	Player player = new Player(new Vector(0,0), new Vector(100,100), 0.0);
	Sprite testSprite = new Sprite(new Vector(300,300), new Vector(100,100), 0.0);
	HitBox testBox = new HitBox(50);

	public void ready() {
		testSprite.texturePath = Paths.get("src\\Game\\player.png");
		testSprite.AddChild(testBox);
		
		//Create Inputs
		Input.createAction("Up", new char[]{'w'});
		Input.createAction("Down", new char[]{'s'});
		Input.createAction("Left", new char[]{'a'});
		Input.createAction("Right", new char[]{'d'});
	}
	
	public void proccess(float delta) {
		Vector inputDir = Input.getInputAxis("Up","Down","Left","Right");
		player.move(inputDir.multiply(100 * delta));
	}

}

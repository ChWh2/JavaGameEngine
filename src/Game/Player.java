package Game;

import java.awt.Rectangle;
import java.nio.file.Paths;

import EngineUtils.Engine;
import Nodes.HitBox;
import Nodes.Sprite;
import Nodes.Vector;

public class Player extends Sprite {
	
	HitBox hitbox;

	public Player(Vector position, Vector Size, double Rot) {
		super(position, Size, Rot);
		
		hitbox = new HitBox((Size.x+Size.y)/4);
		AddChild(hitbox);
		texturePath = Paths.get("src\\Game\\player.png");
	}
	public void move(Vector direction) {
		transform.position = transform.position.add(direction);
		wrap();
	}
	private void wrap() {
		Rectangle bounds = Engine.CurrentWindow.getBounds();
		if (transform.position.x < -transform.size.x/2.0) {
			transform.position.x = bounds.width -transform.size.x/2.0;
		}
		else if (transform.position.x > bounds.width - transform.size.x/2.0) {
			transform.position.x = -transform.size.x/2.0;
		}
		
		if (transform.position.y < -transform.size.y/2.0) {
			transform.position.y = bounds.height -transform.size.y/2.0;
		}
		else if (transform.position.y > bounds.height -transform.size.y/2.0) {
			transform.position.y = -transform.size.y/2.0;
		}
	}
}

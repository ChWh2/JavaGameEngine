package Game;

import java.awt.Rectangle;
import java.nio.file.Paths;

import Basic2D.Sprite;
import Basic2D.Vector2;
import EngineUtils.Window;

public class Player extends Sprite {

	public Player(Window window, Vector2 position, Vector2 Size, double Rot) {
		super(window, position, Size, Rot);
		
		texturePath = Paths.get("src\\Game\\player.png");
	}
	public void move(Vector2 direction) {
		transform.position = transform.position.add(direction);
		wrap();
	}
	private void wrap() {
		Rectangle bounds = currentDisplayWindow.getBounds();
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

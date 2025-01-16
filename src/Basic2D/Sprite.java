package Basic2D;

import java.awt.Image;
import java.nio.file.Path;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import EngineUtils.Engine;
import EngineUtils.Window;

public class Sprite extends Displayable{
	public Transform transform = new Transform();
	
	public Path texturePath;
	private Path path;
	
	private ImageIcon texture;
	
	private JLabel jLabel = new JLabel();
	
	@Override public void display() {
		if (texturePath != null) {
			path = Engine.projectRoot.resolve(texturePath);
			texture = new ImageIcon(path.toString());
			
			ImageIcon image = new ImageIcon(texture.getImage().getScaledInstance((int)transform.size.x, (int)transform.size.y, Image.SCALE_SMOOTH));
			jLabel.setIcon(image);
			
			currentDisplayWindow.add(jLabel);
			
			jLabel.setSize((int)transform.size.x, (int)transform.size.y);
			
			jLabel.setLocation((int)transform.position.x, (int)transform.position.y);
		}
	}
	
	public Sprite(Window window, Vector2 position, Vector2 Size, double Rot) {
		super(window);
				
		transform.position = position;
		transform.size = Size;
		transform.rotation = Rot;
	}
}

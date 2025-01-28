package Nodes;

import java.awt.Image;
import java.nio.file.Path;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import EngineUtils.Engine;

public class Sprite extends Displayable{	
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
			
			jLabel.setSize((int)transform.size.x, (int)transform.size.y);
			jLabel.setLocation((int)transform.globalPosition.x, (int)transform.globalPosition.y);
		}
	}
	
	public void setZOrder(int i) {
		Engine.CurrentWindow.setComponentZOrder(jLabel, i);
	}
	
	public Sprite(Vector position, Vector Size, double Rot) {
		super();
		transform.position = position;
		transform.size = Size;
		transform.rotation = Rot;
		
		Engine.CurrentWindow.add(jLabel);
	}
}

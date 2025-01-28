package EngineUtils;

import javax.swing.JFrame;

import Game.ProjectSettings;

public class Window extends JFrame{
	private static final long serialVersionUID = 1L;
		
	public Window(String name) {
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(ProjectSettings.resizable);
		setSize((int)ProjectSettings.defaultWindowSize.x,(int)ProjectSettings.defaultWindowSize.y);		
	}
}

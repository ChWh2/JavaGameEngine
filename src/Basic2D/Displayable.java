package Basic2D;

import EngineUtils.Window;

public class Displayable {
	public Window currentDisplayWindow;
	
	public void display() {
		System.out.println("display");
	}
	
	public Displayable(Window window) {
		currentDisplayWindow = window;
	}
}

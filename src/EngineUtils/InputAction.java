package EngineUtils;

public class InputAction {
	public String name;
	public char[] keys;
	
	public boolean isDown = false;
	public boolean isJustDown = false;
	
	InputAction(String Name, char[] Keys){
		name = Name;
		keys = Keys;
	}
}

package Game;

import Nodes.Vector;

public final record ProjectSettings() {
	public static String Name = "Game";
	public static Vector defaultWindowSize = new Vector(1000,500);
	public static boolean resizable = false;
}

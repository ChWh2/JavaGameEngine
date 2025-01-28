package Nodes;

import EngineUtils.Engine;
import EngineUtils.SceneTree;

public class Node {
	public Transform transform = new Transform();
	public Node Parent;
	public Node[] Children = new Node[0];
	
	public Node() {
		if(!(this instanceof SceneTree)) {
			Engine.sceneTree.AddChild(this);
		}
	}
	
	public void ready() {}
	
	public void process(float delta) {}
	
	public void AddChild(Node node) {
		Node oldParent = node.Parent;
		
		if (oldParent != null){
			Node[] oldParentnewChildren = new Node[oldParent.Children.length - 1];
			int forOffset = 0;
			for (int i = 0; i<oldParent.Children.length; i++) {
				if (oldParent.Children[i] != node) {
					oldParentnewChildren[i - forOffset] = oldParent.Children[i];
				}
				else {
					forOffset++;
				}	
			}
			oldParent.Children = oldParentnewChildren;
		}
		
		
		Node[] newChildren = new Node[Children.length + 1];
		for(int i = 0; i < Children.length; i++) {
			newChildren[i] = Children[i];
		}
		newChildren[Children.length] = node;
		Children = newChildren;
		
		node.Parent = this;
	} 
	
	public void CalculateGlobals(Vector global) {
		transform.globalPosition = transform.position.add(global);
		for(int i = 0; i<Children.length; i++) {
			Children[i].CalculateGlobals(transform.globalPosition);
		}
		
	}
	
	public void drawChildren() {
		for(int i = 0; i<Children.length; i++) {
			if(Children[i] instanceof Displayable) {
				((Displayable) Children[i]).display();
			}
			Children[i].drawChildren();
		}
	}
}

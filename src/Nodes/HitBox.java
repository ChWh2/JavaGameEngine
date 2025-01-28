package Nodes;

import EngineUtils.Engine;

public class HitBox extends Node {
	double radius = 0.0;
	
	boolean isColliding = false;
	
	public HitBox(double rad){
		radius = rad;
		
		HitBox[] newBoxList = new HitBox[Engine.hitboxes.length + 1];
		
		for(int i=0; i<Engine.hitboxes.length; i++) {
			newBoxList[i] = Engine.hitboxes[i];
		}
		newBoxList[Engine.hitboxes.length]= this;
		Engine.hitboxes = newBoxList;
	}
	
	public void finalize() {
		HitBox[] newBoxList = new HitBox[Engine.hitboxes.length - 1];
		
		int arrayOffset = 0;
		for(int i=0; i<Engine.hitboxes.length; i++) {
			if(Engine.hitboxes[i + arrayOffset] != this) {
				newBoxList[i] = Engine.hitboxes[i + arrayOffset];
			}
			else {
				arrayOffset++;
			}
		}
		Engine.hitboxes = newBoxList;
	}
	
	protected void Collided(HitBox Box) {};
	
	public void updateCollision() {
		isColliding = false;
		for(int i = 0; i<Engine.hitboxes.length; i++) {
			if(Engine.hitboxes[i] != this) {
				double distToOtherCenter = Engine.hitboxes[i].transform.globalPosition.distanceTo(transform.globalPosition);
				if(distToOtherCenter < radius + Engine.hitboxes[i].radius) {
					isColliding = true;
					Collided(Engine.hitboxes[i]);
				}
			}
		}
	}

	protected void Collided() {
		// TODO Auto-generated method stub
		
	}
}

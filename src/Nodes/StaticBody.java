package Nodes;

public class StaticBody extends HitBox {

	public StaticBody(double rad) {
		super(rad);
	}
	@Override protected void Collided(HitBox Box){
		if(!(Box instanceof StaticBody)) {
			
		}
	}
}

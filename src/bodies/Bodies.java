package bodies;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Bodies {

	
	public static Body createBuilding(float x, float y, World world, float width, float height){
		
		BodyDef bodyDef = new BodyDef();
		bodyDef.position.set(x,y);
		
		Body body = world.createBody(bodyDef);
		
		PolygonShape box = new PolygonShape();
		box.setAsBox(width, height);
		
		body.createFixture(box, 0);
		box.dispose();
		
		return body;
		
	}
	

	
}

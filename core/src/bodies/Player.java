package bodies;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class Player {
	String name="Player";

	public static Body create(float x, float y, World world){
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.DynamicBody;
		bodyDef.position.set(x,y);
		
		Body body = world.createBody(bodyDef);
		
		CircleShape circle = new CircleShape();
		circle.setRadius(0.5f);
		
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = circle;
		fixtureDef.density = 70/6.14f; 
		fixtureDef.friction = 0.4f;
		fixtureDef.restitution = 0f;
		
		@SuppressWarnings("unused")
		Fixture fixture = body.createFixture(fixtureDef);
		
		circle.dispose();
		
		body.setUserData(new Player());
		return body;
		
	}
}

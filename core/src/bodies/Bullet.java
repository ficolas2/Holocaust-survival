package bodies;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class Bullet {
	String name="Bullet";
	public static Body create(float x, float y, World world, float angle){
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.DynamicBody;
		bodyDef.position.set(x,y);
		
		Body body = world.createBody(bodyDef);
		
		CircleShape circle = new CircleShape();
		circle.setRadius(0.1f);
		
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = circle;
		fixtureDef.density = 0.1f; 
		fixtureDef.friction = 0.4f;
		fixtureDef.restitution = 0f;
		//fixtureDef.isSensor = true;
		
		@SuppressWarnings("unused")
		Fixture fixture = body.createFixture(fixtureDef);
		
		circle.dispose();
		
		body.setLinearVelocity((float) (Math.cos(angle)*1000f), (float) (Math.sin(angle)*1000f));
		body.setUserData(new Bullet());
		return body;

	}
	
}

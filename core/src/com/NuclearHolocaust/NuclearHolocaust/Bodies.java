package com.NuclearHolocaust.NuclearHolocaust;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class Bodies {

	
	public static Body createBuilding(int x, int y, World world, int width, int height){
		
		BodyDef bodyDef = new BodyDef();
		bodyDef.position.set(x,y);
		
		Body body = world.createBody(bodyDef);
		
		PolygonShape box = new PolygonShape();
		box.setAsBox(width, height);
		
		body.createFixture(box, 0);
		box.dispose();
		
		return body;
		
	}
	
	public static Body createBullet(int x, int y, World world){
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.DynamicBody;
		bodyDef.position.set(x,y);
		
		Body body = world.createBody(bodyDef);
		
		CircleShape circle = new CircleShape();
		circle.setRadius(2f);
		
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = circle;
		fixtureDef.density = 0.1f; 
		fixtureDef.friction = 0.4f;
		fixtureDef.restitution = 0f;
		
		@SuppressWarnings("unused")
		Fixture fixture = body.createFixture(fixtureDef);
		
		circle.dispose();
		
		return body;

	}
	
}

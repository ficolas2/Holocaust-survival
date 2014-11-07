package com.NuclearHolocaust.NuclearHolocaust;

import java.awt.Dimension;
import java.awt.Toolkit;

import logic.BodyRemoval;
import logic.ContactLis;
import rendering.Images;
import bodies.Bodies;
import bodies.Bullet;
import bodies.player.Player;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class NuclearHolocaust implements ApplicationListener {
	SpriteBatch batch;
	Texture img;
	long time=0;
	int x=1;
	public static World world;
	private Box2DDebugRenderer debugRenderer;
	private Camera camera;
	//private GUI GUI;
	
	Body building1;
	Body building2;
	Body bullet;
	Body character;
	
	public boolean isPaused(){
		/*if (GUI==null){
			return true;
		}*/
		return false;
	}
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		camera=new OrthographicCamera(screenSize.width/32, screenSize.height/32);
		
		Images.loadImage("badlogic.jpg");
		
		Gdx.app.setLogLevel(Application.LOG_INFO); //NONE/DEBUG/ERROR/INFO - Gdx.app.log/error/debug
		
		
		
		// VVV After the game is loaded/created VVV
		world = new World(new Vector2(0,0), true);
		world.setContactListener(new ContactLis());
		debugRenderer = new Box2DDebugRenderer();
		
		building1 = Bodies.createBuilding(0, 0, world, 5, 5);
		building2 = Bodies.createBuilding(0, 6f, world, 1, 1);
		bullet = Bullet.create(0, -10, world, (float) Math.PI/2);
		character = Player.create(0, 0, world);
		// Body.setUserData() to assign an object to that body, good for rendering. Then loop through
		//the bodies by using world.getBodies(Array). Linear damping to slow down. (rozamiento)
		
	}

	@Override
	public void render () {
		camera.position.set(character.getPosition().x, character.getPosition().y, 0);
		camera.update();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		
		
		batch.setProjectionMatrix(camera.combined);
		
		batch.begin();
		
		Images.draw(batch,0,0,0);
		batch.end();
		
		debugRenderer.render(world, camera.combined);
		
		Logic.playerMovement(character);
		
		//if (!paused){
			world.step(1/60f, 6, 2);
		//}
		
		BodyRemoval.remove();
		
	}
	
	@Override
	public void resize (int width, int height) {
		
	}
	
	@Override
	public void dispose(){
		
	}
	
	@Override
	public void pause (){
		
	}
	
	@Override
	public void resume(){
		
	}
	
	
}

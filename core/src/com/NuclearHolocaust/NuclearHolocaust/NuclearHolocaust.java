package com.NuclearHolocaust.NuclearHolocaust;

import java.awt.Dimension;
import java.awt.Toolkit;

import rendering.Images;

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
	public World world;
	private Box2DDebugRenderer debugRenderer;
	private Camera camera;
	
	Body building1;
	Body building2;
	Body bullet;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		camera=new OrthographicCamera(screenSize.width, screenSize.height);
		
		Images.loadImage("badlogic.jpg");
		
		Gdx.app.setLogLevel(Application.LOG_INFO); //NONE/DEBUG/ERROR/INFO - Gdx.app.log/error/debug
		
		
		
		// VVV After the game is loaded/created VVV
		world = new World(new Vector2(0,0), true);
		debugRenderer = new Box2DDebugRenderer();
		
		building1 = Bodies.createBuilding(-150, 0, world, 100, 100);
		building2 = Bodies.createBuilding(-150, 105, world, 5, 5);
		bullet = Bodies.createBullet(-150, -200, world);
		bullet.applyLinearImpulse(0, 100, bullet.getWorldCenter().x, bullet.getWorldCenter().y, true);
		
	}

	@Override
	public void render () {
		debugRenderer.render(world, camera.combined);
		Gdx.gl.glClearColor(0, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		debugRenderer.render(world, camera.combined);
		
		/*
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		Images.draw(batch,0,0,0);
		batch.end();
		*/
		
		
		// Only if the game has been loaded
		world.step(1/60, 6, 2);
		
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

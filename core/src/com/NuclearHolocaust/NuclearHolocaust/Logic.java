package com.NuclearHolocaust.NuclearHolocaust;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.physics.box2d.Body;

public class Logic {
	public static void playerMovement(Body Character){
		int x=0;
		int y=0;
		int speed=3;
		if (Gdx.input.isKeyPressed(Keys.CONTROL_LEFT)){
			speed=6;
		}
		if (Gdx.input.isKeyPressed(Keys.W)) {          
		     y+=speed;
		}
		if (Gdx.input.isKeyPressed(Keys.A)) {          
		     x-=speed;
		}
		if (Gdx.input.isKeyPressed(Keys.S)) {          
		     y-=speed;
		}
		if (Gdx.input.isKeyPressed(Keys.D)) {          
		     x+=speed;
		}
		Character.setLinearVelocity(x, y);
	}

}

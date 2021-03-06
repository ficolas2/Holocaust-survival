package logic;

import GUIs.InventoryGUI;
import bodies.player.Player;
import bodies.player.PlayerSpeedEnum;

import com.NuclearHolocaust.NuclearHolocaust.NuclearHolocaust;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.physics.box2d.Body;

public class KeyHandler {
	static boolean I=false;
	public static void playerMovement(Body Character){
		int x=0;
		int y=0;
		int speed=3;
		Player player=(Player) Character.getUserData();
		if (player.isAlive()){
			if (Gdx.input.isKeyPressed(Keys.CONTROL_LEFT) && Gdx.input.isKeyPressed(Keys.SHIFT_LEFT)){
				speed=3;
				player.setSpeed(PlayerSpeedEnum.WALKING);
			}else 
			if (Gdx.input.isKeyPressed(Keys.CONTROL_LEFT)){
				speed=6;
				player.setSpeed(PlayerSpeedEnum.RUNNING);
			}else
			if (Gdx.input.isKeyPressed(Keys.SHIFT_LEFT)){
				speed=1;
				player.setSpeed(PlayerSpeedEnum.SNEAKING);
			}
			else{
				player.setSpeed(PlayerSpeedEnum.WALKING);
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
			
			if (x==0 && y==0){
				player.setSpeed(PlayerSpeedEnum.IDLE);
			}
			
			Character.setLinearVelocity(x, y);
			
		}
	}

	public static void actionKeys() {
		
		if (Gdx.input.isKeyPressed(Keys.I)) {
			I=true;
		}else{
			if (I){
				I=false;
				if (NuclearHolocaust.GUI==null){
					NuclearHolocaust.GUI=new InventoryGUI();
				}else{
					if (NuclearHolocaust.GUI instanceof InventoryGUI){
						NuclearHolocaust.GUI=null;
					}
				}
			}
		}
		
	}

}

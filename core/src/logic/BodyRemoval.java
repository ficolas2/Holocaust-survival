package logic;

import java.util.ArrayList;

import com.NuclearHolocaust.NuclearHolocaust.NuclearHolocaust;
import com.badlogic.gdx.physics.box2d.Body;

public class BodyRemoval {
	private static ArrayList<Body> removeList = new ArrayList<Body>();;
	public static void mark(Body body){
		removeList.add(body);
	}
	public static void remove(){
		
		for (int i = 0;i < removeList.size();i++){
			NuclearHolocaust.world.destroyBody(removeList.get(i));
		}
	}
}

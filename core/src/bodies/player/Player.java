package bodies.player;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class Player {
	public String name="Player";
	private int health=100;
	private boolean alive=true;
	private PlayerSpeedEnum speed=PlayerSpeedEnum.IDLE;
	private PlayerInv inventory = new PlayerInv();

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
	public int damage(int amount){
		if (alive==true){
			health+=amount;
			if (health<=0){
				health=0;
				alive=false;
			}else if (health>100){
				health=100;
			}
			
			return health;	
		}
		return health;
	}
	public int getHealth(){
		return health;
	}
	public boolean isAlive(){
		return alive;
	}
	public void setSpeed(PlayerSpeedEnum sp){
		speed=sp;
	}
	public PlayerSpeedEnum getSpeed(){
		return speed;
	}
	public PlayerInv getInventory(){
		return inventory;
	}
}

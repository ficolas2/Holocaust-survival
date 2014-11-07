package logic;

import bodies.Bullet;
import bodies.player.Player;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

public class ContactLis implements ContactListener {
	
	@Override
	public void beginContact(Contact contact) {
		if (contact.getFixtureA().getBody() != null && contact.getFixtureA().getBody().getUserData() instanceof Bullet){
			if (contact.getFixtureB().getBody() != null && contact.getFixtureB().getBody().getUserData() instanceof Player){
				Player player=(Player) contact.getFixtureB().getBody().getUserData();
				player.damage(-100);
				BodyRemoval.mark(contact.getFixtureA().getBody());
			}else{
				BodyRemoval.mark(contact.getFixtureA().getBody());
			}
		}
		else 
		if (contact.getFixtureB().getBody() != null && contact.getFixtureB().getBody().getUserData() instanceof Bullet){
			if (contact.getFixtureA().getBody() != null && contact.getFixtureA().getBody().getUserData() instanceof Player){
				Player player=(Player) contact.getFixtureA().getBody().getUserData();
				player.damage(-100);
				BodyRemoval.mark(contact.getFixtureB().getBody());
			}else{
				BodyRemoval.mark(contact.getFixtureB().getBody());
			}
		}
		
	}

	@Override
	public void endContact(Contact contact) {
		
		
	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		
		
	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		
		
	}


}

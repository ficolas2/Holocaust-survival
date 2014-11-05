package logic;

import bodies.Bullet;
import bodies.Player;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

public class ContactLis implements ContactListener {
	
	@Override
	public void beginContact(Contact contact) {
		System.out.println("Contact");
		if (contact.getFixtureA().getBody() != null && contact.getFixtureA().getBody().getUserData() instanceof Bullet){
			System.out.println("Almost there 1");
			if (contact.getFixtureB().getBody() != null && contact.getFixtureB().getBody().getUserData() instanceof Player){
				System.out.println("dead");
				BodyRemoval.mark(contact.getFixtureA().getBody());
			}else{
				BodyRemoval.mark(contact.getFixtureA().getBody());
			}
		}
		else 
		if (contact.getFixtureB().getBody() != null && contact.getFixtureB().getBody().getUserData() instanceof Bullet){
			System.out.println("Almost there 2");
			if (contact.getFixtureA().getBody() != null && contact.getFixtureA().getBody().getUserData() instanceof Player){
				System.out.println("dead");
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

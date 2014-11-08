package logic;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class MouseLis extends InputListener {
	@Override
	public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
		 System.out.println("touch started at (" + x + ", " + y + ")");
		return false;
	}
	
	public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
        System.out.println("touch done at (" + x + ", " + y + ")");
	}
}

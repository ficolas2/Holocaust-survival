package GUIs;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class InventoryGUI extends GUI{
	
	Texture img=new Texture("badlogic.jpg");
	
	@Override
	public void draw(Batch batch) {
		
		batch.draw(img,0,0,img.getHeight(),img.getWidth());
		
	}

}

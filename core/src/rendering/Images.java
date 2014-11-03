package rendering;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class Images {
	static Array<Texture> images=new Array<Texture>();
	
	public static void loadImage(String path){
		images.add(new Texture(path));
	}

	public static void draw(SpriteBatch batch, int x, int y, int imageNumber) {
		batch.draw(images.get(imageNumber),x,y);
	}
}

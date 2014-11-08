package GUIs;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class InventoryGUI extends GUI{
	
	Texture tab=new Texture("inventorytab.png");
	Texture inventory=new Texture("inventory.png");
	
	@Override
	public void draw(Batch batch) {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		batch.draw(inventory,screenSize.width/6,-(inventory.getWidth()/2));
		this.drawTab(1, batch);
		this.drawTab(2, batch);
		this.drawTab(3, batch);
	}
	
	
	public void drawTab(int numb, Batch batch){
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		batch.draw(tab, screenSize.width/6+inventory.getWidth(), (inventory.getWidth()/2)+56-34*(numb-1));
		
	}
}

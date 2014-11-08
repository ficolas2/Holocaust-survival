
package items;

public abstract class Item {
	
	//Unique
	public abstract String getName();
	//image
	
	//Amount-related
	public abstract int getAmount();
	public abstract void changeAmount(int numb);
	
	//Weight-related
	public abstract int getWeight();
	
}

package bodies;

import items.Item;

public abstract class Inventory {
	
	
	//Weight-related
	public abstract int getWeight();
	public abstract boolean isFull();
	public abstract boolean canInsert(int weight);
	
	public abstract Item getItem(String str);
	public abstract void remove(Item item, int count);
	public abstract void insert(Item item, int count);
	
	
}

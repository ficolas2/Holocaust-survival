package bodies.player;

import java.util.ArrayList;

import items.Item;
import bodies.Inventory;

public class PlayerInv extends Inventory {
	
	private  ArrayList<Item> itemList = new ArrayList<Item>();
	private int maxWeight;
	
	public PlayerInv(){
		maxWeight=1000;
	}
	
	public void changeMaxWeight(int weight){
		maxWeight=weight;
	}
	
	@Override
	public int getWeight() {
		int weight=0;
		for (Object i:itemList.toArray()){
			weight+=((Item)i).getWeight();
		}
		return weight;
	}

	@Override
	public boolean isFull() {
		return(this.getWeight()>=maxWeight);
	}

	@Override
	public boolean canInsert(int weight) {
		return(maxWeight>=(this.getWeight()+weight));
	}

	@Override
	public Item getItem(String str) {
		for (Object i:itemList.toArray()){
			if (((Item)i).getName()==str){
				return (Item) i;
			}
		}
		return null;
	}

	@Override
	public void remove(Item item, int count) {
		for (Object i:itemList.toArray()){
			if (((Item)i).getName()==item.getName()){
				((Item) i).changeAmount(((Item) i).getAmount()-item.getAmount());
				return;
			}
		}
		
	}

	@Override
	public void insert(Item item, int count) {
		for (Object i:itemList.toArray()){
			if (((Item)i).getName()==item.getName()){
				((Item) i).changeAmount(((Item) i).getAmount()+item.getAmount());
				return;
			}
		}
		itemList.add(item);
	}
	
	
}

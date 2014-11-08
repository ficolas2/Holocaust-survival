package items;

public class Potato extends Item {

	private int amount;
	public final int sigleWeight=1;
	
	@Override
	public String getName() {
		return "Potato";
	}

	@Override
	public int getAmount() {
		return amount;
	}

	@Override
	public void changeAmount(int numb) {
		if (numb>0){
			amount=numb;
		}

	}

	@Override
	public int getWeight() {
		return (sigleWeight*amount);
	}

}

import java.util.ArrayList;

public class Player {
	
	private String id;
	private ArrayList<String> purchased;
	
	/**
	 * Constructor for Player
	 * @param s line from csv file
	 */
	public Player() {
		this.id = "0";
	}
	
	/**
	 * set the id from product
	 * @param id - long for player id
	 */
	public void setId(String id){
		this.id = id;
		purchased = new ArrayList<String>();
	}
	
	/**
	 * get the id from player
	 * @return long for player id
	 */
	public String getId(){
		return this.id;
	}
	

	public void addPurchase(String purchased){
		this.purchased.add(purchased);
	}
	
	@Override
	public int hashCode() {
		int h = 5;
		h = h * 7 + id.hashCode();
		return h;
	}
}

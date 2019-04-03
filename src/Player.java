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
		purchased = new ArrayList<String>();
	}
	
	/**
	 * set the id from product
	 * @param id - long for player id
	 */
	public void setId(String id){
		this.id = id;
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
	
	public void printPurchase(){
		for(int i = 0; i < purchased.size(); i++ ) {
			System.out.print(purchased.get(i) + " ");
			System.out.println();
		}
	}
	
}

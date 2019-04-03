import java.util.ArrayList;

public class Game {
	
	public final String name;
	public final int positive;
	public final int negative;	
	public final double price;

	/**
	 * Constructor for Game
	 * @param s line from csv file
	 */
	public Game(String s) {
		ArrayList<String> elements = Read.getElements(s);
		for(int i = 0; i < elements.size(); i++ ) {
			System.out.println(elements.get(i));
		}
		this.name = elements.get(2);
		this.positive = Integer.parseInt(elements.get(6));
		this.negative = Integer.parseInt(elements.get(7));
		this.price = Double.parseDouble(elements.get(14))/100;
	}
	
	@Override
	public int hashCode() {
		int h = 3;
		h = h * 5 + name.hashCode();
		return h;
	}
}

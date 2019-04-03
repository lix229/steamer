import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Read {
	
	//read game information
	public static ArrayList<Game> readGame() throws Exception {
		ArrayList<Game> games = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader("data/apiout.csv"));
		br.readLine();
		String s;
		while ((s = br.readLine())!= null) {
			games.add(new Game(s));
		}
		br.close();
		return games;
	}
	
	//read player information
	public static ArrayList<Player> readPlayer() throws Exception {
		ArrayList<Player> players = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader("data/steam-200k_purchase.csv"));
		String s;
		Player temp = new Player();
		s = br.readLine();
		ArrayList<String> start = Read.getElements(s);
		temp.setId(start.get(0));
		temp.addPurchase(start.get(1));
		while ((s = br.readLine())!= null) {
			ArrayList<String> elements = Read.getElements(s);
			//if id is different
			if(elements.get(0) != temp.getId()) {
				players.add(temp);
				temp.setId(elements.get(0));				
			}
			temp.addPurchase(elements.get(1));
		}
		br.close();
		return players;
	}
	
	//separate a line in a csv into string token
	public static ArrayList<String> getElements(String s) {
		
		ArrayList<String> elements = new ArrayList<>();
		String element = "";
		boolean inQuote = false; //boolean to check if the char is in the quote
		
		for (char c: s.toCharArray()) {
			if (c == ',') {
				if (inQuote == false) {
					elements.add(element);
					element = "";
				} else if (inQuote == true) {
					element += c;
				}
			} else if (c == '"') {
				if (inQuote == false) {
					inQuote = true;
				} else if (inQuote == true) {
					inQuote = false;
				}
			} else {
				element += c;
			}
		}
		elements.add(element);
		return elements;
	}

}

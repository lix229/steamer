import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws Exception {
		
		ArrayList<Game> games = Read.readGame();
		ArrayList<Player> players = Read.readPlayer();
		System.out.println("finish array");
		System.out.println(games.size());
		System.out.println(players.size());
		for (int i=0; i<players.size(); i++) {
			System.out.println(players.get(i).getId());
			players.get(i).printPurchase();
		}
		
		/*
		HashMap<String, Integer> gameMap = new HashMap<>();
		for (int i=0; i<games.size(); ++i) {
			String temp = games.get(i).name.replaceAll("[^A-Za-z0-9]", "");
			gameMap.put(temp, i);
		}*/
		
		/*
		HashMap<String, Integer> playerMap = new HashMap<>();
		for (int i=0; i<players.size(); ++i) {
			playerMap.put(players.get(i).getId(), i);
		}*/
		
		/*
		Graph gameGraph = Buildgraph.GameGraph(gameMap, playerMap, games,players );
		System.out.println("finish graph");
		*/
	}
}

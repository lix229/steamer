import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws Exception {
		
		ArrayList<Game> games = Read.readGame();
		ArrayList<Player> players = Read.readPlayer();
		System.out.println("finish array");
		
		HashMap<String, Integer> gameMap = new HashMap<>();
		for (int i=0; i<games.size(); ++i) {
			gameMap.put(games.get(i).name, i);
		}
		
		HashMap<String, Integer> playerMap = new HashMap<>();
		for (int i=0; i<players.size(); ++i) {
			playerMap.put(players.get(i).getId(), i);
		}
		
		Graph gameGraph = Buildgraph.GameGraph(gameMap, playerMap, games,players );
		System.out.println("finish graph");
	}
}

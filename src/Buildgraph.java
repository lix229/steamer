import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Buildgraph {
	
	//graph
	public static Graph GameGraph(HashMap<String, Integer> gameMap, HashMap<String, Integer> playerMap, ArrayList<Game> games, ArrayList<Player> players) throws Exception {

		Graph g = new Graph(games.size()+ players.size());

		BufferedReader br = new BufferedReader(new FileReader("data/steam-200k_play.csv"));
		String line;
		while ((line = br.readLine()) != null) {
			ArrayList<String> elements = Read.getElements(line);
			int from = gameMap.get(elements.get(1));
			System.out.println(from);
			int to = playerMap.get(elements.get(0));
			System.out.println(to);
			g.addEdge(new Edge(from, to, Double.parseDouble(elements.get(3))));
		}
		br.close();
		
		return g;
	}

}

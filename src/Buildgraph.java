import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class Buildgraph {
	
	//graph
	public static Graph GameGraph(HashMap<String, Integer> gameMap, HashMap<String, Integer> playerMap, ArrayList<Game> games, ArrayList<Player> players) throws Exception {

		Graph g = new Graph(games.size()+ players.size());

		BufferedWriter bw = new BufferedWriter(new FileWriter("data/error.txt"));
		BufferedReader br = new BufferedReader(new FileReader("data/output.csv"));
		String line;
		
		while ((line = br.readLine()) != null) {
			ArrayList<String> elements = Read.getElements(line);
			//System.out.println("Game is " + elements.get(1));
			
			String temp = elements.get(1).replaceAll("[^A-Za-z0-9]", "");
			temp = temp.toUpperCase();
			int from = 0;
			int to = 0;
			
			try {
				from = gameMap.get(temp);
				//System.out.println(from);
			}catch(Exception e){
				//System.out.println("Exception at game");
				//e.printStackTrace(System.err);
				bw.write("Exception at game" + elements.get(1));
				bw.newLine();
			}
			
			//System.out.println("player is " + elements.get(0));
			try {
				to = playerMap.get(elements.get(0));
				//System.out.println(to);
			}catch(Exception e){
				//System.out.println("Exception at player");
				//e.printStackTrace(System.err);
				bw.write("Exception at player" + elements.get(0));
				bw.newLine();
			}
			g.addEdge(new Edge(from, to, Double.parseDouble(elements.get(5))));
		}
		br.close();
		
		bw.close();
		return g;
	}

}

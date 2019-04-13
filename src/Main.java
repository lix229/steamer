import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws Exception {
		
		ArrayList<Game> games = Read.readGame();
		ArrayList<Player> players = Read.readPlayer();
		
		/*
		 * add games that are not in the database
		FileWriter pw = new FileWriter("data/apiout.csv",true); 
		BufferedReader error = new BufferedReader(new FileReader("data/error.txt"));
		String s;
		while ((s = error.readLine())!= null) {
			boolean test = false;
			for(int i = 0; i < games.size(); i++) {
				if(s.equals(games.get(i).name)) test = true;
			}
			if(test == false) {
				pw.append("unknow,unknow," + s +",unknow,unknow,,-1,-1,-1,unknow,-1,-1,-1,-1,-1,-1,-1");
				pw.append("\n");
				Game temp = new Game(s, -1);
				games.add(temp);
			}
			
		}
		error.close();
		pw.close();*/
		
		
		System.out.println("finish array");
		System.out.println(games.size());
		System.out.println(players.size());
		
		/*
		for (int i=0; i<games.size(); i++) {
			System.out.println(games.get(i).getName());
		}*/
		
		
		HashMap<String, Integer> gameMap = new HashMap<>();
		for (int i=0; i<games.size(); i++) {
			String temp = games.get(i).getName().replaceAll("[^A-Za-z0-9]", "");
			temp = temp.toUpperCase();
			gameMap.put(temp, i);
		}
		
		
		HashMap<String, Integer> playerMap = new HashMap<>();
		for (int i=0; i<players.size(); i++) {
			playerMap.put(players.get(i).getId(), games.size()+i);
		}
		
		
		Graph gameGraph = Buildgraph.GameGraph(gameMap, playerMap, games,players );
		System.out.println("finish graph");
		
	}
}

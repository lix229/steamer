import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.EventListenerList;


public class DetailsPanel extends JPanel {

	
	private static final long serialVersionUID = 6915622549267792262L;
	
	private EventListenerList listenerList = new EventListenerList();
	
	private Player currentPlayer = new Player();

	public DetailsPanel() throws Exception {
		
		ArrayList<Game> games = Read.readGame();
		ArrayList<Player> players = Read.readPlayer();
		
		Dimension size = getPreferredSize();
		size.width = 300;
		setPreferredSize(size);
		
		setBorder(BorderFactory.createTitledBorder("User input"));
		
		JLabel gameLable1 = new JLabel("Game 1: ");
		JLabel gameLabel2 = new JLabel("Game 2: ");
		JLabel gameLabel3 = new JLabel("Game 3: ");
		
		final JTextField gameField1 = new JTextField(10);
		final JTextField gameField2 = new JTextField(10);
		gameField2.setEditable(false);
		final JTextField gameField3 = new JTextField(10);
		gameField3.setEditable(false);
		
		
		JButton gameButton1 = new JButton("ADD");	
		gameButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name1 = gameField1.getText();
				if(!currentPlayer.isDuplicate(name1) && Search.binarySearch(games, 0, games.size()-1, name1) != -1) {
					System.out.println(Search.binarySearch(games, 0, games.size()-1, name1));
					currentPlayer.addPurchase(name1);
					gameField2.setEditable(true);
				}
				try {
					JOptionPane.showMessageDialog(new ErrorFrame("Invalid Entry"), "Entry not found, please try again.");
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
//				fireDetailEvent(new DetailEvent(this, name1));
			}
		});
		
		
		JButton gameButton2 = new JButton("ADD");
		gameButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name2 = gameField2.getText();
				if(!currentPlayer.isDuplicate(name2) && Search.binarySearch(games, 0, games.size()-1, name2) != -1) {
					currentPlayer.addPurchase(name2);
					gameField3.setEditable(true);
				}
				try {
					JOptionPane.showMessageDialog(new ErrorFrame("Invalid Entry"), "Entry not found, please try again.");
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton gameButton3 = new JButton("ADD");
		gameButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name3 = gameField2.getText();
				if(!currentPlayer.isDuplicate(name3)&& Search.binarySearch(games, 0, games.size()-1, name3) != -1) {
					currentPlayer.addPurchase(name3);
				}
				try {
					JOptionPane.showMessageDialog(new ErrorFrame("Invalid Entry"), "Entry not found, please try again.");
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
		});
		
		JButton genButton = new JButton("Generate");
		genButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
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
				
				Graph gameGraph = null;
				
				try {
					gameGraph = Buildgraph.GameGraph(gameMap, playerMap, games,players );
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				
				try {
					Buildgraph.addPlayer(gameGraph, currentPlayer, gameMap);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				double[] result = GraphAlgo.collaborative(gameGraph, games);
				
				int[] sorted = Sort.sort(result);
				
				String[] resultStrings = {(games.get(sorted[sorted.length - 4]).getName()), (games.get(sorted[sorted.length - 5]).getName()), (games.get(sorted[sorted.length - 6]).getName())};
//				resultStrings.add(games.get(sorted[sorted.length - 4]).getName());
//				resultStrings.add(games.get(sorted[sorted.length - 5]).getName());
//				resultStrings.add(games.get(sorted[sorted.length - 6]).getName());
				
//				String test = resultStrings[0];
//				System.out.println(test);
			
				for(int i =0; i < resultStrings.length; i++) {
					fireDetailEvent(new DetailEvent(this, resultStrings[i]));
				}
				
			}
		});
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		
		
		///First column
		
		gridBagConstraints.anchor = GridBagConstraints.LINE_END;
		
		gridBagConstraints.weightx = 0.25;
		gridBagConstraints.weighty = 0.25;
		
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		add(gameLable1, gridBagConstraints);
		
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		add(gameLabel2, gridBagConstraints);
		
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		add(gameLabel3, gridBagConstraints);
		
		// second column
		
		gridBagConstraints.anchor = GridBagConstraints.LINE_START;
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		add(gameField1, gridBagConstraints);
		
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		add(gameField2, gridBagConstraints);
		
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		add(gameField3, gridBagConstraints);
		
		
		 ///final column
//		gridBagConstraints.weighty = 10;
		
		gridBagConstraints.anchor = GridBagConstraints.LINE_START;
		
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 0;
		add(gameButton1, gridBagConstraints);
		
		gridBagConstraints.anchor = GridBagConstraints.LINE_START;
		
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 1;
		add(gameButton2, gridBagConstraints);
		
		gridBagConstraints.anchor = GridBagConstraints.LINE_START;
		
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;
		add(gameButton3, gridBagConstraints);
		
		// Generation button
		gridBagConstraints.anchor = GridBagConstraints.CENTER;
//		gridBagConstraints.weighty = 5;
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		add(genButton,gridBagConstraints);
		
		
	}
	
	public void fireDetailEvent(DetailEvent event) {
		Object [] listeners = listenerList.getListenerList();
		
		for (int i = 0; i < listeners.length; i += 2) {
			if(listeners[i] == DetailListener.class) {
				((DetailListener)listeners[i+1]).detailEventOccurred(event);
			}
		}
	}
	
	public void addDetailListener(DetailListener listener) {
		listenerList.add(DetailListener.class, listener);
	}
	
	public void removeDetailListener(DetailListener listener) {
		listenerList.remove(DetailListener.class, listener);
	}
}

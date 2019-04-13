import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DetailsPanel extends JPanel {
	public DetailsPanel() {
		Dimension size = getPreferredSize();
		size.width = 275;
		setPreferredSize(size);
		
		setBorder(BorderFactory.createTitledBorder("User input"));
		
		JLabel gameLable1 = new JLabel("Game 1: ");
		JLabel gameLabel2 = new JLabel("Game 2: ");
		JLabel gameLabel3 = new JLabel("Game 3: ");
		
		final JTextField gameField1 = new JTextField(10);
		final JTextField gameField2 = new JTextField(10);
		final JTextField gameField3 = new JTextField(10);
	
		
		JButton gameButton1 = new JButton("ADD");
		gameButton1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String name1 = gameField1.getText();
				
			}
		});
		
		
		JButton gameButton2 = new JButton("ADD");
		JButton gameButton3 = new JButton("ADD");
		
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
		
		
		 ///final row
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
		
		
		
		
	}
}

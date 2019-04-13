import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class App {
	
	public static void main(String[] args) {

		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame testFrame = null;
				try {
					testFrame = new MainFrame("STEAMER");
				} catch (Exception e) {
					e.printStackTrace();
				}
				testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				testFrame.setSize(600,350);
				testFrame.setVisible(true);
			}
		});

	};
}
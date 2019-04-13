import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App {
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame testFrame = new MainFrame("Test frame");
				testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				testFrame.setSize(700,350);
				testFrame.setVisible(true);
			}
		});

	}
}
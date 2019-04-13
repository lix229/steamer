import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class MainFrame extends JFrame {
	
	private DetailsPanel penal;
	
	public MainFrame(String title) {
		super(title);
		
		setLayout(new BorderLayout());
		
		JTextArea textArea = new JTextArea();
		JButton button = new JButton("Click");
		penal = new DetailsPanel();
		
		Container container = getContentPane();
		container.add(textArea, BorderLayout.CENTER);
		container.add(penal, BorderLayout.WEST);
		
	}
}

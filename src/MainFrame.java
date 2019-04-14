import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;


public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 2550139179038932026L;
	
	private DetailsPanel penal;
	
	
	public MainFrame(String title) throws Exception {
		super(title);
		
		setLayout(new BorderLayout());
		
		JTextArea textArea = new JTextArea();
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		penal = new DetailsPanel();
		
		penal.addDetailListener(new DetailListener() {
			public void detailEventOccurred(DetailEvent event) {
				String text = event.getResult();

				textArea.append(text + "\n");
			}
		});
		
		
		Container container = getContentPane();
		container.add(textArea, BorderLayout.CENTER);
		container.add(penal, BorderLayout.WEST);
		container.add(scrollPane, BorderLayout.EAST);
		
	}
}

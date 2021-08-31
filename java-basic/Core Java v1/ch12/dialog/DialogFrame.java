package dialog;

import javax.swing.*;

public class DialogFrame extends JFrame {
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFALT_HEIGHT = 200;
	private AboutDialog dialog;
	
	public DialogFrame() {
		setSize(DEFAULT_WIDTH, DEFALT_HEIGHT);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		// add About and Exit menu items.
		
		// The About item shows the about dialog
		
		JMenuItem aboutItem = new JMenuItem("About");
		aboutItem.addActionListener(event->{
			if (dialog == null) {
				dialog = new AboutDialog(DialogFrame.this);
			}
			dialog.setVisible(true);
		});
		fileMenu.add(aboutItem);
		
		// The Exit item exits the program.
		
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(event -> System.exit(0));
		fileMenu.add(exitItem);
	}
}

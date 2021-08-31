package plaf;
import javax.swing.*;

public class PlafFrame extends JFrame {
	private JPanel buttonPanel;
	
	public PlafFrame() {
		buttonPanel = new JPanel();
		
		UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
		for (UIManager.LookAndFeelInfo info : infos) {
			makeButton(info.getName(), info.getClassName());
		}
		
		add(buttonPanel);
		pack();
	}
	
	private void makeButton(String name, String className) {
		JButton button = new JButton(name);
		buttonPanel.add(button);
		
		// set button action
		
		button.addActionListener(event->{
			try {
				UIManager.setLookAndFeel(className);
				SwingUtilities.updateComponentTreeUI(this);
				pack();
			} catch(Exception e) {
				e.printStackTrace();
			}
		});
	}
}

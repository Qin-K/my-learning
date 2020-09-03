package dialog;
import javax.swing.*;
import java.awt.*;

public class AboutDialog extends JDialog {
	public AboutDialog(JFrame owner) {
		super(owner, "About DialogTest", true);
		
		add(new JLabel(
				"<html><h1><i>Core Java</i></h1><hr> By Qin-Kai </html>"), BorderLayout.CENTER);
		
		JButton ok = new JButton("OK");
		ok.addActionListener(event -> setVisible(false));
		
		JPanel panel = new JPanel();
		panel.add(ok);
		add(panel, BorderLayout.SOUTH);
		pack();
		
	}
}

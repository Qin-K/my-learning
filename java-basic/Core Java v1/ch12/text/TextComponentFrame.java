package text;
import javax.swing.*;
import java.awt.*;

public class TextComponentFrame extends JFrame{
	public static final int TEXTAREA_ROWS = 8;
	public static final int TEXTAREA_COLUMNS = 20;
	
	public TextComponentFrame() {
		JTextField textField = new JTextField();
		JPasswordField passwordField = new JPasswordField();
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(2, 2));
		northPanel.add(new JLabel("User name: ", SwingConstants.RIGHT));
		northPanel.add(textField);
		northPanel.add(new JLabel("Password: ", SwingConstants.RIGHT));
		northPanel.add(passwordField);
		
		add(northPanel, BorderLayout.NORTH);
		
		JTextArea textArea = new JTextArea(TEXTAREA_ROWS, TEXTAREA_COLUMNS);
		JScrollPane scrollPane = new JScrollPane(textArea);
		
		add(scrollPane, BorderLayout.CENTER);
		
		JPanel southPanel = new JPanel();
		
		JButton insertButton = new JButton("inset");
		southPanel.add(insertButton);
		insertButton.addActionListener(event->
				textArea.append("User name: " + textField.getText() + "Password: " 
						+ new String(passwordField.getPassword()) + "\n"));
		add(southPanel, BorderLayout.SOUTH);
		pack();
	}
}

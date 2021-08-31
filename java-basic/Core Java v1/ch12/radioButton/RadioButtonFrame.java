package radioButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RadioButtonFrame extends JFrame {
	private JPanel buttonPanel;
	private ButtonGroup group;
	private JLabel label;
	private static final int DEFAULT_SIZE = 36;
	
	public RadioButtonFrame() {
		// 添加标签
		label = new JLabel("The quick brown fox jumps over the lazy dog.");
		label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
		add(label, BorderLayout.CENTER);
		
		// 添加单选按钮
		buttonPanel = new JPanel();
		group = new ButtonGroup();
		
		addRadioButton("Small", 8);
		addRadioButton("Medium", 12);
		addRadioButton("Large", 18);
		addRadioButton("Extra larg", 36);
		
		add(buttonPanel, BorderLayout.SOUTH);
		pack();
	}
	public void addRadioButton(String name, int size) {
		boolean selected = size == DEFAULT_SIZE;
		JRadioButton button = new JRadioButton(name, selected);
		group.add(button);
		buttonPanel.add(button);
		
		ActionListener listener = event -> label.setFont(new Font("Serif", Font.PLAIN, size));
		
		button.addActionListener(listener);
	}
}

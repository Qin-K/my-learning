package checkBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckBoxFrame extends JFrame {
	private JLabel label;
	private JCheckBox bold;
	private JCheckBox italic;
	private static final int FONTSIZE = 24;
	
	public CheckBoxFrame() {
		// 添加一个标签
		label = new JLabel("The quick brown fox jumps over the lazy dog.");
		label.setFont(new Font("Serif", Font.BOLD, FONTSIZE));
		add(label, BorderLayout.CENTER);
		
		// 创建事件监听
		ActionListener listener = event->{
			int mode = 0;
			if (bold.isSelected()) mode += Font.BOLD;
			if (italic.isSelected()) mode += Font.ITALIC;
			label.setFont(new Font("Serif", mode, FONTSIZE));
		};
		
		// 添加复选按钮
		JPanel buttonPanel = new JPanel();
		
		bold = new JCheckBox("Bold");
		bold.addActionListener(listener);
		bold.setSelected(true);
		buttonPanel.add(bold);
		
		italic = new JCheckBox("Italic");
		italic.addActionListener(listener);
		buttonPanel.add(italic);
		
		add(buttonPanel, BorderLayout.SOUTH);
		pack();
		
	}
}
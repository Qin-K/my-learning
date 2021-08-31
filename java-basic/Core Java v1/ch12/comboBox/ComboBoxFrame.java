package comboBox;
import java.awt.*;
import javax.swing.*;

public class ComboBoxFrame extends JFrame {
	private JComboBox<String> faceCombo;
	private JLabel label;
	private static final int DEFAULT_SIZE = 24;
	
	public ComboBoxFrame() {
		// 添加文本标签
		
		label = new JLabel("The quick brown fox jumps over the lazy dog.");
		label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
		add(label, BorderLayout.CENTER);
		
		// 添加组合框和face名字
		faceCombo = new JComboBox<>();
		faceCombo.addItem("Serif");
		faceCombo.addItem("SansSerif");
		faceCombo.addItem("Monospaced");
		faceCombo.addItem("Dialog");
		faceCombo.addItem("DialogInput");
		
		// 添加事件监听改变字体
		
		faceCombo.addActionListener(event->
		label.setFont(new Font(faceCombo.getItemAt(faceCombo.getSelectedIndex()), Font.PLAIN, DEFAULT_SIZE)));
		
		JPanel comboPanel = new JPanel();
		comboPanel.add(faceCombo);
		add(comboPanel, BorderLayout.SOUTH);
		pack();
	}
}

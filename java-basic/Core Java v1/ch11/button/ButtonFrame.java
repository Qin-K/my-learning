package button;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonFrame extends JFrame {
	private JPanel buttonPanel;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	public ButtonFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		// 创建按钮
		JButton yellowButton = new JButton("Yellow");
		JButton blueButton = new JButton("Bule");
		JButton redButton = new JButton("Red");
		
		// 创建面板
		buttonPanel = new JPanel();
		
		// 把按钮添加到面板
		buttonPanel.add(yellowButton);
		buttonPanel.add(blueButton);
		buttonPanel.add(redButton);
		
		// 将面板添加到框架
		add(buttonPanel);
		
		// 创建按钮actions
		ColorAction yellowAction = new ColorAction(Color.YELLOW);
		ColorAction blueAction = new ColorAction(Color.BLUE);
		ColorAction redAction = new ColorAction(Color.RED);
		
		// 将actions与按钮相关联
		yellowButton.addActionListener(yellowAction);
		blueButton.addActionListener(blueAction);
		redButton.addActionListener(redAction);
		
	}
	
	/**
	 * 一个事件监听内部类
	 */
	private class ColorAction implements ActionListener{
		private Color backgroudColor;
		
		public ColorAction(Color c) {
			backgroudColor = c;
		}
		public void actionPerformed(ActionEvent event) {
			buttonPanel.setBackground(backgroudColor);
		}
	}
}

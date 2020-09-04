package action;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.peer.ButtonPeer;

import javax.swing.event.*;

public class ActionFrame extends JFrame {
	private JPanel buttonPanel;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	public ActionFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		buttonPanel = new JPanel();
		
		// 定义事件
		Action yellowAction = new ColorAction("Yellow", new ImageIcon("icon.png"), Color.YELLOW);
		Action blueAction = new ColorAction("Blue", new ImageIcon("icon.png"), Color.BLUE);
		Action redAction = new ColorAction("Red", new ImageIcon("icon.png"), Color.RED);
		
		// 为这些事件添加按钮并添加到面板
		buttonPanel.add(new JButton(yellowAction));
		buttonPanel.add(new JButton(blueAction));
		buttonPanel.add(new JButton(redAction));
		
		// 将面板添加到框架
		add(buttonPanel);
		
		// 将动作键和名字相联系
		InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		imap.put(KeyStroke.getKeyStroke("ctrl Y"), "panel.yellow");
		imap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.blue");
		imap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");
		
		// 将名字和事件相联系
		ActionMap amap = buttonPanel.getActionMap();
		amap.put("panel.yellow", yellowAction);
		amap.put("panel.blue", blueAction);
		amap.put("panel.red", redAction);
		
	}

	public class ColorAction extends AbstractAction{
		/**
		 * 
		 */
		public ColorAction(String name, Icon icon, Color c) {
			putValue(Action.NAME, name);
			putValue(Action.SMALL_ICON, icon);
			putValue(Action.SHORT_DESCRIPTION, "Set panel color to " + name.toLowerCase());
			putValue("color", c);
		}
		public void actionPerformed(ActionEvent event) {
			Color c = (Color)getValue("color");
			buttonPanel.setBackground(c);
		}
	
	}	
}
package ch12;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyDrawPanel extends JPanel{
	public void paintComponent(Graphics g) {
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		int red = (int)(Math.random()*255);
		int green = (int)(Math.random()*255);
		int bule = (int)(Math.random()*255);
		
		Color randomColor = new Color(red, green, bule);
		
		g.setColor(randomColor);
		g.fillOval(70, 70, 100, 100);
	}
}

public class SimpleGui3C implements ActionListener {
	JFrame frame;
	public static void main(String[] args) {
		SimpleGui3C gui = new SimpleGui3C();
		gui.go();
	}
	public void go() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 创建一个按钮
		JButton button = new JButton("Change colors");

		// 把监听加到按钮上
		button.addActionListener(this);
		
		MyDrawPanel drawPanel = new MyDrawPanel();
		
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		
		frame.repaint();
		
	}
}

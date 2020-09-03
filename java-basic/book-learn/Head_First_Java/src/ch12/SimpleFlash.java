package ch12;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SimpleFlash {
	JFrame frame;
	int x = 20;
	int y = 50;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleFlash gui = new SimpleFlash();
		gui.go();
	}
	void go() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyDrawPanel drawPanel = new MyDrawPanel();
		frame.getContentPane().add(drawPanel);
		
		frame.setSize(300, 300);
		frame.setVisible(true);
		for (int i = 0; i < 130; i++) {
			drawPanel.repaint();
			x++;
			y++;
			try {
				Thread.sleep(50);
			} catch (Exception ex) {
				// TODO Auto-generated catch block
			}
		}
	}
	class MyDrawPanel extends JPanel {
		public void paintComponent(Graphics g) {
			g.setColor(Color.white);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			
			g.setColor(Color.orange);
			g.fillOval(x, y, 40, 40);
		}
	}

}

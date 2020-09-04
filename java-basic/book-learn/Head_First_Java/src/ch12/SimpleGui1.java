package ch12;
import javax.swing.*;
public class SimpleGui1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		JButton button = new JButton("click me");
		
		// 会在window关闭时把程序结束掉
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 把button加到frame的pane上
		frame.getContentPane().add(button);
		
		// 设定frame的大小
		frame.setSize(300, 300);
		
		// 把frame显示出来
		frame.setVisible(true);
	}

}

package ch12;
import javax.swing.*;
public class SimpleGui1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		JButton button = new JButton("click me");
		
		// ����window�ر�ʱ�ѳ��������
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// ��button�ӵ�frame��pane��
		frame.getContentPane().add(button);
		
		// �趨frame�Ĵ�С
		frame.setSize(300, 300);
		
		// ��frame��ʾ����
		frame.setVisible(true);
	}

}

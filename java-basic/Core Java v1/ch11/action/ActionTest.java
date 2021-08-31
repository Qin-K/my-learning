package action;

import java.awt.*;
import javax.swing.*;

public class ActionTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			JFrame frame = new ActionFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}

}

package menu;
import javax.swing.*;
import java.awt.*;

public class MenuTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			JFrame frame = new MenuFrame();
			frame.setTitle("MenuTest");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}

}

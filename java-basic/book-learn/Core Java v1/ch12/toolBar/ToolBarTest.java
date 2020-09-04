package toolBar;
import javax.swing.*;
import java.awt.*;

public class ToolBarTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			JFrame frame = new ToolBarFrame();
			frame.setTitle("ToolBarTest");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}

}

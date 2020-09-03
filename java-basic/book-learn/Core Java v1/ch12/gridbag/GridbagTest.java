package gridbag;
import java.awt.*;
import javax.swing.*;

public class GridbagTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			JFrame frame = new FontFrame();
			frame.setTitle("GridbagTest");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}

}

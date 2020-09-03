package border;
import javax.swing.*;
import java.awt.*;

public class BorderTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			JFrame frame = new BorderFrame();
			frame.setTitle("BorderTest");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}

}

package text;
import javax.swing.*;
import java.awt.*;

public class TextTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			JFrame frame = new TextComponentFrame();
			frame.setTitle("TextTest");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}

}

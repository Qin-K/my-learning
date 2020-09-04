package radioButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RadioButtonTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			JFrame frame = new RadioButtonFrame();
			frame.setTitle("RadioButtonTest");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}

}

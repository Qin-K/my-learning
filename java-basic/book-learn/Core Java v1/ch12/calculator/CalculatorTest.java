package calculator;
import javax.swing.*;
import java.awt.*;

public class CalculatorTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			JFrame frame = new JFrame();
			frame.add(new CalculatorPanel());
			frame.pack();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}

}
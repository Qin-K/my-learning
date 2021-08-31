package dataExchange;
import javax.swing.*;
import java.awt.*;

public class DataExchangeText {

	public static void main(String[] args) {
		EventQueue.invokeLater(()-> {
			JFrame frame = new DataExchangeFrame();
			frame.setTitle("DataExchangeTest");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}

}

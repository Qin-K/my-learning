package ch13;
import javax.swing.*;
import java.awt.event.*;
public class CheckBox implements ItemListener{
	JCheckBox check;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckBox gui = new CheckBox();
		gui.go();
	}
	public void go() {
		JFrame frame = new JFrame();
		
		JCheckBox check = new JCheckBox("Goes to 11");
		check.addItemListener(this);
		
		frame.getContentPane().add(check);
		
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
	@Override
	public void itemStateChanged(ItemEvent ev) {
		// TODO Auto-generated method stub
		String onOrOff = "off";
/*		if (check.isSelected())
			onOrOff = "on";*/
		System.out.println("Check box is " + onOrOff);
	}

}

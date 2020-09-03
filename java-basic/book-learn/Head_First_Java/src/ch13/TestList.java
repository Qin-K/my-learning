package ch13;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class TestList implements ListSelectionListener {
	JList list;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestList gui = new TestList();
		gui.go();
	}
	public void go() {
		JFrame frame = new JFrame();
		String[]  listEntries = {"qinkai", "mabingqiang", "luoxingzhang", "lushuangquan", "liujunjie"};
		
		list = new JList(listEntries);
		list.setVisibleRowCount(4);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(this);
		
		JScrollPane scroller = new JScrollPane(list);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JPanel panel = new JPanel();
		panel.add(scroller);
		
		frame.getContentPane().add(panel);
		frame.setSize(300,300);
		frame.setVisible(true);
	}

	@Override
	public void valueChanged(ListSelectionEvent lse) {
		// TODO Auto-generated method stub
		if (!lse.getValueIsAdjusting()) {
			String selection = (String) list.getSelectedValue();
			System.out.println(selection);
		}
	}

}

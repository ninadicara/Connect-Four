package defaultpackage;

import javax.swing.JFrame;


public class C4Frame extends JFrame {

	private C4Panel panel;
	
	//creates the outer JFrame to hold JPanels
	public C4Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Connect Four (by Nina Di Cara)");
		panel = new C4Panel();
		add(panel);

	}

}

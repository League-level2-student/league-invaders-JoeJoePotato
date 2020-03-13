import java.awt.Dimension;

import javax.swing.JFrame;

public class Runner {
	public static final int WIDTH=1000;
	public static final int HEIGHT=700;
	static JFrame frame;
	
	public static void main(String[] args) {
	Runner l=new Runner(new JFrame());
l.setup();
	}
	
	Runner(JFrame frame) {
		 this.frame=frame;

}
	public void setup() {
		Dimension d=new Dimension(WIDTH,HEIGHT);
		GamePanel panel=new GamePanel();
		frame.add(panel);
		frame.setPreferredSize(d);
		frame.addKeyListener(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	frame.pack();
	}
}

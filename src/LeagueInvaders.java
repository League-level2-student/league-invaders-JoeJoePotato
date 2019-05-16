import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	public static final int WIDTH=500;
	public static final int HEIGHT=800;
JFrame frame=new JFrame();
	public static void main(String[] args) {
		LeagueInvaders l=new LeagueInvaders();
		l.setup();
}
	public void setup() {
		Dimension d=new Dimension(WIDTH,HEIGHT);
		frame.setPreferredSize(d);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	frame.pack();
	}
}

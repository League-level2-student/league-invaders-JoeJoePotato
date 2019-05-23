import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	public static final int WIDTH=500;
	public static final int HEIGHT=800;
	static JFrame frame;
	
	public static void main(String[] args) {
	LeagueInvaders l=new LeagueInvaders(new JFrame());
l.setup();
	}
	
	LeagueInvaders(JFrame frame) {
		 this.frame=frame;

}
	public void setup() {
		Dimension d=new Dimension(WIDTH,HEIGHT);
		GamePanel panel=new GamePanel();
		frame.add(panel);
		frame.setPreferredSize(d);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	frame.pack();
	}
}

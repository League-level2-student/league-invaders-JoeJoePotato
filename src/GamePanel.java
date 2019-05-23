import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener{
	final int MENU = 0;
	final int GAME = 1;

	final int END = 2;
	int currentstate = MENU;
Font titleFont=new Font("Arial", Font.PLAIN, 48);
Font otherFont=new Font("Arial",Font.PLAIN,20);
Timer frameDraw;	
GamePanel(){
	frameDraw = new Timer(1000/60,this);
    frameDraw.start();
}
public void updateMenuState() {
	}

	public void updateGameState() {
	}

	public void updateEndState() {
	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 40, 70);
		g.setFont(otherFont);
		g.setColor(Color.YELLOW);
		g.drawString("Press ENTER to start -or- press SPACE for instructions", 5, 400);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("GAME OVER", 50, 70);
	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentstate == MENU) {
			drawMenuState(g);
		} else if (currentstate == GAME) {
			drawGameState(g);
		} else if (currentstate == END) {
			drawEndState(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentstate == MENU){
		    updateMenuState();
		}else if(currentstate == GAME){
		    updateGameState();
		}else if(currentstate == END){
		    updateEndState();
		}
		repaint();
		System.out.println("action");
	}
}

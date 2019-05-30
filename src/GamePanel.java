import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
	final int GAME = 1;

	final int END = 2;
	int currentstate = MENU;
	int x;
	int y;
	Rocketship r = new Rocketship(250, 700, 50, 50);
	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	Font otherFont = new Font("Arial", Font.PLAIN, 20);
	Timer frameDraw;

	GamePanel() {
		frameDraw = new Timer(1000 / 60, this);
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
	r.draw(g);
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
		if (currentstate == MENU) {
			updateMenuState();
		} else if (currentstate == GAME) {
			updateGameState();
		} else if (currentstate == END) {
			updateEndState();
		}
		repaint();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyCode());

		if (currentstate == GAME) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				System.out.println("UP");
			r.up();
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				System.out.println("DOWN");
			r.down();
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				System.out.println("LEFT");
			r.left();
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				System.out.println("RIGHT");
			r.right();
			}
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyCode());
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentstate == END) {
				currentstate = MENU;
			} else {
				currentstate++;
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	

	final int MENU = 0;
	final int GAME = 1;

	final int END = 2;
	public int currentstate = MENU;
	int x;
	int y;
	Rocketship r = new Rocketship(250, 700, 50, 50);
	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	Font otherFont = new Font("Arial", Font.PLAIN, 20);
	Timer frameDraw;
	Timer alienSpawn;
	ObjectManager o=new ObjectManager(r); 
	GamePanel() {
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
		if (needImage) {
		    loadImage ("space.png");
		}
	
	
	}

	public void startGame() {
	    alienSpawn = new Timer(1000 , o);
	    alienSpawn.start();
	    r.isActive=true;
	}
	
	public void updateMenuState() {

	}

	public void updateGameState() {
		
		o.update();
	if(r.isActive==false) {
		
		alienSpawn.stop();
		currentstate=END;
	}
	
	}

	public void updateEndState() {
	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, Runner.WIDTH, Runner.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 40, 70);
		g.setFont(otherFont);
		g.setColor(Color.YELLOW);
		g.drawString("Press ENTER to start -or- press SPACE for instructions", 5, 400);
	
	}

	void drawGameState(Graphics g) {
		
		
		g.setColor(Color.BLACK);
		if (gotImage) {
			g.drawImage(image, 0, 0, Runner.WIDTH, Runner.HEIGHT, null);
			
			
		}
		o.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, Runner.WIDTH, Runner.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("GAME OVER\nyou killed "+o.getScore()+"aliens", 50, 70);
	
}

	
	
	
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
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

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (currentstate == GAME) {
			if (e.getKeyCode() == 38) {
			
				r.up();
			} else if (e.getKeyCode() == 40) {
		
				r.down();
			} else if (e.getKeyCode() == 37) {
	
				r.left();
			} else if (e.getKeyCode() == 39) {
			
				r.right();
			} else {
				r.slowdown();

			}
		if (e.getKeyCode()==32) {
			
		
			o.addProjectile(o.getProjectile());
		}
		}

		if (e.getKeyCode() == KeyEvent.VK_ENTER ) {
			if (currentstate == END) {
				currentstate = MENU;
				
			}else {
				if(currentstate==MENU) {
					startGame();
								}
				currentstate++;
			
			}
			
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}

import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject{
	public boolean isActive;
	Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	
	}
	void update() {
		int speed=1;
		y-=speed;
	}
	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x,y,width,height);
	}
}

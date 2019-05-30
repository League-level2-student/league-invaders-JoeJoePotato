import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{


		Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

		// TODO Auto-generated constructor stub
		public void right() {
	        x+=29;
	    }
		public void left() {
	        x-=3;
	    }
		public void up() {
	        y-=3;
	    }
		public void down() {
	        y+=3;
	    }

void draw(Graphics g) {
	g.setColor(Color.BLUE);
	g.fillRect(x,y,width,height);
}
}

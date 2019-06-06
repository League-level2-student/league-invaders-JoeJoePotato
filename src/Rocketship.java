import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{


		Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

		// TODO Auto-generated constructor stub
		int velocity=0;
		public void right() {
	        velocity++;
			x+=3*velocity;
	    }
		public void left() {
			x-=3*velocity;
	    }
		public void up() {
	        y-=3*velocity;
	    }
		public void down() {
	        y+=3*velocity;
	    }
		public void slowdown(){
			if(velocity>=1) {
			velocity=0;
			}
			}

void draw(Graphics g) {
	g.setColor(Color.BLUE);
	g.fillRect(x,y,width,height);
}
}

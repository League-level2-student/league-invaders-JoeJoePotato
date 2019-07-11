import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends GameObject{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	

		Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		if (needImage) {
		    loadImage ("rocket.png");
		}
		}
void update() {
    collisionbox.setBounds(x, y, width, height);
}
		// TODO Auto-generated constructor stub
		int velocity=0;
		public void right() {
	        velocity++;
			x+=3*velocity;
	    }
		public void left() {
			velocity++;
			x-=3*velocity;
	    }
		public void up() {
			velocity++;
			y-=3*velocity;
	    }
		public void down() {
			velocity++;
			y+=3*velocity;
	    }
		public void slowdown(){
			if(velocity>=1) {
			velocity=0;
			}
			}
		int getX(){
			return x;
		}
		
		int getY(){
			return y;
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
		
void draw(Graphics g) {
	
	g.setColor(Color.BLUE);

	if (gotImage) {
		g.drawImage(image, x, y, width, height, null);
	} else {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
}
}

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public abstract class character extends GameObject{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	

		character(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		if (needImage) {
		    loadImage ("rocket.png");
		}
		}
		abstract Projectile leftArrow();
		abstract Projectile rightArrow();
		abstract void upArrow();
		abstract void downArrow();
		
		
		
		
		
void update() {
    collisionbox.setBounds(x, y, width, height);
}
		// TODO Auto-generated constructor stub
		
		

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

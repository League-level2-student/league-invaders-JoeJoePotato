import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	 Rocketship spaaace;
	ArrayList<Projectile> list = new ArrayList<Projectile>();
	ArrayList<Alien> ufos = new ArrayList<Alien>();
int points=0;
	
	ObjectManager(Rocketship spaaace) {
	
		this.spaaace = spaaace;
	
	}

	 int getScore() {
		 int score=points;
	return score;
	 }
	
	void addProjectile(Projectile p) {
		list.add(p);
	}

	void addAlien() {
		Random r = new Random();
		ufos.add(new Alien(r.nextInt(Runner.WIDTH), 0, 50, 50));
	}

	void checkCollision() {
		for (int z = 0; z < ufos.size(); z++) {
		Alien zed=ufos.get(z) 	;
		
		if(spaaace.collisionbox.intersects(zed.collisionbox)) {
			spaaace.isActive=false;
			zed.isActive=false;
			ufos.clear();
			list.clear();
		
		}
		for (int k = 0; k < list.size(); k++) {
			Projectile p=list.get(k);
		if(p.collisionbox.intersects(zed.collisionbox)) {
			zed.isActive=false;
			p.isActive=false; 
		points++;
		}
		}
		
		}
	}
	
	void update() {
		
		for (int i = 0; i < ufos.size(); i++) {
			Alien joe = ufos.get(i);
			if (joe.y > Runner.HEIGHT) {
				joe.isActive = false;
			}
joe.update();
		}	for (int j = 0; j < list.size(); j++) {
				Projectile hey = list.get(j);
				if (hey.y > Runner.HEIGHT) {
					hey.isActive = false;
				}
				hey.update();
			}
		spaaace.update();
		
		checkCollision();
		purge();
	}

	void purge() {
		for (int i = 0; i < ufos.size(); i++) {
			Alien joe = ufos.get(i);
			if (joe.isActive == false) {
				ufos.remove(i);
			}
		}
			for (int j = 0; j < list.size(); j++) {
				Projectile hey = list.get(j);
				if (hey.isActive == false) {
					list.remove(j);
				}
			}
		
	}

	void draw(Graphics g) {
		spaaace.draw(g);

		for (int i = 0; i < ufos.size(); i++) {
			Alien joe = ufos.get(i);
			joe.draw(g);

		}
		for (int j = 0; j < list.size(); j++) {
			Projectile hey = list.get(j);
			hey.draw(g);
		}

	}

	public Projectile getProjectile() {
		return new Projectile(spaaace.getX() + spaaace.width / 2, spaaace.getY(), 10, 10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();

	}
}

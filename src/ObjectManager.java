import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	Rocketship spaaace;
	ArrayList<Projectile> list = new ArrayList<Projectile>();
	ArrayList<Alien> ufos = new ArrayList<Alien>();

	
	ObjectManager(Rocketship spaaace) {
	
		this.spaaace = spaaace;
	
	}

	void addProjectile(Projectile p) {
		list.add(p);
	}

	void addAlien() {
		Random r = new Random();
		ufos.add(new Alien(r.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
	}

	void update() {
		
		for (int i = 0; i < ufos.size(); i++) {
			Alien joe = ufos.get(i);
			if (joe.y > LeagueInvaders.HEIGHT) {
				joe.isActive = false;
			}
joe.update();
		}	for (int j = 0; j < list.size(); j++) {
				Projectile hey = list.get(j);
				if (hey.y > LeagueInvaders.HEIGHT) {
					hey.isActive = false;
				}
				hey.update();
			}
		
	}

	void purge() {
		for (int i = 0; i < ufos.size(); i++) {
			Alien joe = ufos.get(i);
			if (joe.isActive = false) {
				ufos.remove(i);
			}

			for (int j = 0; j < list.size(); j++) {
				Projectile hey = list.get(j);
				if (hey.isActive = false) {
					list.remove(j);
				}
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
System.out.println("uhhhhhhhhhhhhhhh");
	}
}

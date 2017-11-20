package jambogame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;

//@SuppressWarnings("serial")
public class GameMenu extends GameState implements ActionListener {

	int screenWidth = 800, screenHeight = 600;
	Player player;

	public GameMenu(Renderer Render, StateManager Controller) {
		super(Render, Controller);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// put repaint in here?

	}

	void notes() {
	}

	@Override
	public void Pause() {
		
	}

	@Override
	public void Resume() {
		
	}

	@Override
	public void Draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		// Background
		// draw the sky
		g2.setColor(Color.cyan);
		g2.fillRect(0, 0, 800, 600);
		// draws grass
		g2.setColor(Color.GREEN);
		g2.fillRect(0, 550, 800, 100);
		// draws sun
		g2.setColor(Color.YELLOW);
		g2.fill(new Ellipse2D.Double(550, -200, 400, 400));
		// Shodow
		g2.setColor(Color.LIGHT_GRAY);
		g2.fill(new Ellipse2D.Double(455, 560, 275, 30));
		// Ball
		g2.setColor(Color.BLACK);
		g2.fill(new Ellipse2D.Double(480, 275, 300, 300));

		// Menu options
		// first button
		g2.setColor(Color.BLACK); // the extra elipse gives the black border
		Ellipse2D elipse1_2 = new Ellipse2D.Double(49, 49, 402, 77);
		g2.fill(elipse1_2);
		g2.setColor(Color.WHITE);
		Ellipse2D elipse1 = new Ellipse2D.Double(50, 50, 400, 75);
		g2.fill(elipse1);
		g2.setColor(Color.BLACK);
		g2.drawString("Start Game", 225, 80);
		// second button
		g2.setColor(Color.BLACK);
		Ellipse2D elipse2_2 = new Ellipse2D.Double(49, 149, 402, 77);
		g2.fill(elipse2_2);
		g2.setColor(Color.WHITE);
		Ellipse2D elipse2 = new Ellipse2D.Double(50, 150, 400, 75);
		g2.fill(elipse2);
		g2.setColor(Color.BLACK);
		g2.drawString("2nd option", 225, 190);
		// third button
		g2.setColor(Color.BLACK);
		Ellipse2D elipse3_2 = new Ellipse2D.Double(49, 249, 402, 77);
		g2.fill(elipse3_2);
		g2.setColor(Color.WHITE);
		Ellipse2D elipse3 = new Ellipse2D.Double(50, 250, 400, 75);
		g2.fill(elipse3);
		g2.setColor(Color.BLACK);
		g2.drawString("3rd Option", 225, 300);
		// fourth button
		g2.setColor(Color.BLACK);
		Ellipse2D elipse4_2 = new Ellipse2D.Double(49, 349, 402, 77);
		g2.fill(elipse4_2);
		g2.setColor(Color.WHITE);
		Ellipse2D elipse4 = new Ellipse2D.Double(50, 350, 400, 75);
		g2.fill(elipse4);
		g2.setColor(Color.BLACK);
		g2.drawString("4th option", 225, 410);

		// BELOW ALL OTHER ELIPSES
		// sun glimmer on ball
		g2.setColor(Color.YELLOW);
		Ellipse2D glareElipse = new Ellipse2D.Double(655, 178, 70, 15);
		g2.rotate(.15);
		g2.fill(glareElipse);
	}

	@Override
	public void Update() {
		
	}

	@Override
	public void HandleClick(MouseEvent e) {
		if (e.getX() >= 50 && e.getX() <= 450) {
//			First Button
			if (e.getY() >= 50 && e.getY() <= 125) {
				// put button shite here
				System.out.println("MOOSE CLICK");
			}
//			Second Button
			if (e.getY() >= 150 && e.getY() <= 225) {
				// put button shite here
				System.out.println("MOOSE CLICK 2");
			}
//			Third Button
			if (e.getY() >= 250 && e.getY() <= 325) {
				// put button shite here
				System.out.println("MOOSE CLICK 3");
			}
//			Fourth Button
			if (e.getY() >= 350 && e.getY() <= 425) {
				// put button shite here
				System.out.println("MOOSE CLICK 4");
			}
		}
	}
}

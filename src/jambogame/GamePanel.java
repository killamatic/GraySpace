package jambogame;

//import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable {

	private final StateManager Controller;

	private int FPS = 60;	//This is the Target FPS, not actual
	private long TargetTime = 1000 / FPS;

	public GamePanel(final StateManager Controller) {
		this.setPreferredSize(new Dimension(800,600));
		this.Controller = Controller;
		this.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Controller.Clicked(e);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
		});
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//g.clearRect(0, 0, 800, 600);
		Controller.Draw(g);
	}

	public void run() {
		long start, elapsed, wait;

		while (Controller.IsRunning()) {
			start = System.nanoTime();

			repaint();

			elapsed = System.nanoTime() - start;
			wait = TargetTime - elapsed / 1000000;

			if (wait <= 0) {
				wait = 5;
			}
			try {
				Thread.sleep(wait);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

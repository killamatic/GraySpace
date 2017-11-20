package game1;
/*Made Tuesday November 7 2017
 * Improvements yet to be made:
 * XXXadd borders
 * XXXfix movement glitches
 * add wall objects
 * make objects kill when in 
 * reset ball after collision
 * paint wall objects after being hit
 * make modular title cards to play between levels
 * make escape pull up a menu
 * 
 * */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//import java.awt.geom.Rectangle2D;

import javax.swing.*;
@SuppressWarnings("serial")
public class LevelOnePreAttemptCopy extends JPanel implements ActionListener, KeyListener{
	Timer t;
	double x = 20,y = 20,velx = 0,vely = 0, playerWidth = 40, playerHeight = 40;
	double speed= 10;//so that I can test stuff quicker
	int screenWidth = 800, screenHeight = 600;
	Player player;
	public LevelOnePreAttemptCopy(){
		t = new Timer(10, this);//10 milliseconds before refresh
		t.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		player = new Player(x,y);

	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		
		
		//Background
		//draw the sky
        g2.setColor(Color.cyan);
        g2.fillRect(0, 0, 800, 600);
        g2.setColor(Color.GREEN);
        g2.fillRect(0, 550, 800, 100);
//Walls
		//g2.fill(new Rectangle());
	 //player
		player.draw(g2);

		 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//repaint();
		//normal case of ball in the screen

		if(x > screenWidth-42){x = screenWidth-41;}//41 because fucking program made screenWidth outside the screen... it slightly bounces the ball back into play
		if(x < 0){x=0; velx = 0;}//slight bounce after hitting 
		if(y > screenHeight-40){y = screenHeight-41;}
		if(y <  0){y = 0; vely = 0;}
		else{
			x+=velx;
			y+=vely;
		}
		
		//velx *= .97; //this is acceleration, if it is to be used, change up down etc. methods to be +=.15
		//vely *= .97;
		repaint();

	}
	
	public void up(){ //should go up if it is not touching the ceiling
		if(y > 0){vely = -speed;}}
	public void down(){//should go down, as long as it is not at the edge
		if(y < screenHeight - playerHeight){vely = speed;}}
	public void left(){//should go left whil not touching the left edge
		if(x > 0){velx = -speed;}}
	public void right(){//should move right as long as it is not on the right edge
		if(x < screenWidth - playerWidth/2){velx = speed;}} 
	public void stopx(){velx = 0;}
	public void stopy(){vely = 0;}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_UP){up();}
		if(code == KeyEvent.VK_DOWN){down();}		
		if(code == KeyEvent.VK_LEFT){left();}
		//if(x > screenWidth - playerWidth){e.consume();}
		if(code == KeyEvent.VK_RIGHT){right();}	
		/*if(code == KeyEvent.VK_SPACE){
			GameMenu menu = new GameMenu();
			menu.menu();
			}*/
	}
	@Override
	public void keyReleased(KeyEvent e) {
		/*//First itteration: continued moving... great concept to explore
		*/
		/*//Second itteration:
		vely = 0;velx = 0;*/
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_UP){stopy();}
		if(code == KeyEvent.VK_DOWN){stopy();}		
		if(code == KeyEvent.VK_LEFT){stopx();}
		if(code == KeyEvent.VK_RIGHT){stopx();}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
    public Dimension getPreferredSize() {//this says make sure the screen is 800 by 600 pixels

        return new Dimension(screenWidth, screenHeight);
    }
	void notes(){
		/*
		 * 
		This in action performed makes the player hit the wall then phase through it slowly
		if(x > screenWidth || x < 0){velx = 0;}
		if(y > screenHeight || y <0){vely = 0;}
		 * 
		 * 
		 * 
		 * level's order
		 * 1: learn the ropes(show the player the death and paint mechanic)
		 * 2: harder maze
		 * 3: random ball bounce patrol agent
		 * 4: 
		 * 
		 * ideas: 
		 * switch the controls to inverse
		 * 
		 * have a guardian patroling the maze, if they see you in their sight lines, they will shoot slow moving pelets at you
		 * on flip side they show you how to move through the maze
		 * 
		 * 
		 * */
	}
}

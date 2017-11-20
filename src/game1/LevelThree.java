package game1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class LevelThree extends JPanel implements ActionListener, KeyListener{
	Timer t;
	int screenWidth = 800, screenHeight = 600;
	short deathCounter = 0;
	Player player;
	boolean wall1, wall2, wall3;
	int[] wallLocations = new int[12];
	public LevelThree(){
		t = new Timer(10, this);//10 milliseconds before refresh
		t.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		player = new Player();
		wallLocations[0] = screenWidth/2;
		wallLocations[1] = screenHeight/8;
		wallLocations[2] = screenWidth/6;
		wallLocations[3] = 3*screenHeight/4;
		
		wallLocations[4] = screenWidth - screenWidth/6;
		wallLocations[5] = 0;
		wallLocations[6] = screenWidth/6;
		wallLocations[7] = screenHeight/2 - screenHeight/16;
		
		wallLocations[8] = screenWidth - screenWidth/6;
		wallLocations[9] = screenHeight/2 + screenHeight/16;
		wallLocations[10] = screenWidth/6;
		wallLocations[11] = screenHeight/2 - screenHeight/16;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		//Background
		//draw the sky
        g2.setColor(Color.GRAY);
        g2.fillRect(0, 0, 800, 600);
        
//Walls
		//g2.fill(new Rectangle());
	 //player
		player.draw(g2);
		if(wall1){g2.setColor(Color.BLACK);}
		else g2.setColor(Color.GRAY);
        g2.fillRect(wallLocations[0], wallLocations[1], wallLocations[2], wallLocations[3]);
        g2.setColor(Color.GRAY);
        if(wall2){g2.setColor(Color.BLACK);}
        g2.fillRect(wallLocations[4], wallLocations[5], wallLocations[6], wallLocations[7]);
        if(wall1){g2.setColor(Color.BLACK);}
		g2.setColor(Color.GRAY);
        if(wall3){g2.setColor(Color.BLACK);}
        g2.fillRect(wallLocations[8], wallLocations[9], wallLocations[10], wallLocations[11]);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//repaint();
		//normal case of ball in the screen
		//velx *= .97; //this is acceleration, if it is to be used, change up down etc. methods to be +=.15
		//vely *= .97;
		/*if(player.getX() > screenWidth-41){player.setX(screenWidth-41); player.setSpeedX(0);}//41 becaus program made screenWidth outside the screen... it slightly bounces the ball back into play
		if(player.getX() < 0){player.setX(0); player.setSpeedX(0);}//slight bounce after hitting 
		if(player.getY() > screenHeight-40){player.setY(screenHeight-41);}
		if(player.getY() <  0){player.setY(0); player.setSpeedY(0);}
		else{
			player.position();
		}*/
		collision1(wallLocations[0], wallLocations[1], wallLocations[2], wallLocations[3]);
		collision2(wallLocations[4], wallLocations[5], wallLocations[6], wallLocations[7]);
		collision3(wallLocations[8], wallLocations[9], wallLocations[10], wallLocations[11]);
		player.playerCollisionBorder();
		repaint();
	}
	
	void collision1(int x,int y, int width, int height){
		if(player.getX()+ player.playerWidth > x && player.getX() < x + width){
			if(player.getY() > y && player.getY() < y + height){player.setX(10); player.setY(screenHeight/2); wall1 = true; deathCounter++;
			short deathHolder = deathCounter;
			if(deathHolder<deathCounter-3){wall1 = false;}}}
	}
	void collision2(int x,int y, int width, int height){
		if(player.getX() + player.playerWidth > x && player.getX() < x + width){
			if(player.getY() > y && player.getY()< y + height){player.setX(10); player.setY(screenHeight/2); wall2 = true; deathCounter++;}}
	}
	void collision3(int x,int y, int width, int height){
		if(player.getX() + player.playerWidth > x && player.getX() < x + width){
			if(player.getY() > y && player.getY()< y + height){player.setX(10); player.setY(screenHeight/2); wall3 = true; deathCounter++;}}
	}
	void finishLevel(int x, int y, int height){
		if(player.getX()+ player.playerWidth > x){
			if(player.getY() > y - height && player.getY() < y){
				//this is where you make the title card or new level appear from
			}
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_UP){player.up();}
		if(code == KeyEvent.VK_DOWN){player.down();}		
		if(code == KeyEvent.VK_LEFT){player.left();}
		//if(x > screenWidth - playerWidth){e.consume();}
		if(code == KeyEvent.VK_RIGHT){player.right();}	
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
		if(code == KeyEvent.VK_UP){player.stopy();}
		if(code == KeyEvent.VK_DOWN){player.stopy();}		
		if(code == KeyEvent.VK_LEFT){player.stopx();}
		if(code == KeyEvent.VK_RIGHT){player.stopx();}
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
		 maybe the trolling can start with text that says things that are not true, but also some things that are true
		 there is good space for text on the left side
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
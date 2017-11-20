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

import jambogame.GameState;
import jambogame.Input;
import jambogame.Renderer;
import jambogame.StateManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;


//import java.awt.geom.Rectangle2D;
import javax.swing.*;

@SuppressWarnings("serial")
public class LevelOne extends GameState implements ActionListener{
	Timer t;
	int screenWidth = 800, screenHeight = 600;
	short deathCounter = 0;
	Player player;
	Wall wall11,wall22;
	boolean wall1, wall2;
	public LevelOne(Renderer Render, StateManager Controller) {
		super(Render, Controller);
		t = new Timer(10, this);//10 milliseconds before refresh
		t.start();
		player = new Player();
		wall11 = new Wall(200,0,100,500);
		wall22 = new Wall(400,100,100,500);
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
	void finishLevel(int x, int y, int height){
		if(player.getX()+ player.playerWidth > x){
			if(player.getY() > y - height && player.getY() < y){
				//this is where you make the title card or new level appear from
			}
		}
	}
	public void keyPressed() {
		System.out.println("is this called?");
		if(Input.IsKeyDown(KeyEvent.VK_UP)){player.up();}
		if(Input.IsKeyDown(KeyEvent.VK_DOWN)){player.down();}		
		if(Input.IsKeyDown(KeyEvent.VK_LEFT)){player.left();}
		if(Input.IsKeyDown(KeyEvent.VK_RIGHT)){player.right();}
	}
	public void keyReleased() {
//		if(code == KeyEvent.VK_UP){player.stopy();}
//		if(code == KeyEvent.VK_DOWN){player.stopy();}		
//		if(code == KeyEvent.VK_LEFT){player.stopx();}
//		if(code == KeyEvent.VK_RIGHT){player.stopx();}
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
		//Background
		//draw the sky
        g2.setColor(Color.GRAY);
        g2.fillRect(0, 0, screenWidth, screenHeight);
        g2.fillRect(wall11.getX(), wall11.getY(), wall11.getWidth(), wall11.getHeight());
	 //player
		player.draw(g2);
	 //walls
		if(wall1){g2.setColor(Color.BLACK);}
		else g2.setColor(Color.GRAY);
        g2.fillRect(wall11.getX(), wall11.getY(), wall11.getWidth(), wall11.getHeight());
        g2.setColor(Color.GRAY);
        if(wall2){g2.setColor(Color.BLACK);}
        g2.fillRect(wall22.getX(), wall22.getY(), wall22.getWidth(), wall22.getHeight());
		
	}

	@Override
	public void Update() {
		keyPressed();		
	}

	@Override
	public void HandleClick(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
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

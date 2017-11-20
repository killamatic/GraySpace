package jambogame;


import jambogame.GameState;
import jambogame.Input;
import jambogame.Renderer;
import jambogame.StateManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;


import java.util.ArrayList;

//import java.awt.geom.Rectangle2D;
import javax.swing.*;

public class LevelOne extends GameState{
	Timer t;
	int screenWidth = 800, screenHeight = 600;
	short deathCounter = 0;
	Player player;
	ArrayList<Wall> arr;
	public LevelOne(Renderer Render, StateManager Controller) {
		super(Render, Controller);
		arr = new ArrayList<Wall>();
		player = new Player();
//		MakeWallValues wallValues = new MakeWallValues(Render, Controller);
//		arr = wallValues.arrayOfValues();
		arr.add(new Wall(200,0,100,500));
		arr.add(new Wall(400,100,100,500));
		arr.add(new Wall(600,0,100,500));
		
	}
	void CheckCollisions(){
		for (Wall w : arr){
			if(player.getX() + player.playerWidth > w.getX() && player.getX() < w.getX() + w.getWidth()){
				if(player.getY() > w.getY() && player.getY()< w.getY() + w.getHeight()){
					player.setX(10);
					player.setY(screenHeight/2);
					w.paint = true;
					deathCounter++;
				}
			}
		}
	}
	void finishLevel(int x, int y, int height){
		if(player.getX()+ player.playerWidth > x){
			if(player.getY() > y - height && player.getY() < y){
				//this is where you make the title card or new level appear from
			}
		}
	}
	public void keyPressed() {
		if(Input.IsKeyDown(KeyEvent.VK_UP)){player.up();}
		if(Input.IsKeyDown(KeyEvent.VK_DOWN)){player.down();}		
		if(Input.IsKeyDown(KeyEvent.VK_LEFT)){player.left();}
		if(Input.IsKeyDown(KeyEvent.VK_RIGHT)){player.right();}
	}
	public void keyReleased() {
		if(Input.IsKeyReleased(KeyEvent.VK_UP)){player.stopy();}
		if(Input.IsKeyReleased(KeyEvent.VK_DOWN)){player.stopy();}		
		if(Input.IsKeyReleased(KeyEvent.VK_LEFT)){player.stopx();}
		if(Input.IsKeyReleased(KeyEvent.VK_RIGHT)){player.stopx();}
	}
	public void keyTyped(KeyEvent e) {
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
	 //player
		player.draw(g2);
	 //walls
		for(Wall wall: arr){
			if(wall.paint){
				g.setColor(Color.BLACK);
		        g.fillRect(wall.getX(), wall.getY(), wall.getWidth(), wall.getHeight());
			}
		}
		
	}

	@Override
	public void Update() {
		keyPressed();	
		player.setX(player.getX() + player.getSpeedX());
		player.setY(player.getY() + player.getSpeedY());
		keyReleased();
		CheckCollisions();
	}

	@Override
	public void HandleClick(MouseEvent e) {
		
	}
	void notes(){
		/*
		This in action performed makes the player hit the wall then phase through it slowly
		if(x > screenWidth || x < 0){velx = 0;}
		if(y > screenHeight || y <0){vely = 0;}
		*/
	}
}

package game1;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;



public class Player{
	double x , y, playerWidth, playerHeight, speedx, speedy;
	final double normSpeed;
	int screenWidth = 800, screenHeight = 600;
	
	public Player() {
		x = 10;
		y = screenHeight/2;
		playerWidth = 40;
		playerHeight = 40;
		speedx = 0;
		speedy = 0;
		normSpeed = 10;
	}
	
	public Player(double x, double y) {//to start it at a certain place great for testing
		this.x = x;
		this.y = y;
		playerWidth = 40;
		playerHeight = 40;
		speedx = 0;
		speedy = 0;
		normSpeed = 10;
	}
	double getX(){return x;}
	void setX(double newX){x = newX;}
	double getY(){return y;}
	void setY(double newY){y = newY;}
	double getSpeedX(){return speedx;}
	void setSpeedX(double newSpeedX){speedx = newSpeedX;}
	double getSpeedY(){return speedy;}
	void setSpeedY(double newSpeedY){speedy = newSpeedY;}
	
	void playerCollisionBorder(){
		if(x > screenWidth-41){x = screenWidth-41; speedx = 0;}//41 becaus program made screenWidth outside the screen... it slightly bounces the ball back into play
		if(x < 0){x = 0; speedx = 0;}//slight bounce after hitting 
		if(y > screenHeight-40){y = screenHeight-41; speedy = 0;}
		if(y <  0){y= 0; speedy = 0;}
		else{
			position();
		}
	}
	
	void draw(Graphics2D g2d){
		g2d.setColor(Color.BLACK);
		g2d.fill(new Ellipse2D.Double(x,y,40,40));
		}
	void position(){
		x+=speedx;
		y+=speedy;
	}
	public void up(){ //should go up if it is not touching the ceiling
		if(y > 0){speedy = -normSpeed;}
		if(y <=  0){
			y = 0; 
			speedy = 0;}}
	public void down(){//should go down, as long as it is not at the edge
		if(y < screenHeight - playerHeight){speedy = normSpeed;}
		if(y >= screenHeight-40){
			y = screenHeight-41;
			speedy = 0;
		}}
	public void left(){//should go left whil not touching the left edge
		if(x > 1){speedx = -normSpeed;}
		if(x <= 1){x = 1; speedx = 0;}}
	public void right(){//should move right as long as it is not on the right edge
		if(x < screenWidth - playerWidth/2){speedx = normSpeed;}} 
	public void stopx(){speedx = 0;}
	public void stopy(){speedy = 0;}
	void possibleMethods(){
		/*public Image getPlayerImage(){
		ImageIcon ic = new ImageIcon("download-1");
		return ic.getImage();
		
		player self explode button (spacebar) it covers any walls in a radius of the player, so if you find a cluster of walls you can paint them all before they 
		dissapear
	}*/
	}
}

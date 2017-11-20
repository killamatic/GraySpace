package jambogame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class MakeWallValues extends JPanel implements ActionListener{
	static JFrame frame;
	ArrayList<Wall> arrValues;
	int initialX, initialY, finalX,finalY;
	Timer t;
	boolean clicking, that;
	Graphics g;
	
	public MakeWallValues(){
		t = new Timer(10, this);//10 milliseconds before refresh
		t.start();
		arrValues = new ArrayList<Wall>();
		this.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {
				finalX = e.getX();
				finalY = e.getY();
				clicking = true;
			}
			@Override public void mouseEntered(MouseEvent e) {}
			@Override public void mouseExited(MouseEvent e) {}
			@Override public void mousePressed(MouseEvent e) {
				clicking = false;
				initialX = e.getX();
				initialY = e.getY();
			}
		});
	}
	void assignToFile(){
		try {
	    	String line;
	        int urgency;
	        BufferedReader file = new BufferedReader(new FileReader("FileRead.txt"));
	        StringBuffer inputBuffer = new StringBuffer();
	        
	        while ((line = file.readLine()) != null) {//this takes the file into the inputBuffer
//	        	urgency = Integer.parseInt(line.substring(0, 1));
//	        	if(urgency<= priority || (urgency > priority && !first)){
//	        		inputBuffer.append(line);
//	        		inputBuffer.append('\n');
//	        	}
//	        	else if(urgency > priority && first){//if it is after where the priority needs to go
//	        		inputBuffer.append(priority + " " + insertLine + '\n');//my inserted line
//	        		inputBuffer.append(line + '\n');//the line I was on already
//	        		first = false;
//	        	}
	        }
	        String inputStr = inputBuffer.toString();
	        file.close();
	        
	        System.out.println(inputStr); // check that it's inputted right

	        // write the new String with the replaced line OVER the same file
	        FileOutputStream fileOut = new FileOutputStream("FileRead.txt");
	        fileOut.write(inputStr.getBytes());
	        fileOut.close();

	    } catch (Exception e) {
	        System.out.println("Problem reading file.");
	    }
	}
		
	static void pre(){
		frame = new JFrame("Graphic Wall Designer");
	}
	static void post(){
		frame.setPreferredSize(new Dimension(800, 600));//so the height may be 651
		frame.pack();//should pack it to the size of  
//		comment this next line out unless you also have the game in the middle of the screen
		frame.setLocationRelativeTo(null); // this makes it appear in the middle of the screen, instead of in the corner
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	ArrayList<Wall> arrayOfValues(){
		return arrValues;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.g = g;
		Graphics2D g2 = (Graphics2D) g;

		// Background
		// draw the sky
		g2.setColor(Color.GRAY);
		g2.fillRect(0, 0, 800, 600);
		if(that){
			drawRect(g);
		}
//		drawRect(g);
	}
	
	void drawRect(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		if(finalX -initialX > 0){
			if(finalY -initialY >0){g2.fillRect(initialX, initialY, finalX - initialX, finalY - initialY);}
			else{//reasign start of rect to the top left of the rect, and final to the bottom right
				g2.fillRect(initialX, finalY, finalX - initialX, initialY - finalY);}
		}
		if(finalX -initialX < 0){
			if(finalY -initialY >0){g2.fillRect(finalX, initialY, initialX - finalX, finalY - initialY);}
			else{g2.fillRect(finalX, finalY, initialX - finalX, initialY - finalY);}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(clicking){
			arrValues.add(new Wall(initialX,initialY,finalX,finalY));
			System.out.println("x: "+initialX+" y: "+initialY+ " finalX: " + finalX + " finalY: " + finalY);
			that = true;
			int count = 0;
			for(@SuppressWarnings("unused") Wall wall: arrValues){
				count++;
				System.out.println(count);
			}}
		clicking = false;
		repaint();
	}
	
	public static void main(String[] args){
		pre();
		MakeWallValues use = new MakeWallValues();
		frame.add(use);
		post();
	}
}

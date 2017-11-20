package jambogame;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Renderer{
	
	private JFrame Frame;
	private final int WindowWidth = 800;
	private final int WindowHeight = 600;	
	
	public Renderer(){
		Frame = new JFrame("Working Title");
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Frame.setResizable(false);//once we have a final size we should use this
		Frame.setVisible(true);
	}
	
	public void SetGamePanel(GamePanel p){
		Frame.setContentPane(p);
	}
	
	public void RepackFrame(){
		Frame.setPreferredSize(new Dimension(WindowWidth, WindowHeight));// is this actually working, or is the packing setting the frame to the size of the gray background
		Frame.pack();
		Frame.setVisible(true);
	}
}
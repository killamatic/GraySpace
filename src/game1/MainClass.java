package game1;

import javax.swing.JFrame;

public class MainClass {
	static JFrame frame;
	static void pre(){
		frame = new JFrame();
	}
	static void post(){
		frame.pack();//should pack it to the size of  
		frame.setLocationRelativeTo(null); // this makes it appear in the middle of the screen, instead of in the corner
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args){
		pre();
//		LevelOne lvl1 =new LevelOne();	
//		frame.add(lvl1);
		GameMenu GM = new GameMenu();
//		LevelTwo lvl2 = new LevelTwo();
//		LevelThree lvl3 = new LevelThree();
		frame.add(GM);
//		frame.add(lvl2);
//		frame.add(lvl3);
		post();
	}
}

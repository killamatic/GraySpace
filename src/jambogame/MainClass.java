package jambogame;

import java.util.Timer;
import java.util.TimerTask;
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
		final StateManager MasterController = new StateManager();
		Input.SetUpInput();
		Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!MasterController.IsRunning()){
					System.exit(0);
				}else{
					MasterController.Update();
				}
            }
        }, 0, 16);
	}
}

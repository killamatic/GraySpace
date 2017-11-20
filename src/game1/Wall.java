package game1;
import java.awt.*;

public class Wall{

	int x, y, wallWidth, wallHeight;
	int screenWidth = 800, screenHeight = 600;
	boolean Active;

	public Wall(int x, int y, int wallWidth, int wallHeight){
	}

	void drawWall(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, wallWidth, wallHeight);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	int getWidth() {
		return wallWidth;
	}

	int getHeight() {
		return wallHeight;
	}

}

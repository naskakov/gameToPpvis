package Model;

import java.awt.Rectangle;

public class Player {
	public int x = 50;
	public int y = 200;
	public int w = 70;
	public int h = 70;
	public int xOld;
    public int yOld;
	
	public boolean up = false;
    public boolean down = false;
    public boolean left = false;
    public boolean right = false;
	
	
	
	public void move() {
            if (down) y = y + 2;
            if (right) x = x + 2;
            if (left) x = x - 2;
            if (up) y = y - 2;
    } 

}

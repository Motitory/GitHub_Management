package codingwithkth.miniPingPong2;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Racquet {
	private static final int WIDTH = 10;
	private static final int HEIGHT = 80;
	int x = 0;
	int y = 0;
	Color color;
	int xspeed = 0;
	int yspeed = 0;
	
	private GameBoard game;

	public Racquet(GameBoard game, int x, int y, Color color, int id) {
//		this.game = game;
//		this.x = x;
//		this.y = y;
//		this.color = color;
		super(x, y , width)
		
//		this.id = id;
	}

	public void move() {
		if (y + yspeed > 0 && y + yspeed < game.getHeight() - HEIGHT)
			y = y + yspeed;
	}

	public void draw(Graphics2D g) {
		g.setColor(color);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}

	public void keyReleased(KeyEvent e) {
//		if(id == 1)
//			yspeed = 0;
//		if(id == 2)
//			yspeed = 0;
		yspeed = 0;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W)
			yspeed = -3;
		if (e.getKeyCode() == KeyEvent.VK_S)
			yspeed = 3;
		
		if (e.getKeyCode() == KeyEvent.VK_UP)
			yspeed = -3;
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			yspeed = 3;
		
//		if (e.getKeyCode() == KeyEvent.VK_W && id == 1)
//			yspeed = -3;
//		if (e.getKeyCode() == KeyEvent.VK_S && id == 1)
//			yspeed = 3;
//		
//		if (e.getKeyCode() == KeyEvent.VK_UP && id == 2)
//			yspeed = -3;
//		if (e.getKeyCode() == KeyEvent.VK_DOWN && id == 2)
//			yspeed = 3;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
}

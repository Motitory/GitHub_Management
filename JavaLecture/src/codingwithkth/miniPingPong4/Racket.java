package codingwithkth.miniPingPong4;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Racket {
	private static final int WIDTH = 10;
	private static final int HEIGHT = 80;
	private int x = 0;
	private int y = 0;
	private Color color;
	private int xspeed = 0;
	private int yspeed = 0;
	int id;
	private GameBoard game;

	public Racket(GameBoard game, int x, int y, Color color, int id) {
		this.game = game;
		this.x = x;
		this.y = y;
		this.color = color;
		this.id = id;
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
		yspeed = 0;
	}

	public void keyPressed(KeyEvent e) {
		if(this.id == 2) {
			if (e.getKeyCode() == KeyEvent.VK_UP)
				yspeed = -3;
			if (e.getKeyCode() == KeyEvent.VK_DOWN)
				yspeed = 3;
		}
//		else if(this.id == 1) {
//			if (e.getKeyCode() == KeyEvent.VK_W)
//				yspeed = -3;
//			if (e.getKeyCode() == KeyEvent.VK_S)
//				yspeed = 3;
//		}
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
}

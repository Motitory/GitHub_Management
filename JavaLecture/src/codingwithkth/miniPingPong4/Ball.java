package codingwithkth.miniPingPong4;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
	private static final int RADIUS = 20;
	int x = 0;
	int y = 0;
	int xSpeed = 1;
	int ySpeed = 1;
	int speed = 1;
//	int score1 = 0;
//	int score2 = 0;
	private GameBoard game;
	Color color;

	public Ball(GameBoard game, Color color) {
		this.game = game;
		this.color = color;
	}

	void move() {
		if(x < 0) {
			reset();
			game.score2++;
		}
		
		if(x >= game.getWidth() - 2 * RADIUS) {
			reset();
			game.score1++;
		}
		
		if(y < 0 || y >= game.getHeight() - 2 * RADIUS)
			ySpeed = -ySpeed;
		
		if(collision()) {
			if(xSpeed >= 0)
				xSpeed -= speed;
			else
				xSpeed += speed;
			
			if(ySpeed >= 0)
				ySpeed += speed / 2;
			else
				ySpeed -= speed / 2;
			
			speed++;
		}
		
		x = x + xSpeed;
		y = y + ySpeed;
	}

	private boolean collision() {
		return game.racket1.getBounds().intersects(getBounds())
				|| game.racket2.getBounds().intersects(getBounds());
	}

	public void draw(Graphics2D g) {
		g.setColor(color);
		g.fillOval(x, y, 2 * RADIUS, 2 * RADIUS);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 2 * RADIUS, 2 * RADIUS);
	}
	
	public void reset() {
		x = 0;
		y = 0;
		xSpeed = 1;
		ySpeed = 1;
		speed = 1;
	}
}
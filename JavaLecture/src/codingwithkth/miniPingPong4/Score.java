package codingwithkth.miniPingPong4;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Score {
	private static int GAME_WIDTH = 600;
	private static int GAME_HEIGHT = 400;
//	protected int player1;
//	protected int player2;
	private GameBoard game;
	
	public Score(/*int gameWidth, int gameHeight*/ GameBoard game) {
//		GAME_WIDTH = gameWidth;
//		GAME_HEIGHT = gameHeight;
		this.game = game;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 60));
		
		g.setColor(Color.GREEN);
		
		Graphics2D g2 = (Graphics2D) g;
	    g2.setStroke(new BasicStroke(10,BasicStroke.CAP_ROUND,0));
		g.drawLine(GAME_WIDTH / 2, 0, GAME_WIDTH / 2, GAME_HEIGHT);
		
		g.setColor(Color.DARK_GRAY);
		g.drawString(String.valueOf(game.score1 / 10) + String.valueOf(game.score1 % 10), GAME_WIDTH / 2 - 85, 50);
		g.setColor(Color.PINK);
		g.drawString(String.valueOf(game.score2 / 10) + String.valueOf(game.score2 % 10), GAME_WIDTH / 2 + 20, 50);
	}
}

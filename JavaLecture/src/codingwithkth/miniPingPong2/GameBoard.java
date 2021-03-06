package codingwithkth.miniPingPong2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameBoard extends JPanel implements KeyListener {
	Ball ball;
	Racquet racquet1;
	Racquet racquet2;
	Score score;
	int id1 = 1;
	int id2 = 2;

	public GameBoard() {
		ball = new Ball(this, Color.red);
		this.setBackground(Color.green);
		racquet1 = new Racquet(this, 10, 150, Color.blue, 1);
		racquet2 = new Racquet(this, 560, 150, Color.yellow, 2);
		setFocusable(true);
		addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		racquet1.keyReleased(e);
		racquet2.keyReleased(e);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		racquet1.keyPressed(e);
		racquet2.keyPressed(e);
	}

	private void move() {
		racquet1.move();
		racquet2.move();
		ball.move();
	}

//	checkCollision(){
//		
//	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		racquet1.draw(g2d);
		racquet2.draw(g2d);
		ball.draw(g2d);
		score.draw(g2d);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Pong 게임");
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GameBoard game = new GameBoard();
		frame.add(game);
		//setVisible은 마지막에
		frame.setVisible(true);

		while (true) {
			game.move();
			game.repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
package codingwithkth.miniPingPong3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameBoard extends JPanel implements KeyListener {
	private Ball ball;
	Racket racket1;
	Racket racket2;
	private Score score;
	int score1 = 0;
	int score2 = 0;

	public GameBoard() {
		score = new Score(this);
		this.setBackground(Color.white);
		racket1 = new Racket(this, 10, 150, Color.blue, 1);
		racket2 = new Racket(this, 560, 150, Color.yellow, 2);
		ball = new Ball(this, Color.red);
		setFocusable(true);
		addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		racket1.keyReleased(e);
		racket2.keyReleased(e);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		racket1.keyPressed(e);
		racket2.keyPressed(e);
	}

	private void move() {
		ball.move();
		racket1.move();
		racket2.move();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		ball.draw(g2d);
		racket1.draw(g2d);
		racket2.draw(g2d);
		score.draw(g2d);
	}

	public static void main(String[] args) {
		System.out.println("ㅁㅁㄴㅇㄹ");
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
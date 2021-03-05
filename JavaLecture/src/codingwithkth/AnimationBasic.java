package codingwithkth;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimationBasic extends JPanel implements ActionListener {
	private final int WIDTH = 500, HEIGHT = 500;
	private BufferedImage image;
	private Timer timer;
	private int x, y;
	private final int START_X = 250, START_Y = 250;
//	private boolean bounce = false;
	private int dx, dy;

	public AnimationBasic() {
		// 이미지 파일을 읽어서 image 객체로 생성
		// 20ms마다 이벤트를 발생시키는 timer 객체를 생성, timer를 start 시킴

		File file = new File("spaceship3.jpg");
		System.out.println(file.getAbsolutePath());
		// buildpath
//		File file = new File("src\\codingwithkth\\spaceship.jpg");
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

		x = START_X;
		y = START_Y;
		dx = 1;
		dy = -1;

		timer = new Timer(3, this);
		timer.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// x, y 좌표에 이미지를 그린다.
		g.drawImage(image, x, y, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// x, y 좌표를 변경
//		x += 1;
//		y -= 1;
		
		if(dx > 0) {
			x += 1;
		}else {
			x -= 1;
		}
		
		if(dy > 0) {
			y += 1;
		}else {
			y -= 1;
		}

		if (x + 115 + dx > WIDTH || x + dx < 0) {
			System.out.println(x);
			dx = -dx;
		}
		
		if(y + 135 + dy > HEIGHT || y + dy < 0) {
			System.out.println(y);
			dy = -dy;
		}
		repaint();
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new AnimationBasic());
		frame.setTitle("애니메이션 테스트");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
//		frame.setBackground(new java.awt.Color(255, 255, 135));
		frame.setVisible(true);
	}
}

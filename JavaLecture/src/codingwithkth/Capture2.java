package codingwithkth;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Capture2 {
	public static void main(String[] args) {
		JFrame capture = new JFrame();
		capture.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Scanner sc = new Scanner(System.in);
		System.out.println("화면 캡쳐 크기를 정할겁니다. 차례대로 가로, 세로를 입력해주세요.");
		int width = sc.nextInt();
		int height= sc.nextInt();
		System.out.println("화면 캡쳐 위치를 정할겁니다. 차례대로 x좌표, y좌표를 입력해주세요.");
		int x = sc.nextInt();
		int y = sc.nextInt();
		

		Dimension d;
		Rectangle rect = new Rectangle(x, y, width, height);
		capture.setSize(d = new Dimension(width, height));

		try {
			Robot robot = new Robot();
			final BufferedImage image = robot.createScreenCapture(rect);
			image.flush();
			JPanel panel = new JPanel() {
				public void paintComponent(Graphics g) {
					g.drawImage(image, 0, 0, d.width, d.height, this);
				}
			};
			panel.setOpaque(false);
			panel.prepareImage(image, panel);
			panel.repaint();
			capture.getContentPane().add(panel);
		} catch (Exception e) {
			e.printStackTrace();
		}

		capture.setVisible(true);
	}
}
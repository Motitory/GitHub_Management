package codingwithkth;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Capture3 extends JFrame implements ActionListener {
//    private static final long serialVersionUID = 1L;

	private Robot robot;
	private JPanel mainPanel;
	private JTextField width_text, height_text, setX_text, setY_text;
	private JButton button;
	private int width, height, setX, setY;

	public Capture3() {
		super("화면 캡쳐 프로그램");

		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(3, 1));

		mainPanel.add(new JLabel("사이즈 입력 : (가로) (세로)"));
		width_text = new JTextField(15);
		height_text = new JTextField(15);
		mainPanel.add(width_text);
		mainPanel.add(height_text);

		mainPanel.add(new JLabel("위치 입력 : (x) (y)"));
		setX_text = new JTextField(15);
		setY_text = new JTextField(15);
		mainPanel.add(setX_text);
		mainPanel.add(setY_text);

		// 그리드 아웃 가운데 정렬 못함
		
		mainPanel.add(new JLabel());
		button = new JButton("화면 캡쳐");
		button.addActionListener(this);
//		button.setAlignmentX(CENTER_ALIGNMENT);
		mainPanel.add(button);
		this.add(mainPanel, BorderLayout.CENTER);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 300);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("버튼 클릭");
		try {
			robot = new Robot();
			setX = Integer.parseInt(setX_text.getText());
			setY = Integer.parseInt(setY_text.getText());
			width = Integer.parseInt(width_text.getText());
			height = Integer.parseInt(height_text.getText());
			Rectangle area = new Rectangle(setX, setY, width, height);
			BufferedImage bufferedImage = robot.createScreenCapture(area);
			ImageIO.write(bufferedImage, "jpg", new File("./화면캡쳐.jpg"));
		} catch (AWTException awtE) {
			awtE.printStackTrace();
		} catch (IOException ioE) {
			ioE.printStackTrace();
		}
	}

//	@Override
//	public void keyPressed(KeyEvent e) {            
//		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//			System.out.println("enter 입력");
//			try {
//				robot = new Robot();
//				setX = Integer.parseInt(setX_text.getText());
//				setY = Integer.parseInt(setY_text.getText());
//				width = Integer.parseInt(width_text.getText());
//				height = Integer.parseInt(height_text.getText());
//				Rectangle area = new Rectangle(setX, setY, width, height);
//				BufferedImage bufferedImage = robot.createScreenCapture(area);
//				ImageIO.write(bufferedImage, "jpg", new File("./화면캡쳐.jpg"));
//			} catch (AWTException awtE) {
//				awtE.printStackTrace();
//			} catch (IOException ioE) {
//				ioE.printStackTrace();
//			}
//		}
//	}

	public static void main(String[] args) {
		new Capture3();
	}

//	@Override
//	public void keyTyped(KeyEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void keyReleased(KeyEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
}
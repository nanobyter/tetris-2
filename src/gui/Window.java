package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author {nanobyter}
 * 
 *         created: 2022-03-02
 */
public class Window extends JFrame {

	static JPanel northPanel;
	static JPanel eastPanel;
	static JPanel southPanel;
	static JPanel westPanel;
	static GamePanel gamePanel;

	private static final long serialVersionUID = 1L;
	final int WINDOW_WIDTH = 600;
	final int WINDOW_HEIGHT = 700;

	public Window() {

		setTitle("nanobyter   Tetris");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// Create panels
		northPanel = new JPanel();
		eastPanel = new JPanel();
		southPanel = new JPanel();
		westPanel = new JPanel();
		gamePanel = new GamePanel();

		// Set panel colors
		Color color = Color.BLACK;
		northPanel.setBackground(color);
		eastPanel.setBackground(color);
		southPanel.setBackground(color);
		westPanel.setBackground(color);

		// Add panels
		add(northPanel, BorderLayout.NORTH);
		add(eastPanel, BorderLayout.EAST);
		add(southPanel, BorderLayout.SOUTH);
		add(westPanel, BorderLayout.WEST);
		add(gamePanel, BorderLayout.CENTER);

		// Set preferred size
		northPanel.setPreferredSize(new Dimension(100, 30));
		eastPanel.setPreferredSize(new Dimension(200, 100));
		southPanel.setPreferredSize(new Dimension(100, 30));
		westPanel.setPreferredSize(new Dimension(50,100));
		gamePanel.setSize(new Dimension(getPreferredSize()));

		setVisible(true);
		pack();
	}

	public static GamePanel getGamePanel() {
		return gamePanel;
	}
}

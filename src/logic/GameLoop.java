package logic;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

import gui.Window;
import utils.Constants;

/**
 * @author {nanobyter}
 * 
 *         created: 2022-03-02
 */
public class GameLoop extends JPanel {

	private static final long serialVersionUID = 1L;

	private final int BLOCKS_X;
	private final int BLOCKS_Y;
	private static int posX;
	private static int posY;
	private static int currentPiece;
	private static int currentRotation;

	private static Tetromino_Shape[] tetromino;
	private static boolean[] gameBoard;
	private static Color[] gameBoardColor;
	private Timer timer;
	private int gameTick;

	public GameLoop() {

		this.addKeyListener(new KeyListenerClass());

		this.setFocusable(true);
		BLOCKS_X = Constants.getInstance().BLOCKS_X;
		BLOCKS_Y = Constants.getInstance().BLOCKS_Y;

		gameBoard = new boolean[BLOCKS_X * BLOCKS_Y];
		gameBoardColor = new Color[BLOCKS_X * BLOCKS_Y];

		gameTick = 1000;

		// timer = new Timer(gameTick, e -> forcePieceDown());

		initGameBoard();
		initTetrominoArray();
		initTetromino();

		Window window = new Window();

		while (true) {

//			if (!forcePieceDown()) {
//
//
//			}

			Window.getGamePanel().repaint();
		}

	}

	private boolean forcePieceDown() {
		System.out.println("forcePieceDown");
		if (doesPieceFit(currentPiece, currentRotation, posX, posY + 1)) {
			posY++;
			return true;
		}
		return false;
	}

	private void initTetrominoArray() {
		tetromino = new Tetromino_Shape[7];
		tetromino[0] = new Tetromino_I();
		tetromino[1] = new Tetromino_J();
		tetromino[2] = new Tetromino_L();
		tetromino[3] = new Tetromino_O();
		tetromino[4] = new Tetromino_S();
		tetromino[5] = new Tetromino_T();
		tetromino[6] = new Tetromino_Z();
	}

	private void initTetromino() {
		Random rand = new Random();

		currentPiece = rand.nextInt(7);
		currentRotation = 0;
		posX = BLOCKS_X / 2 - 2;
		posY = 0;
	}

	/**
	 * Checks if a piece will fit in new location
	 * 
	 * @param tet      The tetromino
	 * @param rotation The rotation index
	 * @param posX     X top left in tetromino
	 * @param posY     Y top left in tetromino
	 * @param moveX    X move direction (-1 for left, + 1 for right)
	 * @param moveY    Y move direction (+1 for down)
	 * @return True if piece fit
	 */
	private boolean doesPieceFit(int currentPiece, int currentRotation, int moveX, int moveY) {

		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {

				if (tetromino[currentPiece].isBlock(x, y, currentRotation)
						&& getBoardIndex(((y + posY + moveY) * BLOCKS_X) + x + posX + moveX))
					return false;
			}
		}
		return true;
	}

	private void initGameBoard() {

		for (int y = 0; y < BLOCKS_Y; y++) {
			for (int x = 0; x < BLOCKS_X; x++) {
				if (x == 0 || x == BLOCKS_X - 1 || y == BLOCKS_Y - 1) {
					gameBoard[y * BLOCKS_X + x] = true;
					gameBoardColor[y * BLOCKS_X + x] = Color.DARK_GRAY;
				}
			}
		}
	}

	private boolean getBoardIndex(int index) {
		return gameBoard[index];
	}

	public static Tetromino_Shape[] getTetrominoArray() {
		return tetromino;
	}

	public static int getCurrentPiece() {
		return currentPiece;
	}

	public static int getCurrentRotation() {
		return currentRotation;
	}

	public static int getposX() {
		return posX;
	}

	public static int getposY() {
		return posY;
	}

	public static boolean[] getGameBoard() {
		return gameBoard;
	}

	public static Color[] getGameBoardColor() {
		return gameBoardColor;
	}

	private class KeyListenerClass implements KeyListener {

		public KeyListenerClass() {
			System.out.println("Constructor");
		}

		@Override
		public void keyPressed(KeyEvent e) {

			System.out.println("KEY PRESSED");

			// Move left
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				System.out.println("LEFT");
				if (doesPieceFit(currentPiece, 0, -1, 0))
					posX--;
			}

			// Move right
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				if (doesPieceFit(currentPiece, 0, +1, 0))
					posX++;
			}

			// Move down
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				if (doesPieceFit(currentPiece, 0, 0, +1))
					posY++;
			}

			if (e.getKeyCode() == KeyEvent.VK_Z) {
				if (doesPieceFit(currentPiece, 1, 0, 0))
					tetromino[currentPiece].setRotation();
			}

			// DEBUG --------------------
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				if (posY > 0)
					posY--;
			}

			if (e.getKeyCode() == KeyEvent.VK_D) {
				currentPiece++;
				currentPiece %= 7;
			}

			if (e.getKeyCode() == KeyEvent.VK_S) {
				currentPiece--;
				currentPiece %= 7;
			}

			Window.getGamePanel().repaint();

			System.out.println("X: " + posX + ", Y: " + posY);

		}

		// Unused methods
		@Override
		public void keyReleased(KeyEvent e) {
		}

		@Override
		public void keyTyped(KeyEvent e) {
			System.out.println("KEY TYPED");
		}

	}

	public static void main(String[] args) {
		new GameLoop();
	}
}

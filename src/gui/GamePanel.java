package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import logic.GameLoop;
import logic.Tetromino_Shape;
import utils.Constants;

/**
 * @author {nanobyter}
 * 
 *         created: 2022-03-02
 */
public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private final int BLOCKS_X;
	private final int BLOCKS_Y;
	private final int BLOCK_SIZE;
	private Tetromino_Shape[] tetromino;
	private boolean[] gameBoard;
	private Color[] gameBoardColor;
	
	private static int posX;
	private static int posY;
	private static int currentPiece;
	private static int currentRotation;

	public GamePanel() {
		
		BLOCKS_X = Constants.getInstance().BLOCKS_X;
		BLOCKS_Y = Constants.getInstance().BLOCKS_Y;
		BLOCK_SIZE = Constants.getInstance().BLOCK_SIZE;
		
		tetromino = GameLoop.getTetrominoArray();
		posX = GameLoop.getposX();
		posY = GameLoop.getposY();
		currentPiece = GameLoop.getCurrentPiece();
		currentRotation = GameLoop.getCurrentRotation();
		
		gameBoard = GameLoop.getGameBoard();
		gameBoardColor = GameLoop.getGameBoardColor();

		this.setBackground(Color.BLACK);

		


		

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Draw gameBoard
		for (int y = 0; y < BLOCKS_Y; y++) {
			for (int x = 0; x < BLOCKS_X; x++) {
				if(gameBoard[y * BLOCKS_X + x]) {
					g.setColor(gameBoardColor[y * BLOCKS_X + x]);
					g.fillRect(x * BLOCK_SIZE, y * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
				
				
				}
			}
		}

		// Draw tetromino
		g.setColor(Color.RED);
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				if (tetromino[currentPiece].isBlock(x, y, currentRotation)) {
					g.fillRect((x + posX) * BLOCK_SIZE, (y + posY) * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
				}
			}
		}


	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(Constants.getInstance().BLOCKS_X * Constants.getInstance().BLOCK_SIZE,
				Constants.getInstance().BLOCKS_Y * Constants.getInstance().BLOCK_SIZE);
	}

}

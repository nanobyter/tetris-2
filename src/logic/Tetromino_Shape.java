package logic;

import java.awt.Color;

/**
 * @author {FASON}
 * 
 *         created: 2022-03-02
 */
public abstract class Tetromino_Shape {

	private String tetromino;
	private int rotation;
	private Color color;

	public Tetromino_Shape() {

		rotation = 0;
	}

	/**
	 * Checks if a block of the piece will fit
	 * 
	 * @param x   The x-position
	 * @param y   The y-position
	 * @param rotation The tested rotation
	 * @return False if empty, i.e will fit
	 */
	public boolean isBlock(int x, int y, int rotation) {
		
		boolean isBlock = switch (rotation) {
		case 0 -> tetromino.charAt(y * 4 + x) == 'x';
		case 1 -> tetromino.charAt(12 + y - (4 * x)) == 'x';
		case 2 -> tetromino.charAt(15 - (4 * y) - x) == 'x';
		case 3 -> tetromino.charAt(3 - y + (4 * x)) == 'x';
		default -> true;
		};
		return isBlock; // To make the compiler happy
	}

	public int getRotation() {
		return rotation;
	}

	public void setRotation() {
		rotation++;
		rotation %= 4;
	}

	public String getTetromino() {
		return tetromino;
	}

	protected void setTetromino(String sTetromino) {
		this.tetromino = sTetromino;
	}

	public Color getColor() {
		return color;
	}

	protected void setColor(Color color) {
		this.color = color;
		
	}

}

package logic;

import java.awt.Color;

/**
 * @author {nanobyter}
 * 
 * created: 2022-03-02
 */
public class Tetromino_S extends Tetromino_Shape {

	public Tetromino_S() {
		super();
		
		/* @formatter:off */
		setTetromino(".x.."
				+    ".xx."
				+    "..x."
				+    "....");
		/* @formatter:on */
		
		setColor(Color.GREEN);
	}
}

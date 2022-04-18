package logic;

import java.awt.Color;

/**
 * @author {nanobyter}
 * 
 * created: 2022-03-02
 */
public class Tetromino_O extends Tetromino_Shape {

	public Tetromino_O() {
		super();
		
		/* @formatter:off */
		setTetromino("...."
				+    ".xx."
				+    ".xx."
				+    "....");
		/* @formatter:on */
		
		setColor(Color.YELLOW);
	}
}

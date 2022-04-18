package logic;

import java.awt.Color;

/**
 * @author {nanobyter}
 * 
 * created: 2022-03-02
 */
public class Tetromino_T extends Tetromino_Shape {

	public Tetromino_T() {
		super();
		
		/* @formatter:off */
		setTetromino("..x."
				+    ".xx."
				+    "..x."
				+    "..x.");
		/* @formatter:on */
		
		setColor(Color.MAGENTA);
	}
}

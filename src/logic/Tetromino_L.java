package logic;

import java.awt.Color;

/**
 * @author {nanobyter}
 * 
 * created: 2022-03-02
 */
public class Tetromino_L extends Tetromino_Shape {

	public Tetromino_L() {
		super();
		
		/* @formatter:off */
		setTetromino(".x.."
				+    ".x.."
				+    ".xx."
				+    "....");
		/* @formatter:on */
		
		setColor(Color.ORANGE);
	}
}

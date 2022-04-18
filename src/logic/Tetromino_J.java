package logic;

import java.awt.Color;

/**
 * @author {nanobyter}
 * 
 *         created: 2022-03-02
 */
public class Tetromino_J extends Tetromino_Shape {

	public Tetromino_J() {
		super();

		/* @formatter:off */
		setTetromino("..x."
				+    "..x."
				+    ".xx."
				+    "....");
		/* @formatter:on */

		setColor(Color.BLUE);
	}
}

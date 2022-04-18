package logic;

import java.awt.Color;

/**
 * @author {nanobyter}
 * 
 *         created: 2022-03-02
 */
public class Tetromino_I extends Tetromino_Shape {

	public Tetromino_I() {
		super();

		/* @formatter:off */
		setTetromino("..x."
				+    "..x."
				+    "..x."
				+    "..x.");
		/* @formatter:on */

		setColor(Color.CYAN);
	}
}

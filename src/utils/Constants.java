package utils;

/**
 * @author {nanobyter}
 * 
 * created: 2022-03-02
 */
public class Constants {
	
	private static Constants constants = null;

	public final int BLOCKS_X = 14;
	public final int BLOCKS_Y = 19;
	public final int BLOCK_SIZE = 30;
	
	
	private Constants() {
		
	}
	
	public static Constants getInstance() {
		
		if(constants == null)
			constants = new Constants();
		
		return constants;
	}
}

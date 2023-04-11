package CommonLibrary;

import java.util.Random;

/*
 * this class contains generic mothods related to java
 * @author Niranjan
 * 
 */

public class JavaLibrary {
	
	/**
	 * 
	 * This Method contains generic method get random number
	 * 
	 */

	public int getRandomNumber()
	{
		Random ran=new Random();
		return ran.nextInt(1000);
	}
}

package application;

/**
 * NonNegativeNumber: Custom Exception
 */
public class NonNegativeNumber extends Exception{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NonNegativeNumber(String message){
        super(message);
    }
}


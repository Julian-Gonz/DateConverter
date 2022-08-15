
public class MonthException extends Exception{
	
	public MonthException() {
		super("Invalid month!");
	}
	
	public MonthException(String message) {
		super(message);
	}

}

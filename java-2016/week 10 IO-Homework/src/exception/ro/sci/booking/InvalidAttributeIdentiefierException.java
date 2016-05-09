package exception.ro.sci.booking;



//TODO question: why don't you use the class from platform InvalidAttributeIdentifierException ?
public class InvalidAttributeIdentiefierException extends Exception {
	public InvalidAttributeIdentiefierException(String mesage) {
		super(mesage);
	}

}
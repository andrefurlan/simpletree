package simpletree.exceptions;

import java.io.IOException;

public class FXMLLoadException extends Exception {

	public FXMLLoadException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Exception for loading an FXML file
	 * @param arg0
	 */
	public FXMLLoadException(String arg0) {
		super(arg0);
	}

}

package ch14;

public class LoginPWException extends LoginException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginPWException(String errMsg) {
		super(errMsg);
	}
	
	public LoginPWException(String errMsg, int errCode) {
		super(errMsg, errCode);
	}
}

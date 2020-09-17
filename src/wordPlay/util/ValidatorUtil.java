package wordPlay.util;

public class ValidatorUtil {
	/**
	 * @author kumudinithote
	 * @param	baseErrMsg	String base error message
	 * @param	validators	list of validators pass by implemented class/methods
	 * @throws	Exception when validation failed
	 */
	public static void validate(String baseErrMsg, StdoutDisplayInterface... validators) throws Exception {
		for (StdoutDisplayInterface v : validators) {
			try {
				v.run();
			} catch (Exception e) {
				throw new Exception(baseErrMsg.concat(": " + e.getMessage()), e);
			}
		}

	}

}

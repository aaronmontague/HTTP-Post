package models;

public class TokenResponse {
	// Attributes
	private String result;
	private String errormessage;
	private String displaymessage;
	public OAuthTokenResponse OAuthTokenResponse;
	
	// Constructors
	
	// Methods
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getErrormessage() {
		return errormessage;
	}
	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}
	public String getDisplaymessage() {
		return displaymessage;
	}
	public void setDisplaymessage(String displaymessage) {
		this.displaymessage = displaymessage;
	}
}

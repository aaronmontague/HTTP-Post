package models;

public class OAuthTokenResponse {
	// Attributes
	private String token;
	private String issued_at;
	private String expires_at;
	
	// Constructors
	 
	// Methods
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getIssued_at() {
		return issued_at;
	}
	public void setIssued_at(String issued_at) {
		this.issued_at = issued_at;
	}
	public String getExpires_at() {
		return expires_at;
	}
	public void setExpires_at(String expires_at) {
		this.expires_at = expires_at;
	}
}

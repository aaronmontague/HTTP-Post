package httpPost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

// JSON Library
import com.fasterxml.jackson.databind.ObjectMapper;

import models.TokenResponse;

public class PostMain {

	public static void main(String[] args) throws IOException {
		System.out.println("Hello HTTP Post");
		// String to store response
		String responseString = null;
		
		// Set URL
		URL url = new URL ("https://test.mgw.bcbsma.com/v2/getapptoken");
		
		// Create Connection
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		
		// Set connection parameters
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json;");
		con.setRequestProperty("Accept", "*/*");
		con.setRequestProperty("x-api-key", "G2NAAGUxIAckuPJNlmupfbaJaM1P9eUu");
		con.setDoOutput(true);
				
		// TODO Should get this from a JSON object and stringify
		String jsonInputString = "{\"OAuthTokenRequest\":{\"Username\": \"tst_sdqsrv\", \"Password\": \"Rapi@5478\"}}";
		
		// Send the body of the request
		try(OutputStream os = con.getOutputStream()) {
		    byte[] input = jsonInputString.getBytes("utf-8");
		    os.write(input, 0, input.length);   
		    System.out.println(os.toString());
		}
		catch (Exception e) {
			System.out.println("Output Stream Failed");
			System.out.println(e.toString());
		}
		
		// Read the response into a String
		try(BufferedReader br = new BufferedReader(
			new InputStreamReader(con.getInputStream(), "utf-8"))) {
			    StringBuilder response = new StringBuilder();
			    String responseLine = null;
			    while ((responseLine = br.readLine()) != null) {
			        response.append(responseLine.trim());
			    }
			
			System.out.println(response);
			responseString = response.toString();
			}
		catch (Exception e) {
			System.out.println("Buffered Reader Failed");
			System.out.println(e.toString());
		}
		
		// Close the connection
		con.disconnect();
		
		// Convert to JSON object, taking only the fields we want (token & expire datetime)
		ObjectMapper mapper = new ObjectMapper();
		
		TokenResponse convertedJson = null;
		try {
			convertedJson = mapper.readValue(responseString, TokenResponse.class);
		}
		catch(Exception e) {
			System.out.println("JSON Convert Failed");
			System.out.println(e.toString());
		}
		
		// Display the info
		try {
			System.out.println(convertedJson.getResult());
			System.out.println(convertedJson.getErrormessage());
			System.out.println(convertedJson.getDisplaymessage());
			System.out.println("---");
			System.out.println(convertedJson.OAuthTokenResponse.getToken());
		}
		catch(Exception e) {
			System.out.println("JSON Object Creation Failed");
			System.out.println(e.toString());
		}
	}

}

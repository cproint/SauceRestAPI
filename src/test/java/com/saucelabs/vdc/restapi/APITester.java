package com.saucelabs.vdc.restapi;

import org.json.JSONObject;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


public class APITester {
	
    public String username = System.getenv("SAUCE_USERNAME");

    public String accesskey = System.getenv("SAUCE_ACCESS_KEY");
    
	private String baseURI = "https://saucelabs.com/rest/v1";
	
	JSONObject jsonObj;
	
	
	@Test(enabled=false)
	public void testSauceUser() {
		Response resp = given().contentType("application/json").auth().basic(username, accesskey).
		when().get(baseURI+"/users/muralitulugu");
		
		System.out.println(resp.asString());

	}
	
	@Test(enabled=false)
	public void testGetSauceTunnels() {
		Response resp = given().contentType("application/json").auth().basic(username, accesskey).
		when().get(baseURI+"/muralitulugu/tunnels");
		
		System.out.println(resp.asString());

	}
	
	@Test(enabled=true)
	public void testGetSauceTunnelIdentifier() {
		Response resp = given().contentType("application/json").auth().basic(username, accesskey).
		when().get(baseURI+"/muralitulugu/tunnels/447723c725074498b9f4060479105f62");
		
		jsonObj = new JSONObject(resp.asString());

		System.out.println(jsonObj.get("tunnel_identifier"));

	}
	
	@Test(enabled=false)
	public void testGetShutDownTunnel() {
		Response resp = given().contentType("application/json").auth().basic(username, accesskey).
		when().delete(baseURI+"/muralitulugu/tunnels/45ef23ed5402404fac2d3021760ce3e1");
		

		System.out.println(resp.asString());

	}

}

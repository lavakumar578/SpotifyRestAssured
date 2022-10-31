package com.spotifyAuthorization;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import GenericLibrary.BaseAPIClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RenewTokenTest extends BaseAPIClass{

	public String accessToken;

	public String refreshToken() {
		
		Response response=RestAssured.given()
		  .queryParam("refresh_token", "AQA4dmxWnssdJb976JHcCqLwF8bDAfDOFE7VtV1RlcKT46CVsNhZmWpwt3GhB3XqokXYSHgarcqpUECO3tvYRntyMX-0piNmXOFTJ1goW5Su1ClyJLQdZuXU8JMBbuUyUIc")
		  .queryParam("client_id", "2f1fba8db1f546bab3cab375e75bff05")
		  .queryParam("client_secret", "9ad478ddd68741c7be732dea4fb008ea")
		  .queryParam("grant_type","refresh_token")
		.when()
		  .post(authorizationURI)
		.then().contentType(ContentType.JSON).extract().response();
	
	
		accessToken = restAssuredUtility.getJSONData(response, "access_token");
	
		return accessToken;	
	}
}

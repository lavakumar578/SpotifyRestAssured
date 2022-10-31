package com.Albums;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.spotifyAuthorization.RenewTokenTest;

import GenericLibrary.BaseAPIClass;
import GenericLibrary.EndPoints;
import GenericLibrary.PropertiesUtility;

public class TC_01_Albums_GetAlbumTest extends BaseAPIClass {
	
	@Test(priority = 1)
	public void getAlbumTest()  {
		given()
		 .auth().oauth2(regenerateTokenAfterOneHour.regenerateTokenAfterOneHour())
		.when()
		  .get(baseURI+EndPoints.GETALBUM+PropertiesUtility.getDataFromProperty("albumId"))
		.then().log().all();
		
		
	}
	

}

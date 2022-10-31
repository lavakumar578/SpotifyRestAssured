package com.Albums;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import GenericLibrary.BaseAPIClass;
import GenericLibrary.EndPoints;
import GenericLibrary.PropertiesUtility;

public class TC_07_Albums_CheckSavedAlbumTest extends BaseAPIClass{
	@Test(priority = 7)
	public void CheckSavedAlbumTest() {
		
		given()
		 .auth().oauth2(regenerateTokenAfterOneHour.regenerateTokenAfterOneHour())
		 .queryParam("ids", PropertiesUtility.getDataFromProperty("saveAlbumId"))
		.when()
		  .get(baseURI+EndPoints.CHECKSAVEDALBUMS)
		.then().assertThat().statusCode(200).time(Matchers.lessThan(3000L),TimeUnit.MILLISECONDS).log().all();
	}

}

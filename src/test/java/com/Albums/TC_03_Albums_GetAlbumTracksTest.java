package com.Albums;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import GenericLibrary.BaseAPIClass;
import GenericLibrary.EndPoints;
import GenericLibrary.PropertiesUtility;

public class TC_03_Albums_GetAlbumTracksTest extends BaseAPIClass{

	
	@Test(priority = 3)
	public void getAlbumTracksTest() {
		given()
		 .auth().oauth2(regenerateTokenAfterOneHour.regenerateTokenAfterOneHour())
		.when()
		  .get(baseURI+EndPoints.GETALBUM+PropertiesUtility.getDataFromProperty("singleid")+EndPoints.TRACKS)
		.then().assertThat().statusCode(200).time(Matchers.lessThan(3000L),TimeUnit.MILLISECONDS).log().all();
	}
}

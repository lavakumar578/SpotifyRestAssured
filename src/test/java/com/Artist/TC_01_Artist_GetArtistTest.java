package com.Artist;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import GenericLibrary.BaseAPIClass;
import GenericLibrary.EndPoints;
import GenericLibrary.PropertiesUtility;

public class TC_01_Artist_GetArtistTest extends BaseAPIClass{

	
	
	@Test
	public void getArtistTest() {
		given()
		 .auth().oauth2(regenerateTokenAfterOneHour.regenerateTokenAfterOneHour())
		.when()
		  .get(baseURI+EndPoints.ARTISTS+PropertiesUtility.getDataFromProperty("artistId"))
		.then().assertThat().statusCode(200).time(Matchers.lessThan(3000L),TimeUnit.MILLISECONDS).log().all();
		
		
	}
}

package com.Artist;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import GenericLibrary.BaseAPIClass;
import GenericLibrary.EndPoints;
import GenericLibrary.PropertiesUtility;

public class TC_02_Artist_GetSeveralArtistsTest extends BaseAPIClass{

	@Test
	public void GetSeveralArtistsTest() {
		given()
		 .auth().oauth2(regenerateTokenAfterOneHour.regenerateTokenAfterOneHour())
		 .queryParam("ids", PropertiesUtility.getDataFromProperty("severalArtistId"))
		.when()
		  .get(baseURI+EndPoints.ARTISTS)
		.then().assertThat().statusCode(200).time(Matchers.lessThan(3000L),TimeUnit.MILLISECONDS).log().all();
		
		
		
	}
}

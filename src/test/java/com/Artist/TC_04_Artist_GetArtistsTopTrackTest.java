package com.Artist;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import GenericLibrary.BaseAPIClass;
import GenericLibrary.EndPoints;
import GenericLibrary.PropertiesUtility;

public class TC_04_Artist_GetArtistsTopTrackTest extends BaseAPIClass {
	
	@Test
	public void GetArtistsTopTrackTest() {
		given()
		 .auth().oauth2(regenerateTokenAfterOneHour.regenerateTokenAfterOneHour())
		 .queryParam("market", PropertiesUtility.getDataFromProperty("country"))
		.when()
		  .get(baseURI+EndPoints.ARTISTS+PropertiesUtility.getDataFromProperty("artistId")+EndPoints.TOPTRACKS)
		.then().assertThat().statusCode(200).time((Matchers.lessThan(3000L)),TimeUnit.MILLISECONDS).log().all();
		
		
	}

}

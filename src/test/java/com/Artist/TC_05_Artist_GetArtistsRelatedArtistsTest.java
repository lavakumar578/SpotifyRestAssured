package com.Artist;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import GenericLibrary.BaseAPIClass;
import GenericLibrary.EndPoints;
import GenericLibrary.PropertiesUtility;

public class TC_05_Artist_GetArtistsRelatedArtistsTest extends BaseAPIClass{
	
	@Test
	public void GetArtistsRelatedArtistsTest() {
		
		given()
		 .auth().oauth2(regenerateTokenAfterOneHour.regenerateTokenAfterOneHour())
		 .queryParam("market", PropertiesUtility.getDataFromProperty("country"))
		.when()
		  .get(baseURI+EndPoints.ARTISTS+PropertiesUtility.getDataFromProperty("artistId")+EndPoints.RELATEDARTIST)
		.then().assertThat().statusCode(200).time((Matchers.lessThan(3000L)),TimeUnit.MILLISECONDS).log().all();
		
	}

}

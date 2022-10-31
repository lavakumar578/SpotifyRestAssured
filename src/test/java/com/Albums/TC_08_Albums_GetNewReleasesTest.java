package com.Albums;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import GenericLibrary.BaseAPIClass;
import GenericLibrary.EndPoints;
import GenericLibrary.PropertiesUtility;

public class TC_08_Albums_GetNewReleasesTest extends BaseAPIClass{

	
	@Test(priority = 8)
	public void getNewReleasesTest() {
		given()
		 .auth().oauth2(regenerateTokenAfterOneHour.regenerateTokenAfterOneHour())
		 .queryParam("country", PropertiesUtility.getDataFromProperty("country"))
		.when()
		  .get(baseURI+EndPoints.NEWRELEASES)
		.then().assertThat().statusCode(200).time(Matchers.lessThan(3000L),TimeUnit.MILLISECONDS).log().all();
		
		
	}
}

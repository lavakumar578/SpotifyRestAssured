package com.Albums;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import GenericLibrary.BaseAPIClass;
import GenericLibrary.EndPoints;
import GenericLibrary.PropertiesUtility;

public class TC_04_Albums_GetSavedAlbumsTest extends BaseAPIClass {

	@Test(priority = 4)
	public void getSavedAlbumsTest() {
		given()
		 .auth().oauth2(regenerateTokenAfterOneHour.regenerateTokenAfterOneHour())
		 .queryParam("limit", PropertiesUtility.getDataFromProperty("limit"))
		.when()
		  .get(baseURI+EndPoints.SAVEDALBUMS)
		.then().assertThat().statusCode(200).time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS).log().all();
	}
}

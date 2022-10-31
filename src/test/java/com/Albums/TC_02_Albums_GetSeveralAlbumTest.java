package com.Albums;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import GenericLibrary.BaseAPIClass;
import GenericLibrary.EndPoints;
import GenericLibrary.PropertiesUtility;

public class TC_02_Albums_GetSeveralAlbumTest extends BaseAPIClass{
	
	@Test(priority = 2)
	public void getSeveralAlbumTest() {
		given()
		 .auth().oauth2(regenerateTokenAfterOneHour.regenerateTokenAfterOneHour())
		.queryParam("ids", PropertiesUtility.getDataFromProperty("albumIds"))
		 .when()
		  .get(baseURI+EndPoints.GETALBUM)
		.then().assertThat().statusCode(200).time(Matchers.lessThan(3000L),TimeUnit.MILLISECONDS).log().all();
	}

}

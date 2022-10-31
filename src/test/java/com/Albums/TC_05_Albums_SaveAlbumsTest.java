package com.Albums;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import GenericLibrary.BaseAPIClass;
import GenericLibrary.EndPoints;
import GenericLibrary.PropertiesUtility;

public class TC_05_Albums_SaveAlbumsTest extends BaseAPIClass {

	@Test(priority = 5)
	public void saveAlbumsTest() {
		given()
		 .auth().oauth2(regenerateTokenAfterOneHour.regenerateTokenAfterOneHour())
		 .queryParam("ids", PropertiesUtility.getDataFromProperty("saveAlbumId"))
		.when()
		  .put(baseURI+EndPoints.SAVEDALBUMS)
		.then().assertThat().statusCode(200).time(Matchers.lessThan(3000L),TimeUnit.MILLISECONDS).log().all();
	}
}

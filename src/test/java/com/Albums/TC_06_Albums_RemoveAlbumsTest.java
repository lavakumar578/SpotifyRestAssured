package com.Albums;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import GenericLibrary.BaseAPIClass;
import GenericLibrary.EndPoints;
import GenericLibrary.PropertiesUtility;

public class TC_06_Albums_RemoveAlbumsTest extends BaseAPIClass{
	@Test(priority = 6)
	public void removeAlbumsTest() {
		
		given()
		 .auth().oauth2(regenerateTokenAfterOneHour.regenerateTokenAfterOneHour())
		 .queryParam("ids", PropertiesUtility.getDataFromProperty("saveAlbumId"))
		.when()
		  .delete(baseURI+EndPoints.SAVEDALBUMS)
		.then().assertThat().statusCode(200).time(Matchers.lessThan(3000L),TimeUnit.MILLISECONDS).log().all();
	}

}

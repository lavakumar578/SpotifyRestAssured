package com.Playlist;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import GenericLibrary.BaseAPIClass;
import GenericLibrary.EndPoints;
import GenericLibrary.PropertiesUtility;

public class TC_01_Playlist_GetPlaylistTest extends BaseAPIClass {

	@Test
	public void getPlaylistTest() {
		given()
		 .auth().oauth2(regenerateTokenAfterOneHour.regenerateTokenAfterOneHour())
		 .queryParam("additional_types","track")
		.when()
		  .get(baseURI+EndPoints.PLAYLISTS+PropertiesUtility.getDataFromProperty("playlistId"))
		.then().assertThat().statusCode(200).time(Matchers.lessThan(3000L),TimeUnit.MILLISECONDS).log().all();
		
	}
}

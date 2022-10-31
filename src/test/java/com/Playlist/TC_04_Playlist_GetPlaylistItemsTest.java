package com.Playlist;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import GenericLibrary.BaseAPIClass;
import GenericLibrary.EndPoints;
import GenericLibrary.PropertiesUtility;

public class TC_04_Playlist_GetPlaylistItemsTest extends BaseAPIClass {

	@Test
	public void getPlaylistItemsTest() {
		given()
		 .auth().oauth2(regenerateTokenAfterOneHour.regenerateTokenAfterOneHour())
		.when()
		  .get(baseURI+EndPoints.PLAYLISTS+PropertiesUtility.getDataFromProperty("playlistId")+EndPoints.TRACKS)
		.then().assertThat().statusCode(200).time(Matchers.lessThan(3000L),TimeUnit.MILLISECONDS).log().all();
		
	}
}

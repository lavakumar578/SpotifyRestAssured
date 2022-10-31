package com.Playlist;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericLibrary.BaseAPIClass;
import GenericLibrary.EndPoints;
import GenericLibrary.PropertiesUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TC_05_Playlist_AddItemsToPlaylistTest extends BaseAPIClass{

	@Test
	public void createPlaylistTest() {
		
		
		
		File file=new File(PropertiesUtility.getDataFromProperty("filePath"));
		given()
		 .auth().oauth2(regenerateTokenAfterOneHour.regenerateTokenAfterOneHour()).body(file).contentType(ContentType.JSON)
		.when()
		  .post(baseURI+EndPoints.PLAYLISTS+PropertiesUtility.getDataFromProperty("playlistId")+EndPoints.TRACKS)
		.then().assertThat().statusCode(201).time(Matchers.lessThan(3000L),TimeUnit.MILLISECONDS).log().all();
		

	}

}

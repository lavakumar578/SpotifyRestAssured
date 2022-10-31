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

public class TC_06_Playlist_UpdatePlaylistItemsTest extends BaseAPIClass{

	@Test
	public void changePlaylistDetailsTest()
	{
		
		File file=new File(PropertiesUtility.getDataFromProperty("filePath2"));
		given()
		 .auth().oauth2(regenerateTokenAfterOneHour.regenerateTokenAfterOneHour())
		 .body(file).contentType(ContentType.JSON)
		.when()
		  .put(baseURI+EndPoints.PLAYLISTS+PropertiesUtility.getDataFromProperty("playlistId")+EndPoints.TRACKS)
		.then().log().all();
	}
}

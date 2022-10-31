package com.Playlist;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericLibrary.BaseAPIClass;
import GenericLibrary.EndPoints;
import GenericLibrary.PropertiesUtility;

public class TC_03_Playlist_ChangePlaylistDetailsTest extends BaseAPIClass{

	
	@Test
	public void changePlaylistDetailsTest()
	{
		
		JSONObject js=new JSONObject();
		js.put("name","LK playlist");
		js.put("description", "Hit songs");
		js.put("public", false);
		given()
		 .auth().oauth2(regenerateTokenAfterOneHour.regenerateTokenAfterOneHour())
		 .body(js)
		.when()
		  .put(baseURI+EndPoints.PLAYLISTS+"/604SU3tJUAJshxCtGuoO0P")
		.then().assertThat().statusCode(200).time(Matchers.lessThan(3000L),TimeUnit.MILLISECONDS).log().all();
	}
}

package com.Playlist;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericLibrary.BaseAPIClass;
import GenericLibrary.EndPoints;
import GenericLibrary.PropertiesUtility;
import io.restassured.response.Response;

public class TC_02_PlayList_CreatePlaylistTest extends BaseAPIClass{

	
	@Test
	public void createPlaylistTest() {
		
		JSONObject js=new JSONObject();
		js.put("name", "My Album");
		js.put("description", "hit songs");
		js.put("public", false);
		
		Response response=given()
		 .auth().oauth2(regenerateTokenAfterOneHour.regenerateTokenAfterOneHour()).body(js)
		.when()
		  .post(baseURI+EndPoints.USERS+PropertiesUtility.getDataFromProperty("userId")+EndPoints.PLAYLISTS)
		.then().assertThat().statusCode(201).time(Matchers.lessThan(3000L),TimeUnit.MILLISECONDS).log().all().extract().response();
		
		String spotifyId=restAssuredUtility.getJSONData(response, "external_urls.spotify");
		String actualPlaylistID=spotifyId.substring(34);
		System.out.println(actualPlaylistID);

	}
}

package com.spotifyAuthorization;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import GenericLibrary.BaseAPIClass;
import GenericLibrary.EndPoints;
import GenericLibrary.ILocationPath;
import GenericLibrary.PropertiesUtility;

public class GetTokenTest extends BaseAPIClass{

	@Test
	public void basicAuthTest() {
		
		given()
		  .queryParam("redirect_uri", "https://localhost:8085").queryParam("grant_type", "authorization_code").queryParam("client_id", "2f1fba8db1f546bab3cab375e75bff05")
		  .queryParam("client_secret", "9ad478ddd68741c7be732dea4fb008ea").queryParam("code","AQBupizN4puwT5ZnfmkhVq7lMUhe6aOaS7_J_EvtAscxOm62sgmBVA5zVojQYNMUva0McLyR0MrkE6V5cZ-4cBLmVFV95Qtk9n19p_AiE0U2tBqlnwGOJ-heUolyuCjgAY8b6UkdsgVeFawPXPY_F_OthdyxFLgx53EILT7LU34-n6o6TUYCjWu7jGnhV-wozGAwtA_qdoqHsIRmXmqwZwqCWtWwDwrZSMiu_eVZ4SHu-U5U_eyJs-otAOS9tlanCYQVdHZRb4_isD0friW7EQX2NdqK7IGAGZEU7YE1eejrEq2_VedU9eZtak3GsI-cbA4R1jTHx0g6ZYswLD1flNhLrgf1sEvSNMsJNDZW_yZocqpXr-8otyEUq5HlPLP-zLgA3E-BDD5Uvnzlu6C9qxfsnApzqM8OksFkpsD0m5PAWfkboPie7RqoPJ1dzqluTUhQC6RoMa5CLNarbD5FajK9x-Knb25Y46b9AWxE_p4EqHDJP-LPnYhvv_A5ObZmqlAj-5gX8AXxrE6Ydhol0vPLdlXYVVNlGuTWy00qi0YNuk8o9zyDMgMYr0aWIV25Dsgah1qZL2E0Vsf-6zC8sFqHH5nn0l8KidnE5LvFLk_eW8LxN3sJs4N4D3QpCSOO5eyj0WRMtLfx0zDRp9hCZv8YjvjeTn8Huz4pEgD4sUPYl_CNqZtl5XQrICFz5DWkpwO5IchRiVOm-EgY")
		.when()
		  .post(authorizationURI)
		.then().log().all();
	}
	
}
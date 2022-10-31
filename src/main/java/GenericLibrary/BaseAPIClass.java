package GenericLibrary;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.spotifyAuthorization.RegenerateTokenAfterOneHour;
import com.spotifyAuthorization.RenewTokenTest;
/**
 * This class is baseclass where all API classes will extend from here
 * @author LAVA KUMAR
 *
 */
public class BaseAPIClass {

	public RestAssuredUtility restAssuredUtility=new RestAssuredUtility();
	public RegenerateTokenAfterOneHour regenerateTokenAfterOneHour=new RegenerateTokenAfterOneHour();
	public static  String authorizationURI;
	public static String accessToken;
	public static String baseURI;
	static 
	{
	try {
		PropertiesUtility.openPropertyFile(ILocationPath.PROPERTYPATH);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	baseURI=PropertiesUtility.getDataFromProperty("baseURI");
	authorizationURI=PropertiesUtility.getDataFromProperty("authorizationURI");
	}
	
	@BeforeSuite
	public void beforeConfiguration() throws SQLException, IOException {
		Reporter.log("----API Request Sent--------",true);
			
	}
	
	@AfterSuite
	public void afterConfiguration() throws SQLException {
		Reporter.log("---------API Response Received--------",true);
		
	}
}

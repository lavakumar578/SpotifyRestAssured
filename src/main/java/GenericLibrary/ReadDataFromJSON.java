package GenericLibrary;

	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.Iterator;
	import org.json.simple.JSONArray;
	import org.json.simple.JSONObject;
	import org.json.simple.parser.JSONParser;
	import org.json.simple.parser.ParseException;

	public class ReadDataFromJSON {
	    public String [] timeAccessToken() {
	    	String T = null;
	    	String ATK = null;
	        JSONParser parser = new JSONParser();

	        try {     
	            Object obj = parser.parse(new FileReader("D:\\TEST YANTRA\\selenium\\Rest Assured API\\Spotify\\src\\test\\resources\\data.json"));
	            JSONObject jsonObject =  (JSONObject) obj;
	            T = (String) jsonObject.get("time");
	            ATK = (String) jsonObject.get("accessToken");
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        return new String[] {T,ATK};
	    }
	    
	    
	}


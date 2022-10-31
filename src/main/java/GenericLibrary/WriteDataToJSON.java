package GenericLibrary;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONObject;

import com.spotifyAuthorization.RenewTokenTest;

public class WriteDataToJSON {  

    public String writeData() {  

    	SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
        String time = localDateFormat.format(new Date());       
        RenewTokenTest test=new RenewTokenTest();
        String accessToken=test.refreshToken();
	
        JSONObject accessTK = new JSONObject();  
        accessTK.put("accessToken",accessToken );  
        accessTK.put("time", time);  
 
        

        try {  

            // Writing to a file  
            File file=new File("D:\\TEST YANTRA\\selenium\\Rest Assured API\\Spotify\\src\\test\\resources\\data.json");  
            file.createNewFile();  
            FileWriter fileWriter = new FileWriter(file);  
            System.out.println("Writing JSON object to file");  
            System.out.println("-----------------------");  
            System.out.print("Data entered "+accessTK);  

            fileWriter.write(accessTK.toJSONString());  
            fileWriter.flush();  
            fileWriter.close();  

        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return accessToken;
    }  
}  

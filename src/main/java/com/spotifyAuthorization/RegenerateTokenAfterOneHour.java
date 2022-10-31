package com.spotifyAuthorization;

import GenericLibrary.GetTime;
import GenericLibrary.ReadDataFromJSON;
import GenericLibrary.StringToInteger;
import GenericLibrary.WriteDataToJSON;

public class RegenerateTokenAfterOneHour {

	
	public String  regenerateTokenAfterOneHour(){
		String accessToken = null;
		
		StringToInteger stoI=new StringToInteger();
		ReadDataFromJSON readDataFromJSON=new ReadDataFromJSON();
		WriteDataToJSON writeDataToJSON=new WriteDataToJSON();
		GetTime gettime=new GetTime();
		String t=gettime.getTime().replace(":", "");
		String []s=readDataFromJSON.timeAccessToken();
		int time=stoI.stringToInteger(s[0].replace(":", ""));
		int actTime=stoI.stringToInteger(t);
	
		int maxTime=time+10000;
		
			if(time<=maxTime && maxTime<actTime)
			{
				accessToken=writeDataToJSON.writeData();
				
			}
			else{
			
				accessToken=s[1];
				
			}
			return accessToken;
	}
}

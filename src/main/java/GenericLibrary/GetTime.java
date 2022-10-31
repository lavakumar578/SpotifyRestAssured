package GenericLibrary;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetTime {

	public String getTime() {
		SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
        String time = localDateFormat.format(new Date());
        return time;
	}
}

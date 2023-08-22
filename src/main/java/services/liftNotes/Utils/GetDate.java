package services.liftNotes.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate {
    public static String currentDate(){
          Date currentDate = new Date();
          SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
          String formattedDate = dateFormat.format(currentDate);
          return formattedDate;
    }
}

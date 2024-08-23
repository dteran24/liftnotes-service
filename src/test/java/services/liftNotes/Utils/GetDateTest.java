package services.liftNotes.Utils;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
class GetDateTest {

    @Test
    public void testCurrentDate(){
        //Get current date
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
        String expectedDate = dateFormat.format(currentDate);

        //call method
        String actualDate = GetDate.currentDate();

        //Assert actual date matches expected date
        assertEquals(expectedDate, actualDate, "The date format should match M/d/yyyy");
    }
}
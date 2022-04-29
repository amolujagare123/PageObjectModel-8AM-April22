package utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversion {

    public static String convertCountry(String countryShort) //
    {
        String convertedCountry="";

        switch (countryShort)
        {
            case "IN" : convertedCountry="India";break;
            case "DE" : convertedCountry="Germany";break;
            case "GR" : convertedCountry="Greece";break;
            case "HU" : convertedCountry="Hungary";break;
            case "JP" : convertedCountry="Japan";break;
            case "LY" : convertedCountry="Libya";break;
            case "NG" : convertedCountry="Nigeria";break;
        }

        return  convertedCountry;
    }

    public static String getGender(String genderId) // db
    {
        String gender = "";

        switch (genderId)
        {
            case "0" : gender="Male";break;
            case "1" : gender="Female";break;
            case "2" : gender="Other";break;
        }
        return gender;
    }

    //--> MM/dd/yyyy --> FDS /PSD
    public static String convertDate(String dbDateStr) throws ParseException // yyyy-MM-dd

    {
        SimpleDateFormat sd1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sd1.parse(dbDateStr);

        SimpleDateFormat sd2 = new SimpleDateFormat("MM/dd/yyyy");
        String convertedDate  = sd2.format(date);

        return convertedDate;

       /* Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dbDateStr);
        return  new SimpleDateFormat("MM/dd/yyyy").format(date);*/
    }
}

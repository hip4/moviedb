package ch.bfh.ti.aimlessweeknight.moviedb.testutils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Assert;

/**
 * Created by higuys on 25/11/14.
 */
public class AssertDate {

    public static final String DATE_PATTERN = "dd.MM.yyyy";
    public static void assertEquals(Date expected, Date value) {
        DateFormat formatter = new SimpleDateFormat(DATE_PATTERN);
        String strExpected = formatter.format(expected);
        String strValue = formatter.format(value);
        Assert.assertEquals(strExpected, strValue);
    }
}

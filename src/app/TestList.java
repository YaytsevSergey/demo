package app;

import static org.junit.Assert.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.Test;

public class TestList {

	@Test
	public void test1() {
		DepoSimple d1 = new DepoSimple(new GregorianCalendar(2012, Calendar.SEPTEMBER, 8).getTime(), 61, 2500.0, 18.0);
		DepoMonthCapitalize d2 = new DepoMonthCapitalize(new GregorianCalendar(2012, Calendar.FEBRUARY, 1).getTime(), 181, 10_000.0, 21.0);
        DepoAnalisys<DepoSimple> da = new DepoAnalisys<DepoSimple>(d1);
        double diff = da.<DepoMonthCapitalize>compareDepo(d2);
        assertEquals(diff, -1009.30, 0.005);
        
        double interestRate = da.<DepoMonthCapitalize>equalsByInterestRate(d2);
        assertEquals(interestRate, 1.52, 0.005);
        
        DepoSimple d3 = new DepoSimple(new GregorianCalendar(2012, Calendar.SEPTEMBER, 8).getTime(), 181, 10000.0, 18.0);
        DepoAnalisys<DepoMonthCapitalize> dam = new DepoAnalisys<DepoMonthCapitalize>(d2);
        interestRate = dam.<DepoSimple>equalsByInterestRate(d3);
        assertEquals(interestRate, 21.87, 0.005);
        
	}

}

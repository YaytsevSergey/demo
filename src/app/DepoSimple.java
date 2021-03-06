package app;

import java.util.Date;

public class DepoSimple extends DepoBase{
	
	public DepoSimple(Date startDate, int dayLong, double sum, double interestRate){
		super(startDate, dayLong, sum, interestRate);
	}
	
	public DepoSimple(){
		
	}
	@Override
	public double getInterest(){
		int daysInYear = getDaysInYear();
		double dayCf = dayLong;
		interest = sum * (interestRate / 100.0) * (dayCf / daysInYear);
		return interest;
	}

}

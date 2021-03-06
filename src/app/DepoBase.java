package app;

import java.util.*;

public abstract class DepoBase  implements Comparable<DepoBase>{
	protected Date startDate;
	protected int dayLong;
	protected double sum;
	protected double interestRate;
	protected double interest;
	
	public DepoBase() {
		this.interest = -1.0;
	}
	
	public DepoBase(Date startDate, int dayLong, double sum, double interestRate){
		this.startDate = startDate;
		this.dayLong = dayLong;
		this.sum = sum;
		this.interestRate = interestRate;
		this.interest = -1.0;
	}
	
	public Date getStartDate(){
		return startDate;
	}
	public void setStartDate(Date value){
		startDate = value;
	}

	public int getDayLong(){
		return dayLong;
	}
	public void setDayLong(int value){
		dayLong = value;
	}
	
	public double getSum(){
		return sum;
	}
	public void setSum(double value){
		sum = value;
	}
	
	public double getInterestRate(){
		return interestRate;
	}
	public void setInterestRate(double value){
		interestRate = value;
	}

	public abstract double getInterest();
	
	protected int getDaysInYear(){ 
		   GregorianCalendar calendar = new GregorianCalendar();
		   calendar.setTime(startDate); 
		   GregorianCalendar yearEnd = new GregorianCalendar(calendar.get(Calendar.YEAR), Calendar.DECEMBER, 31);
		   int ret = yearEnd.get(Calendar.DAY_OF_YEAR) - calendar.get(Calendar.DAY_OF_YEAR);
		   calendar.add(GregorianCalendar.YEAR, 1); 
		   ret += calendar.get(Calendar.DAY_OF_YEAR);
		   return ret; 
	} 

	public int compareTo(DepoBase depo) {
        if ((this.getInterest() - depo.getInterest()) > 0) return 1;
        if ((this.getInterest() - depo.getInterest()) < 0) return -1;
        return 0;
	}
}

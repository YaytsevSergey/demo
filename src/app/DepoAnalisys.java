package app;
///ddd
public class DepoAnalisys<T extends DepoBase> {
	private T depo;
	
	public DepoAnalisys(T depo){
		this.depo = depo;
	}
	

	public <TC extends DepoBase> double compareDepo(TC depo){
		double diff = this.depo.getInterest() - depo.getInterest();
		return diff;
	}
	
	public <TC extends DepoBase> double equalsByInterestRate(TC depo){
		double interestCurrent = this.depo.getInterest();
		double interestLow = depo.getInterest();
		double interestUp = 0.0;
		double interestRateLow = depo.getInterestRate();
		double interestRateCurrent = depo.getInterestRate();
		double interestRateUp = 0.0;
		double diff = interestLow - interestCurrent;
		if (diff < 0.0) diff = -diff;
		if (diff < 0.01) return depo.getInterestRate();
		interestUp = interestLow;
		if (interestLow < interestCurrent){
			while(interestUp < interestCurrent){
				depo.setInterestRate(depo.getInterestRate() * 2);
				interestUp = depo.getInterest();
				interestRateUp = depo.getInterestRate();
			}
		}
		else{
			interestUp = interestLow;
			interestRateUp = interestRateLow;
			while(interestLow >= interestCurrent){
				depo.setInterestRate(depo.getInterestRate() / 2);
				interestLow = depo.getInterest();
				interestRateLow = depo.getInterestRate();
			}
		}
		
		double interestRateNew = 0.0;
		do{
			interestRateNew = (interestRateUp > interestRateLow)?(interestRateUp - interestRateLow)/2:(interestRateLow - interestRateUp)/2;
			interestRateNew = (interestRateUp > interestRateLow)?interestRateNew + interestRateLow:interestRateNew + interestRateUp;
			depo.setInterestRate(interestRateNew);
			double interestNew = depo.getInterest();
			diff = interestNew - interestCurrent;
			if (diff < 0.0) diff = -diff;
			if (interestNew < interestCurrent){
				interestLow = interestNew;
				interestRateLow = interestRateNew;
			}
			else{
				interestUp = interestNew;
				interestRateUp = interestRateNew;
			}
		} while (diff >= 0.01);
		depo.setInterestRate(interestRateCurrent);
		return interestRateNew;
		
	}
}

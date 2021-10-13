package racinggame.domain;

import nextstep.utils.Randoms;

public class RacingCar {
	
	
	private String name;
	private int mileage = 0;
	private StringBuilder mileageStr = new StringBuilder();
	
	public RacingCar(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getMileage() {
		return this.mileage;
	}
	
	public String getMileageStr() {
		return this.mileageStr.toString();
	}
	
	public void moveOneStep() {
		mileage += 1;
		mileageStr.append("-");
	}
	
	public void move() {
		
	}
}

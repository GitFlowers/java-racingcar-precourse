package racinggame.domain;

public class RacingCar {
	private String name;
	private int mileage = 0;
	
	public RacingCar(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getMileage() {
		return this.mileage;
	}
}

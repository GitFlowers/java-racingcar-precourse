package racinggame.domain;

class RacingGameParam {
	private RacingCars racingCars;
	private RacingDistance distance;
	
	public RacingGameParam(RacingCars racingCars, RacingDistance distance) {
		this.racingCars = racingCars;
		this.distance = distance;
	}
	
	public RacingCars getRacingCars() {
		return this.racingCars;
	}
	
	public RacingDistance getRacingDistance() {
		return this.distance;
	}
}

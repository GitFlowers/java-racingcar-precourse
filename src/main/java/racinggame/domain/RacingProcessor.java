package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import nextstep.utils.Randoms;

public class RacingProcessor {
	private static int START_INCLUSIVE = 0;
	private static int END_INCLUSIVE = 9;
	private static int MIN_VALUE_FOR_MOVE = 4;
	private List<RacingCar> winners;
	
	private RacingProcessor() {}
	
	public static RacingProcessor raceStartWith(RacingCars racingCars, RacingDistance racingDistance) {
		RacingProcessor processor = new RacingProcessor();
		for (int distance = racingDistance.getDistance(); distance > 0; --distance) {
			processor.moveCars(racingCars);
		}
		processor.setWinners(racingCars, racingDistance);
		return processor;
	}
	
	private void moveCars(RacingCars racingCars) {
		int size = racingCars.size();
		for (int i = 0; i < size; ++i) {
			moveByRules(racingCars.get(i));	
		}
		printRacingCarsMilleage(racingCars);
	}
	
	private void printRacingCarsMilleage(RacingCars racingCars) {
		int size = racingCars.size();
		for (int i = 0; i < size; ++i) {
			RacingCar racingCar = racingCars.get(i);
			System.out.println(racingCar.getName() + " : " + racingCar.getMileageStr());
		}
	}
	
	private void moveByRules(RacingCar racingCar) {
		int number = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
		if (number >= MIN_VALUE_FOR_MOVE) {
			racingCar.moveOneStep();
		}
	}
	
	private void setWinners(RacingCars racingCars, RacingDistance racingDistance) {
		List<RacingCar> winners = new ArrayList<RacingCar>();
		winners.add(racingCars.get(0));
		int carCnt = racingCars.size();
		for (int i = 1; i < carCnt;  i++) {
			
			addRaceFinishedCar(racingCars.get(i), racingDistance, winners);
		}
		this.winners = winners;
	}
	
	private void addRaceFinishedCar(RacingCar car, RacingDistance racingDistance, List<RacingCar> winners) {
		if (car.getMileage() == racingDistance.getDistance()) {
			winners.add(new RacingCar(car.getName()));
		}
	}
	
	public void announceWinners() {
		if (winners.size() == 0) {
			System.out.println("경주를 완주한 자동차가 없습니다.");
			return;
		}
		StringJoiner joiner = new StringJoiner(",");
		for (RacingCar car : this.winners) {
			joiner.add(car.getName());
		}
		System.out.print("최종 우승자는 " + joiner.toString() + " 입니다.");
	}
}

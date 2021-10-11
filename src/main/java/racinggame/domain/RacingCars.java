package racinggame.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class RacingCars {
	private final int MAX_CAR_NAME_LENGTH = 5;
	
	private final List<RacingCar> list = new ArrayList<RacingCar>();
	
	public RacingCars(String[] racingCars) {
		this(Arrays.asList(racingCars));
	}
	
	public RacingCars(List<String> racingCars) {
		validateDuplicates(racingCars);
		for (String carName : racingCars) {
			validateCarNameLength(carName);
			list.add(new RacingCar(carName));
		}
	}
	
	private void validateDuplicates(List<String> racingCars) {
		HashSet<String> cars = new HashSet<>(racingCars);
		if (cars.size() != racingCars.size()) {
			throw new IllegalArgumentException("[ERROR] 중복된 이름이 존재합니다.");
		}
	}
	
	private void validateCarNameLength(String name) {
		if (name.length() > MAX_CAR_NAME_LENGTH) {
			throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자리 이하입니다.");
		}
	}
}

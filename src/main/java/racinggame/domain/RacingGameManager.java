package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import nextstep.utils.Console;
import nextstep.utils.Randoms;
import racinggame.util.ValidationUtil;

public class RacingGameManager {
	
	
	public RacingCars inputRacingCarsArgument() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String racingCars = Console.readLine();
		try {
			ValidationUtil.validateEmpty(racingCars);
			return new RacingCars(racingCars.replaceAll(" ", "").split(","));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public RacingDistance inputRacingDistanceArgument() {
		System.out.println("시도할 횟수는 몇회인가요?");
		String racingDistance = Console.readLine();
		try {
			ValidationUtil.validateEmpty(racingDistance);
			ValidationUtil.validateNumber(racingDistance);
			return new RacingDistance(Integer.parseInt(racingDistance));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public RacingGameParam argumentResolver() {
		RacingCars racingCars = null;
		RacingDistance distance = null;
		do {
			racingCars = inputRacingCarsArgument();
		} while(racingCars == null);
		do {
			distance = inputRacingDistanceArgument();
		} while(distance == null);
		return new RacingGameParam(racingCars, distance);
	}
	
	public void playGame() {
		RacingGameParam param = argumentResolver();
		RacingCars racingCars = param.getRacingCars();
		RacingDistance distance = param.getRacingDistance();
		RacingProcessor racingProcessor = RacingProcessor.raceStartWith(racingCars, distance);
		racingProcessor.announceWinners();
	}
}

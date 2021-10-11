package racinggame;


import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.domain.RacingCars;

public class RacingCarsValidationTest {

	@Test
	@DisplayName("자동차 이름 중복 유효성 테스트")
	void 자동차_이름_중복_유효성_테스트() {
		assertThatIllegalArgumentException()
		.isThrownBy(() -> {
			String cars = "타요,뿡뿡이,댕댕이,맹꽁이,구댕이,댕댕이,멍순이";
			new RacingCars(Arrays.asList(cars.split(",")));
		}).withMessageContaining("[ERROR] 중복된 이름이 존재합니다.");
	}
	
	@Test
	@DisplayName("자동차 이름 길이 유효성 테스트")
	void 자동차_이름_길이_유효성_테스트() {
		assertThatIllegalArgumentException()
		.isThrownBy(() -> {
			String cars = "타요,뿡뿡이3가지,맹꽁이,구댕이,댕댕이,멍순이";
			new RacingCars(Arrays.asList(cars.split(",")));
		}).withMessageContaining("[ERROR] 자동차 이름은 5자리 이하입니다.");
	}
}

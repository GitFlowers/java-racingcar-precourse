package racinggame;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import nextstep.test.NSTest;
import nextstep.utils.Randoms;
import racinggame.domain.RacingCars;
import racinggame.domain.RacingDistance;
import racinggame.domain.RacingProcessor;

public class RacingProcessorTest extends NSTest {
	
	@BeforeEach
    void beforeEach() {
        setUp();
    }
	
	@Test
	@DisplayName("자동차 전진 성공")
	void 자동차_전진_성공() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(4);
            String cars = "타요";
			RacingCars racingCars = new RacingCars(Arrays.asList(cars.split(",")));
			RacingDistance distance = new RacingDistance(1);
			RacingProcessor processor = RacingProcessor.raceStartWith(racingCars, distance);
			assertThat(racingCars.get(0).getMileage()).isOne();
			processor.announceWinners();
			verify("최종 우승자는 타요 입니다.");
        }
	}
	
	@Test
	@DisplayName("자동차 전진 실패")
	void 자동차_전진_실패() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(3);
            String cars = "타요";
			RacingCars racingCars = new RacingCars(Arrays.asList(cars.split(",")));
			RacingDistance distance = new RacingDistance(1);
			RacingProcessor processor = RacingProcessor.raceStartWith(racingCars, distance);
			assertThat(racingCars.get(0).getMileage()).isZero();
			processor.announceWinners();
			verify("경주를 완주한 자동차가 없습니다.");
		}
	}
	
	@AfterEach
    void tearDown() {
        outputStandard();
    }

	@Override
	protected void runMain() {
		// TODO Auto-generated method stub
		
	}
}

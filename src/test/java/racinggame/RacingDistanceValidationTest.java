package racinggame;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.domain.RacingDistance;

public class RacingDistanceValidationTest {
	
	@Test
	@DisplayName("자동차 경주 이동거리 유효성 테스트")
	void 자동차_경주_이동거리_유효성_테스트() {
		  assertThatIllegalArgumentException() .isThrownBy(() -> {
			  int inputRacingDistance = -1; 
			  new RacingDistance(inputRacingDistance);
		  }).withMessage("[ERROR] 숫자가 아닌값이나, 너무 큰 숫자를 입력하셨습니다.");
		  
		  assertThatIllegalArgumentException() .isThrownBy(() -> {
			  String inputRacingDistance = "1231sdf"; 
			  new RacingDistance(inputRacingDistance);
		  }).withMessage("[ERROR] 숫자가 아닌값이나, 너무 큰 숫자를 입력하셨습니다.");
		  
		  assertThatIllegalArgumentException() .isThrownBy(() -> { 
			  int inputRacingDistance = Integer.MAX_VALUE + 1; 
			  new RacingDistance(inputRacingDistance);
		  }).withMessage("[ERROR] 입력한 값이 너무 큽니다.");
	}
}

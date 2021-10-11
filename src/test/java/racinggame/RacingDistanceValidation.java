package racinggame;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.domain.RacingDistance;

public class RacingDistanceValidation {
	
	@Test
	@DisplayName("레이싱 경주 거리 입력 유효성 체크")
	void 레이싱_경주_거리_입력_유효성_체크() {
		assertThatIllegalArgumentException()
		.isThrownBy(()-> {
			String distance = "sefwef";
			new RacingDistance(distance);
		}).withMessage("[ERROR] 숫자가 아닌값이나, 너무 큰 숫자를 입력하셨습니다.");
	
		assertThatIllegalArgumentException()
		.isThrownBy(()-> {
			String distance = "-1";
			new RacingDistance(distance);
		}).withMessage("[ERROR] 음수는 입력할 수 없습니다.");
	}
}

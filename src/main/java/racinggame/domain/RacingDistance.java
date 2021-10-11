package racinggame.domain;

import racinggame.util.StringUtil;

public class RacingDistance {
	private final int distance;
	public RacingDistance(int distance) {
		validateRange(distance);
		this.distance = distance;
	}
	
	public RacingDistance(String distance) {
		validateNumber(distance);
		int _distance = Integer.parseInt(distance);
		validateRange(_distance);
		this.distance = _distance;
	}
	
	private void validateNumber(String distance) {
		if (!StringUtil.isNumber(distance)) {
			throw new IllegalArgumentException("[ERROR] 숫자가 아닌값이나, 너무 큰 숫자를 입력하셨습니다.");
		}
	}
	
	private void validateRange(int distance) {
		if (distance <= 0) {
			throw new IllegalArgumentException("[ERROR] 음수는 입력할 수 없습니다.");
		}
	}
	
	public int getDistance() {
		return this.distance;
	}
}

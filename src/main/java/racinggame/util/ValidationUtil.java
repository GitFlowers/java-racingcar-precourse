package racinggame.util;

public class ValidationUtil {
	public static void validateEmpty(Object value) {
		if (value == null || (value instanceof String && "".equals(value))) {
			throw new IllegalArgumentException("[ERROR] 빈값을 입력하셨습니다.");
		}
	}
	
	public static void validateNumber(String value) {
		if (!StringUtil.isNumber(value)) {
			throw new IllegalArgumentException("[ERROR] 숫자가 아닌값을 입력하셨습니다.");
		}
	}
}

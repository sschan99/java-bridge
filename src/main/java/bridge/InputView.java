package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSize = Console.readLine();
        validateBridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moving = Console.readLine();
        validateMoving(moving);
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    /**
     * 다리의 길이가 올바르게 입력되었는지 검사한다.
     */
    private void validateBridgeSize(String bridgeSize) {
        if (Pattern.matches("^[0-9]+$", bridgeSize)) {
            throw new IllegalArgumentException("[ERROR] 숫자만을 입력하십시오.");
        }
        int number = Integer.parseInt(bridgeSize);
        if (number < 3 || number > 20) {
            throw new IllegalArgumentException("[ERROR] 3 이상 20 이하의 값을 입력하십시오.");
        }
    }

    /**
     * 사용자가 이동할 칸이 올바르게 입력되었는지 검사한다.
     */
    private void validateMoving(String moving) {
        if (moving.length() != 1) {
            throw new IllegalArgumentException("[ERROR] 하나의 문자를 입력하십시오.");
        }
        if (!moving.equals("U") && !moving.equals("D")) {
            throw new IllegalArgumentException("[ERROR] 입력할 수 있는 값은 U(위 칸)와 D(아래 칸)로 제한됩니다.");
        }
    }
}

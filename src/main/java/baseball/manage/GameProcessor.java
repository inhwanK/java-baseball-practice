package baseball.manage;

import camp.nextstep.edu.missionutils.Console;

public class GameProcessor {

    public void inputProcess() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        validateInput(input);
    }

    private void validateInput(String input) {
        // 입력이 비어있는 경우
        if (input.isBlank()) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        // 숫자가 아닌 경우
        if (isDigitString(input)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        // 길이가 4 이상일 경우
        if (input.length() > 3) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private boolean isDigitString(String input) {
        return input.replaceAll("[^0-9]", "").isEmpty();
    }
}

package baseball.manage;

import camp.nextstep.edu.missionutils.Console;

public class GameFinisher {
    public int inputFinishOrRestart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        validateInput(input);
        return Integer.parseInt(input);
    }

    private void validateInput(String input) {
        // 입력이 비어있는 경우
        if (input.isBlank()) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        // 숫자가 아닌 경우
        if (isOneTwo(input)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        // 길이가 4 이상일 경우
        if (input.length() > 1) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private boolean isOneTwo(String input) {
        return input.replaceAll("[^1-2]", "").isEmpty();
    }
}

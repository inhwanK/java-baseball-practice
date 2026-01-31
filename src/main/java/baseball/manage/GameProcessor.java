package baseball.manage;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameProcessor {

    public String inputProcess() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        validateInput(input);
        return input;
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

    public boolean guessNumber(String number, String input) {
        // ball, strike 카운트
        List<Integer> numbers = setNumbers(number);
        Guess result = getGuessResult(input, numbers);
        if(result.correct()) {
            return true;
        }
        System.out.println(result.getResult());
        return false;
    }

    private Guess getGuessResult(String input, List<Integer> numbers) {
        Guess result = new Guess(0,0);
        for (int i = 0; i < input.length(); i++) {
            int now = input.charAt(i) - '0';
            if(numbers.get(i) == now) {
                result.plusStrike();
            } else if(numbers.contains(now)) {
                result.plusBall();
            }
        }
        return result;
    }

    private List<Integer> setNumbers(String number) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < number.length(); i++) {
            numbers.add(Integer.parseInt(String.valueOf(number.charAt(i))));
        }
        return numbers;
    }
}

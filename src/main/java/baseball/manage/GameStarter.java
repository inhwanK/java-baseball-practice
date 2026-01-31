package baseball.manage;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameStarter {
    private StringBuilder sb;

    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public String createNumber() {
        sb = new StringBuilder();
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return sb.append(computer.get(0)).append(computer.get(1)).append(computer.get(2)).toString();
    }

}

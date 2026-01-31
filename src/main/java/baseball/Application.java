package baseball;

import baseball.manage.GameFinisher;
import baseball.manage.GameManager;
import baseball.manage.GameProcessor;
import baseball.manage.GameStarter;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 게임 매니저에게 게임 시작 요청 메시지 전송
        GameManager gameManager = new GameManager(new GameStarter(), new GameProcessor(), new GameFinisher());
        gameManager.start();
    }
}

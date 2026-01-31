package baseball.manage;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

// 게임을 관리하는 책임을 가짐.
public class GameManager {
    boolean restart = false;
    private String number;

    private GameStarter gameStarter;
    private GameProcessor gameProcessor;
    private GameFinisher gameFinisher;

    public GameManager(GameStarter gameStarter, GameProcessor gameProcessor, GameFinisher gameFinisher) {
        this.gameStarter = gameStarter;
        this.gameProcessor = gameProcessor;
        this.gameFinisher = gameFinisher;
    }

    // 게임 시작
    public void start() {
        // 시작 메시지 출력
        if(!restart) {
            gameStarter.printStartMessage();
        }
        // 3개의 임의의 숫자를 생성, 생성한 숫자 저장
        this.number = gameStarter.createNumber();
        process();
    }


    // 게임 진행
    private void process() {
        // 사용자로부터 숫자를 입력받음
        gameProcessor.inputProcess();

        // 숫자에 대한 결과를 출력함
        // 종료 조건이 되면 게임 종료 요청 메시지를 보냄
    }

    // 게임 종료
        // 게임을 종료함.
        // 게임 재시작 조건이 되면 시작 요청 메시지를 보냄
}

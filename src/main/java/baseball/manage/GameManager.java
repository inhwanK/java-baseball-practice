package baseball.manage;

// 게임을 관리하는 책임을 가짐.
public class GameManager {
    boolean finished = false;
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
        if (!restart) {
            gameStarter.printStartMessage();
        }
        // 3개의 임의의 숫자를 생성, 생성한 숫자 저장
        this.number = gameStarter.createNumber();
        process();
    }


    // 게임 진행
    private void process() {
        // 사용자로부터 숫자를 입력받음
        while (!finished) {
            String input = gameProcessor.inputProcess();
            if (gameProcessor.guessNumber(number, input)) {
                finished = true;
            }
        }
        // 종료 조건이 되면 게임 종료 요청 메시지를 보냄
        finish();
    }

    private void finish() {
        // 게임 종료
        int input = gameFinisher.inputFinishOrRestart();
        if (input == 1) {
            restart = true;
            finished = false;
            start();
        }
    }

}

package baseball.manage;

public class Guess {
    private int ball;
    private int strike;

    public Guess(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public void plusBall() {
        ball++;
    }

    public void plusStrike() {
        strike++;
    }

    public boolean correct() {
        if(strike == 3) {
            return true;
        }
        return false;
    }

    public String getResult() {
        StringBuilder sb = new StringBuilder();
        if (ball > 0) {
            sb.append(ball).append("볼 ");
        }
        if (strike > 0) {
            sb.append(strike).append("스트라이크");
        }
        if (sb.length() == 0) {
            return "낫싱";
        }
        return sb.toString().trim();
    }
}

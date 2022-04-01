package io.labforward.javadojo;

public enum Result {

    PLAYER1("Player 1 wins!"), PLAYER2("Player 2 wins!"), DRAW("Draw! Play again.");

    private String result;

    Result(String result) {
        this.result = result;
    }

    public String toString() {
        return result;
    }

}
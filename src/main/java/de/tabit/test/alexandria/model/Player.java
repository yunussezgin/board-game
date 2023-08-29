package de.tabit.test.alexandria.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {

    private final int number;  //Unique player id
    private int fieldNumber;  //Player position on the board
    private boolean hasSkipNextTrap = false;  //Joker
    private boolean hasSkipNextRound = false;  //Punishment

    public Player(int number) {
        this.number = number;
    }

    public int plusFieldNumber(int fieldCount) {
        this.fieldNumber = this.fieldNumber + fieldCount;
        return this.fieldNumber;
    }

    public int minusFieldNumber(int fieldCount) {
        this.fieldNumber = this.fieldNumber - fieldCount;
        if (this.fieldNumber < 0) {
            this.fieldNumber = 0;
        }
        return this.fieldNumber;
    }

}

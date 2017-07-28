package com.michaelgokeefe.chapter7.callcenter;

public enum Rank {

    Low(0), Middle(1), High(2);

    private int rank;

    Rank(int rank) {
        this.rank = rank;
    }

    int getRank() {
        return rank;
    }
}

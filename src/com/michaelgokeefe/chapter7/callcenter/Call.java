package com.michaelgokeefe.chapter7.callcenter;

public class Call {
    private Rank rank;
    private Caller caller;
    private Employee handler;

    public Call(Caller caller) {
        this.rank = Rank.Low;
        this.caller = caller;
    }

    public void setHandler(Employee employee) {

    }

    public void reply(String message) {

    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {

    }

    public Rank incrementRank() {
        return null;
    }

    public void disconnect() {

    }
}

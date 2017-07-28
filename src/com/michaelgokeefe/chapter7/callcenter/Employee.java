package com.michaelgokeefe.chapter7.callcenter;

public abstract class Employee {
    private Call currentCall = null;
    private Rank rank;

    public Employee(Rank rank) {
        this.rank = rank;
    }

    public void recieveCall(Call call) {
        currentCall = call;
    }

    public void callCompleted() {

    }

    public void escalateAndReassign() {

    }

    public boolean assignNewCall() {
        return false;
    }

    public boolean isFree() {
        return currentCall == null;
    }

    public Rank getRank() {
        return rank;
    }
}

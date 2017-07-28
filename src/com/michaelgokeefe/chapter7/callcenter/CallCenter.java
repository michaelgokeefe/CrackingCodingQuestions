package com.michaelgokeefe.chapter7.callcenter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CallCenter {
    private final int LEVELS = 3;

    private final int NUM_RESPONDENTS = 10;
    private final int NUM_MANAGERS = 5;
    private final int NUM_DIRECTORS = 2;

    List<List<Employee>> employeeLevels;
    List<List<Call>> callQueues;

    public CallCenter() {
        initCallQueue();
        initEmployeeLevels();
    }

    private void initCallQueue() {

    }

    private void initEmployeeLevels() {

    }

    public void dispatchCall(Caller caller) {
        Call call = new Call(caller);
        dispatchCall(call);
    }

    public void dispatchCall(Call call) {
        try {
            Employee employee = getNextAvailableEmployee();
            employee.recieveCall(call);
            call.setHandler(employee);
        } catch (AllEmployeesBusy e) {
            call.reply("Please wait");
            callQueues.get(call.getRank().getRank()).add(call);
        }
    }

    public boolean assignCall(Employee employee) {
        return false;
    }

    private Employee getNextAvailableEmployee() {
        return null;
    }
}

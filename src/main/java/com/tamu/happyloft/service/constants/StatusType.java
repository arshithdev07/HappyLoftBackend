package com.tamu.happyloft.service.constants;

/**
 * Created by arshi on 4/22/2020.
 */
public enum StatusType {

    NEW (1),
    IN_PROGRESS(2),
    COMPLETED(3);

    StatusType(int value) {
        this.value = value;
    }

    private int value;


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

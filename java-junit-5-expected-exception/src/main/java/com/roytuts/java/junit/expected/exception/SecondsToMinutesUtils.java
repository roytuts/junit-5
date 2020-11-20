package com.roytuts.java.junit.expected.exception;

public class SecondsToMinutesUtils {

    public int secsToMins(int seconds) {
        if (seconds <= 0) {
            throw new IllegalArgumentException("seconds (" + seconds + ") cannot be 0 or negative");
        }
        
        return seconds / 60;
    }

}

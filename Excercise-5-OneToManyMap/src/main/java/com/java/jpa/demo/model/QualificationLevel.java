package com.java.jpa.demo.model;

import java.util.Arrays;
import java.util.Optional;

/**
 *
 * @author yash
 */
public enum QualificationLevel {
    Beginner(1),
    Intermediate(2),
    Pro(3);

    private int legIndex;

    private QualificationLevel(int legIndex) {
        this.legIndex = legIndex;
    }

    public static Optional<QualificationLevel> valueOf(int value) {
        return Arrays.stream(values())
                .filter(legNo -> legNo.legIndex == value)
                .findFirst();
    }

}

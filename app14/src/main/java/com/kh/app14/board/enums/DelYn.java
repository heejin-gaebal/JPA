package com.kh.app14.board.enums;

public enum DelYn {
    Y("deleted"), N("activate");

    private final String label;

    DelYn(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }
}

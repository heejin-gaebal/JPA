package com.kh.app12.member.enums;

public enum DelYn {
    Y("삭제됨"), N("정상");

    private final String label;

    DelYn(String str) {
        this.label = str;
    }

    public String getLabel() {
        return label;
    }
}

package com.kh.app08.board;

public class BoardException extends RuntimeException {
    public BoardException() {
    }

    public BoardException(String message){
        super(message);
    }
}

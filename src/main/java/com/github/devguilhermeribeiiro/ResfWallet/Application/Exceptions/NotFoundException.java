package com.github.devguilhermeribeiiro.ResfWallet.Application.Exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}

package br.com.itau.catApi.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String s){
        super(s);
    }
}

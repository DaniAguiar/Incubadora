package com.invillia.springregister.exception;

public class AcitonNotPermitedException extends  RuntimeException{

    public AcitonNotPermitedException(final String message){
        super("Ação não permitida!");
    }
}

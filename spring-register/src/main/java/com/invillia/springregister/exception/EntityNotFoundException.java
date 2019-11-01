package com.invillia.springregister.exception;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(final String message){
        super("Membro Não Encontrado, ID: " + message);
    }
}

package com.desafiospring.demo.ExceptionsHandler;

public class findCategoryException extends Exception {

    public findCategoryException (String categoryName)
    {
        super("La siguiente categoria " + categoryName + " no se encuentra");
    }
}

package com.ssm.exception;

public class StockDeficiencyException extends Exception{
    private static final long serialVersionUID = 1L;
    public StockDeficiencyException(){
        super();
    }
    public StockDeficiencyException(String message){
        super(message);
    }
    public  StockDeficiencyException(Throwable cause){
        super(cause);
    }
    public StockDeficiencyException(String message,Throwable cause){
        super(message,cause);
    }
    public StockDeficiencyException(String message,Throwable cause,boolean enableSuppression,boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package com.example.demo.exception;

public class HnDBankException extends Exception{
    String mesg;
    public HnDBankException(String mesg){
        this.mesg = mesg;
    }
    public HnDBankException(){

    }
    public String getMessage(){
        return this.mesg;
    }

}

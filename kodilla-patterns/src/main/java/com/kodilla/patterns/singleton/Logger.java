package com.kodilla.patterns.singleton;

public final class Logger {

    // pkt1 zadania 15.1
    private String theLastLog = "";

    public Logger(String theLastLog){
        this.theLastLog = theLastLog;
    }

    public void toLog(String theLog){
        lastLog = theLog;
        System.out.println("1. Log: [" + theLog + "]");
    }

    public String getTheLastLog(){
        return theLastLog;
    }

    //pkt 2-4 zadania 15.2
    private static Logger logger = null;
    private String lastLog = "";

    private Logger(){

    }

    public static Logger getInstance(){
        if(logger == null){
            synchronized (Logger.class){
                if (logger == null){
                    logger = new Logger();
                }
            }
        }
        return logger;
    }

    public void log(String log){
        lastLog = log;
        System.out.println("2. Log: [" + log + "]");
    }

    public String getLastLog(){
        return lastLog;
    }
}

package com.closa.global.throwables;

public enum MessageCode {
    APP0000("API returns OK", "00" ),
    APP0001("Item not found, where expected to exist", "02" ),
    APP0002("Item found, where not expected to exist", "03" ),
    APP0003("Invalid format of input", "01" ),
    APP0004("Invalid format of input Date(s)", "00" ),
    APP0005("Not authorized to API call", "04" ),
    APP0006("Result set is empty. Expected at least one item", "08" ),
    APP0007("Result set is not empty. Expected to be empty", "09" ),
    APP0008("Database related error. Check stack trace in logs", "98" ),
    APP0009("See below the result of your query", "00" ),

    APP0099("Generic technical error. Check the Stack on the logs", "99" )





    ;
    private final String mMsg;
    private final String rCode;
    private final String mCode;
    private final String altCode;

    MessageCode(String mMsg, String rCode) {
        this.mMsg = mMsg;
        this.rCode = rCode;
        this.mCode = this.name();
        this.altCode= "";
    }

    MessageCode(String mMsg, String rCode, String altCode) {
        this.mMsg = mMsg;
        this.rCode = rCode;
        this.mCode = this.name();
        this.altCode = altCode;
    }

    MessageCode(String mMsg, String rCode, String mCode, String altCode) {
        this.mMsg = mMsg;
        this.rCode = rCode;
        this.mCode = mCode;
        this.altCode = altCode;
    }

    public String getmMsg() {
        return mMsg;
    }

    public String getrCode() {
        return rCode;
    }

    public String getmCode() {
        return mCode;
    }

    public String getAltCode() {
        return altCode;
    }

    @Override
    public String toString() {
        return "MessageCode{" +
                "mMsg='" + mMsg + '\'' +
                ", rCode='" + rCode + '\'' +
                ", mCode='" + mCode + '\'' +
                ", altCode='" + altCode + '\'' +
                '}';
    }
}

package com.example.springcallprocedure.commons;

public enum ErrorMessage {
    //Common
    COMMON_EXISTED("%s '%s' is already exist!"),
    COMMON_NOT_FOUND("Can not found %s"),
    COMMON_ROLE_NAME_EXISTED("Role name is existed in system"),

    //Account
    ACC_001("Account is not having any package"),
    ACC_002("You are able to create %d users in this package, please update your account to create more user."),
    ACC_003("Account is already created!"),

    //Payment
    PM_001("Can not modify success status payment."),
    PM_002("Can not modify fail status payment."),
    PM_003("Package \"%s\" already have a pending payment."),

    PM_004("Already have a pending payment."),

    PM_005("Already have plan for next package."),

    PM_006("Already have successfull payment for next package."),
    //Package
    PACKAGE("Package number is greater than 3"),

    //Auth
    AUTH_001("Request is expired!");
    private final String value;
    ErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @SafeVarargs
    public final <T> String getMessage(T... arg) {
        String format = String.format(this.getValue(), (Object[]) arg);
        return format;
    }
}

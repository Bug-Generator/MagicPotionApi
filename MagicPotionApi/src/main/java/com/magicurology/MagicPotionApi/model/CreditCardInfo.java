package com.magicurology.MagicPotionApi.model;

public class CreditCardInfo {

    private String ccNum;
    private String exp;

    public String getCcNum() {
        return ccNum;
    }

    public CreditCardInfo setCcNum(String ccNum) {
        this.ccNum = ccNum;
        return this;
    }

    public String getExp() {
        return exp;
    }

    public CreditCardInfo setExp(String exp) {
        this.exp = exp;
        return this;
    }
}

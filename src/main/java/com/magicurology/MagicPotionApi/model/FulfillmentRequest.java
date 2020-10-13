package com.magicurology.MagicPotionApi.model;

public class FulfillmentRequest {
    private String uid;
    private boolean fulfilled;

    public String getUid() {
        return uid;
    }

    public FulfillmentRequest setUid(String uid) {
        this.uid = uid;
        return this;
    }

    public boolean isFulfilled() {
        return fulfilled;
    }

    public FulfillmentRequest setFulfilled(boolean fulfilled) {
        this.fulfilled = fulfilled;
        return this;
    }
}

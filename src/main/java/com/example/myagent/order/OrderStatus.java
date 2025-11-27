package com.example.myagent.order;

public enum OrderStatus {
    UNPAID(0),//未付款
    PAID(1),//已付款
    FINISHED(2),//已完成
    CANCELLED(3);//已取消

    private final int code;

    OrderStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}

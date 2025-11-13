package com.example.myagent.order;

public enum OrderStatus {
    UNPAID(1),//未付款
    PAID(2),//已付款
    FINISHED(3),//已完成
    CANCELED(4);//已取消

    private final int code;

    OrderStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}

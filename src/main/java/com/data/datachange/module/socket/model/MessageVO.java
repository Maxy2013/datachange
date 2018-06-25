package com.data.datachange.module.socket.model;

import lombok.Data;

@Data
public class MessageVO {

    /**
     * 用户数量
     */
    private Integer userNum;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 状态描述
     */
    private String statusDesc;
    /**
     * 消息
     */
    private String message;
}

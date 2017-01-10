package com.swpu.socket;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by BUG666 on 2017/1/4.
 */
@Getter
@Setter
public class MessageEntity {
    private int id;
    private String text;

    public MessageEntity() {
    }

    public MessageEntity(int id, String text) {
        this.id = id;
        this.text = text;
    }
}

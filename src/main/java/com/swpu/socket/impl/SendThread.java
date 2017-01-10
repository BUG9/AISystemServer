package com.swpu.socket.impl;



import com.swpu.socket.MessageEntity;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2016/7/9 12:23
 * Version: 1.0
 */
public class SendThread extends Thread {

    private BufferedWriter mWriter;

    private static Queue<MessageEntity> mMessageEntities = new ConcurrentLinkedDeque<>();

    public static void sendMessage(MessageEntity entity) {
//        mMessageEntities.add(entity);
        mMessageEntities.add(entity);
    }

    public SendThread(BufferedWriter writer) {
        mWriter = writer;
    }

    @Override
    public void run() {
        super.run();

        while (true) {
            try {
                // 写入消息
                if (!mMessageEntities.isEmpty()) {
                    MessageEntity messageEntity = mMessageEntities.poll();
                    if (0 == messageEntity.getId()) {
                        mWriter.write(messageEntity.getText());

                        mWriter.newLine();

                        mWriter.flush();
                    }
                }
            } catch (IOException e) {
                System.out.println("写向节点错误");
                break;
            }
        }

    }
}

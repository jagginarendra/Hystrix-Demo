package com.demo.hystrix.network;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.UnknownHostException;
import java.util.concurrent.CountDownLatch;

public class NetworkUtilTask implements Runnable {

    private final CountDownLatch countDownLatch;
    private static final Logger logger = LoggerFactory.getLogger(NetworkUtilTask.class);

    public NetworkUtilTask(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }


    @Override
    public void run() {

        try {
            String hostname = NetworkUtils.getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
    }
}

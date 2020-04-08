package com.demo.hystrix.network;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkUtils {


        private static final Logger logger = LoggerFactory.getLogger(NetworkUtils.class);
        private static String hostname;

        public static String getHostName() throws UnknownHostException {
            return InetAddress.getLocalHost().getHostName();
        }



        static {
            try {
                long startTime = System.currentTimeMillis();
                hostname = InetAddress.getLocalHost().getHostName();
                logger.error("hostname retrived in="+(System.currentTimeMillis()-startTime));
            } catch (UnknownHostException e) {
                logger.error("Exception while getting hostname. Setting as unknown", e);
                hostname = "unknown";
            }
        }

}

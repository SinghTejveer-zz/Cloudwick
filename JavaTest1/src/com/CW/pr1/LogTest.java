package com.CW.pr1;

/**
 * Created by Tejveer on 28/03/2015.
 */

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogTest {

    static Logger logger = Logger.getLogger(LogTest.class.getName());

    private String alpha;

    LogTest(String name) {
        alpha = name;
        String msg = String.format("This is value alpha %s", alpha);
    }

    public void run() {
        String msg = String.format("Fun %s", alpha);
    }

    public static void main(String[] arg) {

        PropertyConfigurator.configure("/Users/Sam/IdeaProjects/project 1/test/log4j.config");
        LogTest temp1 = new LogTest(" Pleasure");

        temp1.start();
        logger.info("Before run");

        logger.info("After run");
    }

    private void start() {

    }
}




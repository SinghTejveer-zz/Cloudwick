package com.CW.pr1;
import org.apache.log4j.*;
import org.junit.Test;

public class TestLog4J {

    static Logger logger = Logger.getLogger(TestLog4J.class.getName());

        @Test
        public void lotToConsoleTest()
        {
            // /Users/Sam/IdeaProjects/project 1/test/log4j.config
            PropertyConfigurator.configure("/Users/Sam/IdeaProjects/project 1/test/log4j.config");
            logger.trace("trace");
            logger.debug("debug");
            logger.info("info");
            logger.warn("warn");
            logger.error("err");
            logger.fatal("fatal");

        }
    }



package com.CW.pr1;

/**
 * Created by Tejveer on 28/03/2015.
 */

import org.apache.log4j.*;
import org.junit.Test;

public class Testlogging {


    

        static Logger logger = Logger.getLogger(Testlogging.class.getName());

        @Test
        public void lotToConsoleTest()
        {
            // /Users/Sam/IdeaProjects/project 1/test/log4j.config
            PropertyConfigurator.configure("C:\\Users\\Tejveer\\IdeaProjects\\JavaTest1\\log4j.config");

            logger.trace("trace");
            logger.debug("debug");
            logger.info("info");
            logger.warn("warn");
            logger.error("err");
            logger.fatal("fatal");

        }
    }


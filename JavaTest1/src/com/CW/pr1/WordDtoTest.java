package com.CW.pr1;

/**
 * Created by Tejveer on 05/04/2015.
 */
    import org.junit.Test;

    import java.util.Date;

    import static org.junit.Assert.assertEquals;


    public class WordDtoTest {

        @Test
        public void ctor_Test()
        {
            WordDto uut = new WordDto("pizza");
            assertEquals(uut.getWord(), "pizza");
        }

        @Test
        public void getCount_Test()
        {
            WordDto uut = new WordDto("pizza");
            Integer expected = 40;
            uut.setCount(expected);
            Integer actual = uut.getCount();
            assertEquals(expected, actual);
        }

        @Test
        public void getLength_Test()
        {
            WordDto uut = new WordDto("pizza123");
            Integer expected = 8;
            Integer actual = uut.getLength();
            assertEquals(expected, actual);
        }

        @Test
        public void getDate_Test() throws InterruptedException {
            WordDto uut = new WordDto("pizza123");
            Date expected = new Date();
            uut.setReadOn(expected);

            Thread.sleep(300);

            Date actual = uut.getReadOn();
            assertEquals(expected, actual);
        }

        @Test
        public void getSynonyms_Test()
        {
            WordDto uut = new WordDto("pizza123");
            Integer expected = 8;
            Integer actual = uut.getLength();
            assertEquals(expected, actual);
        }
    }








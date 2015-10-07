package com.CW.pr1;

import junit.framework.Assert;
import org.junit.Test;

import org.junit.Test;
//import sun.jvm.hotspot.utilities.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


/**
 * Created by Sam on 15/03/15.
 */
public class NumberLocatorTest {
    void AddSeqExcept_One_One_Zero() {

    }

    /*@Test

    public void AddSeqExcept_Ten_FiveSeven_ThirtyThree() {

        //  Arrange
        NumberLocator uut = new NumberLocator();
        int excepted = 33;
        List Except = new ArrayList<Integer>();
        Except.add(5);
        Except.add(7);

        // Act
        int act = uut.AddSeqExcept(10, Except);

        // Assert
        assertEquals(excepted, act);
    }

    /*@Test(expected = IllegalArgumentException.class)

    public void AddSeqExcept_LessThanZero() {


        //  Arrange
        NumberLocator uut = new NumberLocator();
        int excepted = 33;
        List except = new ArrayList<Integer>();


        except.add(5);
        except.add(7);

        // Act
        int act = uut.AddSeqExcept(-7, except);

        // Assert

        fail(" shail fail");
    }

*/
    @Test
    public void ReadFile_Six_words() {

        //  Arrange
        FileReadClass uut = new FileReadClass();
        int expected = 992;

        String path = "C:\\Users\\Tejveer\\Desktop\\text_file1.txt";
        // Act
        int actual = uut.ReadFile(path);

        // Assert

        assertEquals(expected, actual);
    }
}
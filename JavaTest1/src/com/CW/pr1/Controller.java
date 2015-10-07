package com.CW.pr1;


import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * Created by Tejveer on 05/04/2015.
 */
public class Controller {

    public static void main(String args[]) throws FileNotFoundException, ParserConfigurationException {
        Read_File ex = new Read_File();
        HashMap<String, WordDto> hm = ex.ReadFile("C:\\Users\\Tejveer\\Desktop\\text_file1.txt");
        SaveToXML obj = new SaveToXML();
        obj.WriteWithDOM(hm);
        ReadXML obj2 = new ReadXML();
        obj2.XMLReader();
    }


}

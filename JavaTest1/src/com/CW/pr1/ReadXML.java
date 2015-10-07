package com.CW.pr1;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
/**
 * Created by Tejveer on 11/04/2015.
 */


public class ReadXML{

        public void XMLReader() {

            try {

                File fXmlFile = new File("C:\\Users\\Tejveer\\Desktop\\xml_file1.xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(fXmlFile);

                //optional, but recommended
                //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
                doc.getDocumentElement().normalize();

                System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

                NodeList nList = doc.getElementsByTagName("word");

                System.out.println("*--------***--------*");

                for (int temp = 0; temp < nList.getLength(); temp++) {

                    Node nNode = nList.item(temp);

                    System.out.println("\nCurrent Element :" + nNode.getNodeName());

                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                        Element eElement = (Element) nNode;

                        System.out.println("Word id : " + eElement.getAttribute("id"));
                        System.out.println("Value : " + eElement.getElementsByTagName("value").item(0).getTextContent());
                        System.out.println("Count : " + eElement.getElementsByTagName("count").item(0).getTextContent());
                        System.out.println("Length : " + eElement.getElementsByTagName("length").item(0).getTextContent());
                        System.out.println("Time : " + eElement.getElementsByTagName("time").item(0).getTextContent());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

}


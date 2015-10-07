package com.CW.pr1;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Tejveer on 4/6/15.
 */
public class SaveToXML {

    public void WriteWithDOM(HashMap hm) {
        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Integer i = 0;
            //for (Object entry : hm1.entrySet()) {

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("words");
            doc.appendChild(rootElement);

            Iterator<Map.Entry<String, WordDto>> itr1 = hm.entrySet().iterator();
            while (itr1.hasNext()) {

                Map.Entry<String, WordDto> pairs = itr1.next();
                String newword = pairs.getKey().toString();
                String Count = pairs.getValue().getCount().toString();
                String len = pairs.getValue().getLength().toString();
                String syn = " "; //pairs.getValue().getSynonyms().toString();
                long time = pairs.getValue().getReadOn().getTime();
                String times = Long.toString(time);

                i++;

                // root elements


                // staff elements
                Element word_element = doc.createElement("word");
                rootElement.appendChild(word_element);

                // set attribute to staff element
                Attr attr = doc.createAttribute("id");
                word_element.setAttributeNode(attr);

                // shorten way
                word_element.setAttribute("id", i.toString());

                // firstname elements
                Element word = doc.createElement("value");
                word.appendChild(doc.createTextNode(newword));
                word_element.appendChild(word);

                // lastname elements
                Element count = doc.createElement("count");
                count.appendChild(doc.createTextNode(Count));
                word_element.appendChild(count);

                // nickname elements
                Element length = doc.createElement("length");
                length.appendChild(doc.createTextNode(len));
                word_element.appendChild(length);

                //Synonym elements
//                Element synonym = doc.createElement("synonym");
//                synonym.appendChild(doc.createTextNode(syn));
//                word_element.appendChild(synonym);

                //Synonym elements
                Element Time = doc.createElement("time");
                Time.appendChild(doc.createTextNode(times));
                word_element.appendChild(Time);


            }
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:\\Users\\Tejveer\\Desktop\\xml_file1.xml"));


            transformer.transform(source, result);


            System.out.println("XML File saved !");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}
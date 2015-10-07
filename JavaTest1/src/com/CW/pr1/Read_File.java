package com.CW.pr1;

import org.json.simple.JSONObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;

/**
 * Created by Tejveer on 05/04/2015.
 */
public class Read_File {


    public HashMap<String, WordDto> ReadFile(String path) throws FileNotFoundException{

        String ReadWord;
        String stopWord;
        int count = 0;
        int InitValue = 1;
        ArrayList<String> stopList = new ArrayList<String>();

        try {


            Scanner sci = new Scanner(new FileInputStream("C:\\Users\\Tejveer\\Desktop\\stop.txt"));

            //Adding the stop words to a list
            while (sci.hasNextLine()) {
                stopWord = sci.nextLine();
                stopList.add(stopWord);
            }
        } catch (Exception e) {
            System.out.println("Error while reading file line by line:" + e.getMessage());
        }

        //Hash map initialization
        HashMap<String, WordDto> hm = new HashMap<String, WordDto>();


        try {
            Scanner sc = new Scanner(new FileInputStream(path));

            while (sc.hasNext()) {

                ReadWord = sc.next();

                ReadWord = ReadWord.replaceAll(",", "");
                ReadWord = ReadWord.replaceAll("'", "");
                ReadWord = ReadWord.replace(".", "");
                ReadWord = ReadWord.toLowerCase();

                if (!stopList.contains(ReadWord)) {
                    count++;
                    if (hm.containsKey(ReadWord)) {
                        WordDto word1 = hm.get(ReadWord);
                        Integer currentValue = word1.getCount();
                        currentValue++;
                        word1.setCount(currentValue);
                        hm.replace(ReadWord, word1);

                    } else {
                        WordDto word2 = new WordDto(ReadWord);
                        word2.setCount(1);
                        hm.put(word2.getWord(), word2);

                    }

                }

            }

            for (Map.Entry<String, WordDto> entry : hm.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue().getCount() + "  " + entry.getValue().getLength();

                //System.out.println(key + "  >>  " + value);
            }


        } catch (Exception e) {
            System.out.println("Error while reading file line by line:" + e.getMessage());
        }

        System.out.print("Total Words found: " + count + "\n");

        return hm;
    }


    public static void main(String[] args) throws FileNotFoundException {

        Read_File file = new Read_File();
        file.ReadFile("C:\\Users\\Tejveer\\Desktop\\text_file1.txt");


    }



}


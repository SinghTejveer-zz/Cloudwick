package com.CW.pr1;

import org.json.simple.JSONObject;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.*;

/**
 * Created by Tejveer on 3/21/15.
 */
public class FileReadClass {


    public int ReadFile(String path) {
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
        HashMap<String, Integer> hm = new HashMap<String,Integer>();

        // HashMap hm = new HashMap<String, Tuple<Integer, Integer>>();
        // hm.put("key1", new Tuple<Integer, Integer>(12, 34));


        // key      value      value
        // key1     12         34

        //Tuple<Integer, Integer> val = (Tuple<Integer, Integer>)hm.get("key1");
        //(val.x) // ---->  12
        //(val.y) // val.y // ----> 34

        ValueComparator bvc = new ValueComparator(hm);
        TreeMap<String, Integer> sorted_map = new TreeMap<String, Integer>(bvc);


        try {
            Scanner sc = new Scanner(new FileInputStream(path));
            //Scanner sc1 = new Scanner(new FileInputStream("/Users/ahuja/Desktop/json.txt"));


            while (sc.hasNext()) {
                // Removing "," , "'" , "." and converting it to lowercase

                ReadWord = sc.next();
                // StringBuilder sb = new StringBuilder(ReadWord);
                // http://stackoverflow.com/questions/3472663/replace-all-occurences-of-a-string-using-stringbuilder

                ReadWord = ReadWord.replaceAll(",", "");
                ReadWord = ReadWord.replaceAll("'", "");
                ReadWord = ReadWord.replace(".", "");
                ReadWord = ReadWord.toLowerCase();

                if (!stopList.contains(ReadWord)) {
                    // If the word is not there in the stopList then we will add it into the hashmap
                    count++;

                    if (hm.containsKey(ReadWord)) {
                        InitValue = hm.get(ReadWord);
                        InitValue++;
                        hm.replace(ReadWord, InitValue);

                    } else hm.put(ReadWord, 1);
                }
            }
        } catch (Exception e) {
            System.out.println("Error while reading file line by line:" + e.getMessage());
        }

        System.out.print(count);
        // Putting the words in  Hashmap in treemap
        sorted_map.putAll(hm);

        System.out.print(System.lineSeparator());
        System.out.print(System.lineSeparator());

        int check = 0;
        JSONObject json = new JSONObject();
        try {
            FileWriter file = new FileWriter("C:\\Users\\Tejveer\\Desktop\\json.txt");

            for (Map.Entry<String, Integer> entry : sorted_map.entrySet()) {
                if (check > 9) break;
                check++;
                String key = entry.getKey();
                int value = entry.getValue();

                System.out.printf("%s : %s\n", key, value);
                json.put(key, value);


            }
            file.write(json.toJSONString());
            file.flush();
            file.close();

        } catch (Exception e) {
            System.out.println("Error while reading file line by line:" + e.getMessage());
        }


        return count;
    }


    public static void main(String[] args) {

        FileReadClass file = new FileReadClass();
        file.ReadFile("C:\\Users\\Tejveer\\Desktop\\text_file1.txt");
    }

}

class ValueComparator implements Comparator<String> {

    Map<String, Integer> base;

    public ValueComparator(Map<String, Integer> base) {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with equals.
    public int compare(String a, String b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }
}


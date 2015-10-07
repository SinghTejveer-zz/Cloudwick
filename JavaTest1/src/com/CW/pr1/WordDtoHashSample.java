package com.CW.pr1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tejveer on 05/04/2015.
 */
public class WordDtoHashSample {
    public void Demo() {
        HashMap<String, WordDto> hm = new HashMap<String, WordDto>();

        WordDto word1 = new WordDto("hello");
        WordDto word2 = new WordDto("world!!!");

        //loop here
        word1.setCount(1);
        word1.setCount(2);
        word1.setCount(3);
        word1.setCount(4);

        word2.setCount(10);

        hm.put(word1.getWord(), word1);
        hm.put(word2.getWord(), word2);

        for (Map.Entry<String, WordDto> entry : hm.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue().getCount() + "  " + entry.getValue().getLength();

            System.out.println(key + "  >>  " + value);
        }
    }

}

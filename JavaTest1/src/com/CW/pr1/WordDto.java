package com.CW.pr1;

import java.util.Date;

/**
 * Created by Tejveer on 05/04/2015.
 */
public class WordDto {

        private String word;
        private Integer count;
        private Integer length;
        private Date readOn;
        private String[] synonyms;


        public WordDto(String word) {
            this.word = word;
            this.length = word.length();
            this.readOn = new Date();
        }

        public String getWord() {
            return word;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public Integer getLength() {
            return word.length();
        }

        public Date getReadOn() {
            return readOn;
        }

        public void setReadOn(Date readOn) {
            this.readOn = readOn;
        }

        public String[] getSynonyms() {
            return synonyms;
        }

        public void setSynonyms(String[] synonyms) {
            this.synonyms = synonyms;
        }
    }



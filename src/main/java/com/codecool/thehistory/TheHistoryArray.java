package com.codecool.thehistory;

import java.util.Arrays;
import java.util.Objects;

public class TheHistoryArray implements TheHistory {

    /**
     * This implementation should use a String array so don't change that!
     */
    private String[] wordsArray = new String[0];

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        String[] newArray = text.split("\\s+");
        String[] tempArray = new String[this.wordsArray.length];
        System.arraycopy(this.wordsArray, 0, tempArray, 0, this.wordsArray.length);
        this.wordsArray = new String[newArray.length + this.wordsArray.length];
        System.arraycopy(tempArray, 0, this.wordsArray, 0, tempArray.length);
        System.arraycopy(newArray, 0, this.wordsArray, tempArray.length, newArray.length );
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
        int counter = 0;
        for (int i = 0; i < this.wordsArray.length; i++){
            if (Objects.equals(this.wordsArray[i], wordToBeRemoved)){
                counter++;
            }
        }
        String[] tempArray = new String[this.wordsArray.length - counter];
        counter = 0;
        for (int i = 0; i < this.wordsArray.length; i++){
            if (!Objects.equals(this.wordsArray[i], wordToBeRemoved)){
                tempArray[counter] = this.wordsArray[i];
                counter++;
            }
        }
        this.wordsArray = new String[tempArray.length];
        System.arraycopy(tempArray, 0, this.wordsArray, 0, tempArray.length);
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return this.wordsArray.length;
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        this.wordsArray = new String[0];
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        for (int i = 0; i < this.wordsArray.length; i++) {
            if (Objects.equals(this.wordsArray[i], from)) {
                this.wordsArray[i] = to;
            }
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
        if (fromWords.length == toWords.length) {
            for (int i = 0; i < this.wordsArray.length; i++) {
                if (fromWords[0].equals(this.wordsArray[i])) {
                    boolean check = true;
                    for (int j = 1; j < fromWords.length; j++) {
                        if (!fromWords[j].equals(this.wordsArray[i + j])) {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        for (int j = 0; j < toWords.length; j++) {
                            this.wordsArray[i + j] = toWords[j];
                        }
                        i += fromWords.length - 1;
                    }
                }
            }
        } else {
            int counter = 0;
            for (int i = 0; i < this.wordsArray.length; i++) {
                if (fromWords[0].equals(this.wordsArray[i])) {
                    boolean check = true;
                    for (int j = 1; j < fromWords.length; j++) {
                        if ((i + j) >= this.wordsArray.length || !fromWords[j].equals(this.wordsArray[i + j])) {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        counter++;
                        i += fromWords.length - 1;
                    }
                }
            }
            String[] temp = new String[this.wordsArray.length - (fromWords.length * counter) + (toWords.length * counter)];
            int tempIndex = 0;
            for (int i=0; i< this.wordsArray.length;i++){
                if(fromWords[0].equals(this.wordsArray[i])){
                    boolean check = true;
                    for (int j = 1; j < fromWords.length; j++){
                        if ((i+j) >= this.wordsArray.length || !fromWords[j].equals(this.wordsArray[i + j])){
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        for (int j = 0; j< toWords.length;j++){
                            temp[tempIndex] = toWords[j];
                            tempIndex++;
                        }
                        i += fromWords.length-1;
                    } else {
                        temp[tempIndex] = wordsArray[i];
                        tempIndex++;
                    }
                } else {
                    temp[tempIndex] = wordsArray[i];
                    tempIndex++;
                }
            }
            this.wordsArray= temp;

        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArray) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }
}

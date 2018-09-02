package com.codecool.thehistory;

import java.util.*;

public class TheHistoryArrayList implements TheHistory {
    /**
     * This implementation should use a String ArrayList so don't change that!
     */
    private List<String> wordsArrayList = new ArrayList<>();

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        String[] newArray = text.split("\\s+");
        this.wordsArrayList.addAll(Arrays.asList(newArray));
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
        ListIterator<String> listIterator = this.wordsArrayList.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next().equals(wordToBeRemoved))
                listIterator.remove();
        }
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return this.wordsArrayList.size();
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        this.wordsArrayList = new ArrayList<>();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        ListIterator<String> listIterator = this.wordsArrayList.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next().equals(from))
                listIterator.set(to);
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
        if (fromWords.length == toWords.length) {
            for (int i = 0; i < this.wordsArrayList.size(); i++) {
                if (fromWords[0].equals(this.wordsArrayList.get(i))) {
                    boolean check = true;
                    for (int j = 1; j < fromWords.length; j++) {
                        if ((j + i) >= this.wordsArrayList.size() || !fromWords[j].equals(this.wordsArrayList.get(i + j))) {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        for (int j = 0; j < fromWords.length; j++) {
                            this.wordsArrayList.set((i + j), toWords[j]);
                        }
                    }
                }
            }
        } else {
            for (int i = 0; i < this.wordsArrayList.size(); i++) {
                if (fromWords[0].equals(this.wordsArrayList.get(i))) {
                    boolean check = true;
                    for (int j = 1; j < fromWords.length; j++) {
                        if ((j + i) >= this.wordsArrayList.size() || !fromWords[j].equals(this.wordsArrayList.get(i + j))) {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        for (int j = 0; j < fromWords.length; j++) {
                            this.wordsArrayList.remove(i);
                        }
                        this.wordsArrayList.addAll(i, Arrays.asList(toWords));
                        i += toWords.length - 1;
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArrayList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}

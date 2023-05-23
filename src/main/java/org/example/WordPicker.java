package org.example;

import java.util.List;
import java.util.Random;

public class WordPicker {
    public WordPicker(){

    }

    public String pickAWordFromList(List<String> listOfWords){
        int len = listOfWords.size();
        Random random = new Random();
        int randomIndex = random.nextInt(len);
        return listOfWords.get(randomIndex);
    }
}

package org.example;

import java.util.ArrayList;
import java.util.List;

public class GameChecker {
    public GameChecker(){

    }

    public boolean isTheWordCorrect(String currentWord, String answer){
        if (currentWord.toLowerCase().equals(answer.toLowerCase())){
            return true;
        }
        else {
            return false;
        }
    }

    public String returnCurrentState(String wordToGuess, String answer, String wordToPrint) {
        int len = wordToGuess.length();
        String[] wordToGuessLetters = splitWordToLetters(wordToGuess);
        String[] answerLetters = splitWordToLetters(answer);
        for (int i = 0; i < len; i++) {
            String newL = answerLetters[i];
            char newLetter = newL.charAt(0);
            if (wordToGuessLetters[i].toLowerCase().equals(answerLetters[i].toLowerCase())) {
                newLetter = Character.toUpperCase(newLetter);
                wordToPrint = replace1LetterInWord(wordToPrint,newLetter,i);
            }
            else if (doWeHaveThisLetter(wordToGuess,newLetter)){
                newLetter = Character.toLowerCase(newLetter);
                wordToPrint = replace1LetterInWord(wordToPrint,newLetter,i);
            }
        }
        return wordToPrint;
    }


    public String[] splitWordToLetters (String Word){
        String [] letters = Word.split("");
        return letters;
    }

    public String getAWordFromLetters(String[] letters){
        int len = letters.length;
        String answer = "";
        for (int i = 0; i < len; i++){
            answer += letters[i];
        }
        return answer;
    }

    public String replace1LetterInWord(String word, char letter, int i){
        int len = word.length();
        String[] letters = splitWordToLetters(word);
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j< len; j++){
            if (j != i){
                String newLetter = letters[j];
                char newLetterToChar = newLetter.charAt(0);
                sb = sb.append(newLetterToChar);
            }
            else {
                sb = sb.append(letter);
            }
        }
        return sb.toString();
    }

    public boolean doWeHaveThisLetter(String word, char letter){
        String[] letters = splitWordToLetters(word);
        String letterToString = String.valueOf(letter);
        boolean result = false;
        int len = word.length();
        for (int i = 0; i< len ; i++ ){
            if (letters[i].toLowerCase().equals(letterToString.toLowerCase())){
                result = true;
            }
        }
        return result;
    }

}

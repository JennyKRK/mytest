package org.example;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    private String linkToFile;
    private SourceExtractor sourceExtractor;
    private WordPicker wordPicker;
    private GameChecker gameChecker;
    public MainApp(){
        this.sourceExtractor = new SourceExtractor();
        this.wordPicker = new WordPicker();
        this.gameChecker = new GameChecker();
    }

    public void setLinkToFile(String linkToFile) {
        this.linkToFile = linkToFile;
    }

    public void playTheGame() throws IOException {
        initiateAGame();
    }

    public void initiateAGame() throws IOException {
        List<String> currentWords = this.sourceExtractor.extractWordsFromSource(linkToFile);
        String currentWord = wordPicker.pickAWordFromList(currentWords);
        beginTheGame();
        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        boolean status = false;
        String wordToPrint = "#####";
        do {
            String answer = scanner.nextLine();
            status = gameChecker.isTheWordCorrect(currentWord,answer);
            wordToPrint = gameChecker.returnCurrentState(currentWord,answer,wordToPrint);
            System.out.println(wordToPrint);
            counter ++;
        }
        while (counter < 7 && status == false);
        if (status == true){
            System.out.println("you won!");
        }
        System.out.println("Correct: " + currentWord);
    }


    public void beginTheGame(){
        System.out.println("Hello! I want to play a game with you.");
        System.out.println("The rules are simple. Try to guess 5-letter-word (whole word). Uppercase letter - correct letter");
        System.out.println("If a letter is in lowercase - it's a correct letter, but the place is wrong");
        System.out.println("This is the current state: # # # # #");}

}

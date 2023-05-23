package org.example;

import java.io.IOException;

public class CodeRunner {
    public static void main(String[] args) throws IOException {
        MainApp mainApp = new MainApp();
        mainApp.setLinkToFile("src/main/files/words.txt");
        mainApp.playTheGame();


    }



}
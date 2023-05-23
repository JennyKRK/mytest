package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class SourceExtractor {
    private String fileName;

    public SourceExtractor(){
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<String> extractWordsFromSource(String fileName) throws IOException {
        File file = new File(fileName);
        BufferedReader bufferedReader = Files.newBufferedReader(file.toPath());
        List<String> listOfWords = new ArrayList<>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null){
            listOfWords.add(line);
        }
        return listOfWords;
    }


}

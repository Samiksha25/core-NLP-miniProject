package com.readText.nlp.mainApp;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Class to read text from file and then write the output in the output file.
 */
public class GetTextFromFile {
    private static final String FILE_PATH = "Input.txt";

    public static void main(String args[]) throws IOException {
        ProcessText processText=new ProcessText();
        Result result= new Result();
        ReadFromFile(FILE_PATH,result);
        processText.analyzeText(result);
        WriteResultInFile(result);
    }

    /**
     * Writes the result output to a text file
     * @param result the Result object
     */

    private static void WriteResultInFile(Result result) {
        try {
            FileWriter myWriter = new FileWriter("Output.txt");
            myWriter.write(" Text Analysis Report: \n \n" +
                            " Sentence Count: "+ result.getSentenceCount()+
                            "\n Word Count: "+ result.getWordCount()+
                            "\n Noun Count: "+ result.getNounCount()+
                            "\n Verb Count: "+ result.getVerbCount()+"\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Reads the text from a file and puts the value in the result.text filed.
     * @param filePath the path of the input file
     * @param result the Result object
     * @throws FileNotFoundException Exception thrown when file is not available
     */

    public static void ReadFromFile(String filePath, Result result) throws FileNotFoundException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        result.setText(contentBuilder.toString());

    }
}



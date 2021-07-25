package com.readText.nlp.mainApp;

public class Result {
    private static int wordCount=0;
    private static int sentenceCount=0;
    private static int nounCount=0;
    private static int verbCount=0;
    private static String text;
    private static int id = 0;

    public static int getWordCount() {
        return wordCount;
    }

    public static void setWordCount(int wordCount) {
        Result.wordCount = wordCount;
    }

    public static int getSentenceCount() {
        return sentenceCount;
    }

    public static void setSentenceCount(int sentenceCount) {
        Result.sentenceCount = sentenceCount;
    }

    public static int getNounCount() {
        return nounCount;
    }

    public static void setNounCount(int nounCount) {
        Result.nounCount = nounCount;
    }

    public static int getVerbCount() {
        return verbCount;
    }

    public static void setVerbCount(int verbCount) {
        Result.verbCount = verbCount;
    }

    public static String getText() {
        return text;
    }

    public static void setText(String text) {
        Result.text = text;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Result.id = id;
    }


}

package com.readText.nlp.mainApp;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

import java.util.List;
import java.util.Properties;

public class ProcessText {
    private static int wordCount=0;
    private static int sentenceCount=0;
    private static int nounCount=0;
    private static int verbCount=0;
    private static String text;

    public static void main(String[] args){
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos, parse");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        // create an empty Annotation just with the given text
        Annotation document = new Annotation(text);

        // run all Annotators on this text
        pipeline.annotate(document);

        // these are all the sentences in this document
        // a CoreMap is essentially a Map that uses class objects as keys and has values with custom types
        List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);

        for (CoreMap sentence : sentences) {
            // traversing the words in the current sentence
            // a CoreLabel is a CoreMap with additional token-specific methods
            sentenceCount= sentences.size();
            for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {
                // this is the text of the token
                String word = token.get(CoreAnnotations.TextAnnotation.class);
                wordCount++;
                // this is the POS tag of the token
                String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                // this is the NER label of the token
                if(pos.contains("NN")){
                    nounCount++;
                }
                if(pos.contains("VB")){
                    verbCount++;
                }
                System.out.println(String.format("Print word : [%s] pos : [%s]",word,pos));
            }


        }
        System.out.println(String.format("Number of sentences : "+sentenceCount));
        System.out.println(String.format("Number of words : "+wordCount));
        System.out.println(String.format("Number of nouns : "+nounCount));
        System.out.println(String.format("Number of verbs : "+verbCount));
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static int getWordCount() {
        return wordCount;
    }

    public static void setWordCount(int wordCount) {
        ProcessText.wordCount = wordCount;
    }

    public static int getSentenceCount() {
        return sentenceCount;
    }

    public static void setSentenceCount(int sentenceCount) {
        ProcessText.sentenceCount = sentenceCount;
    }

    public static int getNounCount() {
        return nounCount;
    }

    public static void setNounCount(int nounCount) {
        ProcessText.nounCount = nounCount;
    }

    public static int getVerbCount() {
        return verbCount;
    }

    public static void setVerbCount(int verbCount) {
        ProcessText.verbCount = verbCount;
    }
}

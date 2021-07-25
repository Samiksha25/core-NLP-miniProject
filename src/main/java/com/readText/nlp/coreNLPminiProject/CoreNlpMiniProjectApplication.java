package com.readText.nlp.coreNLPminiProject;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.util.CoreMap;

import java.util.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Properties;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
public class CoreNlpMiniProjectApplication {
	private static final String FILE_PATH = "data.txt";
	private static int wordCount=0;
	private static int sentenceCount=0;
	private static int nounCount=0;
	private static int verbCount=0;
	public static void main(String[] args) {
		SpringApplication.run(CoreNlpMiniProjectApplication.class,args);

		// creates a StanfordCoreNLP object, with POS tagging, lemmatization, NER, parsing, and coreference resolution
		Properties props = new Properties();
		props.setProperty("annotators", "tokenize, ssplit, pos, parse");
		StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

		// read some text in the text variable
		String text = "My name is Samiksha and I stay in Mumbai." +
				" My school name is Kendriya Vidyalaya.";

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
}

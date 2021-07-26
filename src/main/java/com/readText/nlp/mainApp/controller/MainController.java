package com.readText.nlp.mainApp.controller;

import com.readText.nlp.mainApp.ProcessText;
import com.readText.nlp.mainApp.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Samiksha Deshmukh
 */
@Controller
public class MainController {

    @GetMapping("/")
    public String home() {
        return "Welcome.html";
    }

    /**
     * Takes input from user in text form and submits calls /getOutput
     * @param result Object of result class
     * @return returns the html page
     */
    @GetMapping("/getInput")
    public String getInput(Result result) {
        return "inputForm.html";
    }

    /**
     * Takes the text and processes it using the ProcessText class function
     * and displays the output on web.
     * @param result Object of result class
     * @return returns the html page
     */
    @PostMapping("/getOutput")
    public String getOutput(Result result) {
        ProcessText processText=new ProcessText();
        processText.analyzeText(result);
        return "outputForm.html";
    }

}

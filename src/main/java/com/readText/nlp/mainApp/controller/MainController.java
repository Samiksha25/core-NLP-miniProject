package com.readText.nlp.mainApp.controller;

import com.readText.nlp.mainApp.ProcessText;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @PostMapping(path="/getInput")
    public @ResponseBody ProcessText getInput(@RequestParam String text) {
        ProcessText processText = new ProcessText();
        processText.setText(text);
        processText.analyzeText();
        return processText;
    }


}

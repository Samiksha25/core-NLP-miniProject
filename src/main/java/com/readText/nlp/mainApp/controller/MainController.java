package com.readText.nlp.mainApp.controller;

import com.readText.nlp.mainApp.ProcessText;
import com.readText.nlp.mainApp.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

   /* @PostMapping(path="/getInput")
    public @ResponseBody
    ResponseEntity<ProcessText> getInput(@RequestParam String text) {
        ProcessText processText = new ProcessText();
        Result result=new Result();
        processText.analyzeText(result);
        return new ResponseEntity<ProcessText>(processText, HttpStatus.OK);
    }*/

    @GetMapping("/getInput")
    public String getInput(Result result) {
        return "inputForm.html";
    }

    @PostMapping("/getOutput")
    public String getOutput(Result result) {
        ProcessText processText=new ProcessText();
        processText.analyzeText(result);
        return "outputForm.html";
    }

}

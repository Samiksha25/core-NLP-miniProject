package com.readText.nlp.mainApp.controller;

import com.readText.nlp.mainApp.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
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
    public ModelAndView getInput(Result result) {
        return new ModelAndView("inputForm.html");
    }

}

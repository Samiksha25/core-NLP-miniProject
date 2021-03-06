## core-NLP-miniProject

### Project objective
To read a text input from various sources, process the text using Standford Core NLP and output the analysed results. 
The output file contains the sentence count, word count, noun count and the verb count.

`ProcessText.java`: Uses the Standford Core NLP funtions to analyse the text and populate the Result.<br>
`GetTextFromFile.java`: Takes text input from a file calles "Input" and class the ProcessText.java to analyse the text and writes the output in "Output" text file.<br>
`MainController.java`: Takes text input from the simple front-end, calls the ProcessText.java to analyse the text and publishes the output on front-end.

To read a file from location and write output ina text file:
(currently set at the project directory ...\core-NLP-miniProject\Input)
Step 1: Append the ...\core-NLP-miniProject\Input file with your contents.
Step 2: Run the SpringBoot application in the IDE and the output file will have the analysis results at ..\core-NLP-miniProject\Output.

To take input from front-end :
Step 1: Run the SpringBoot application.
Step 2: On your browser type "http://localhost:9090/getInput".
Step 3: Input your text to analyse and click "Submit".
STep 4: Output is displayed on the browser.

### Output Evidence:
Front-end Input Form:
![alt text](https://github.com/Samiksha25/core-NLP-miniProject/blob/master/Images/Front-end%20Input.PNG)

Front-end Output Form: 
![alt text](https://github.com/Samiksha25/core-NLP-miniProject/blob/master/Images/Front-end%20Output.PNG)

Front-end Empty TextArea Validation Form: 
![alt text](https://github.com/Samiksha25/core-NLP-miniProject/blob/master/Images/Front-end%20Validation.PNG)

Text File Output: 
![alt text](https://github.com/Samiksha25/core-NLP-miniProject/blob/master/Images/Text%20file%20Output.PNG)

### Console Output:
![alt text](https://github.com/Samiksha25/core-NLP-miniProject/blob/master/Images/Console%20Output.PNG)

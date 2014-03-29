package edu.cmu.deiis.annotators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;

import edu.cmu.deiis.Tools.Tool;
import edu.cmu.deiis.types.*;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;

public class InputAnnotator extends JCasAnnotator_ImplBase {
	private Pattern mQuestionPattern = Pattern.compile("\\bQ\\s([\\w-\\s]*)");
	private Pattern mAnswerPattern = Pattern.compile("(\\bA\\s(0|1)\\s)([\\w-\\s]*)");
	
	public InputAnnotator() {
		
	}
	/**
   * @see JCasAnnotator_ImplBase#process(JCas)
   */
	@Override
    public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // Get input document text string
    String docText = aJCas.getDocumentText();    
    
    // search for Questions
    Matcher matcher = mQuestionPattern.matcher(docText);
    while (matcher.find()) {
    	
      // found question - create annotation
      Question annotation = new Question(aJCas);
      annotation.setBegin(matcher.start(1));
      annotation.setEnd(matcher.end(1));
      annotation.addToIndexes();
      
      System.out.printf("InputAnnotator> Q: %s\n", Tool.getAnnoStr(docText, annotation));
    }
    
    // search for Answers
    matcher = mAnswerPattern.matcher(docText);
    while (matcher.find()) {
      
      // found answer - create annotation
      Answer annotation = new Answer(aJCas);
      annotation.setBegin(matcher.start(3));
      annotation.setEnd(matcher.end(3));
      //Set value to correct
      String isCorrectStr = docText.substring(matcher.start(2), matcher.end(2));
      System.out.printf("InputAnnotator> A: %s - %s\n", Tool.getAnnoStr(docText, annotation), isCorrectStr);
      annotation.setIsCorrect(Integer.parseInt(isCorrectStr)==1);
      annotation.addToIndexes();
    }
  }
}


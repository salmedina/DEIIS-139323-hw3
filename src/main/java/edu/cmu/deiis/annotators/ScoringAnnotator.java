package edu.cmu.deiis.annotators;

import java.util.*;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;

import edu.cmu.deiis.types.*;
import edu.cmu.deiis.tools.Tool;

public class ScoringAnnotator extends JCasAnnotator_ImplBase {
	
	public ScoringAnnotator() {
		
	}
	
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		//Get the input document
		String docText = aJCas.getDocumentText();
		
		//Get the input questions
		FSIndex qIndex = aJCas.getAnnotationIndex(QuestionNGram.type);
		Iterator qIter = qIndex.iterator();
		if(!qIter.hasNext())	return;	//if no question found abort
		//...and just keep the first one
		QuestionNGram	qNGram = (QuestionNGram)qIter.next();
		String[] questionNGrams = getStrArr(docText, qNGram.getUnigram().getElements());
		//Save question for output
		qNGram.getQuestion().addToIndexes();	// OUT
		
		//Get the input answers
		FSIndex		aIndex = aJCas.getAnnotationIndex(AnswerNGram.type);
		Iterator	aIter = aIndex.iterator();
		
		while(aIter.hasNext()) {
			//Build new AnswerScore annotation from the n-grams
			AnswerScore		answerScore = new AnswerScore(aJCas);
			AnswerNGram		aNGram = (AnswerNGram)aIter.next();
			//Transform from n-gram annotation to string array
			String[]		answerNGrams = getStrArr(docText, aNGram.getUnigram().getElements());
			//UNION calc
			String[]		totalNGrams = concat(questionNGrams, answerNGrams);	
			HashSet 		totalSet = new HashSet(Arrays.asList(totalNGrams));	
			//INTERSECTION
			Set<String> intersection = new HashSet<String>(Arrays.asList(questionNGrams)); // use the copy constructor
			Set<String> questionSet = new HashSet<String>(Arrays.asList(answerNGrams)); // use the copy constructor
			intersection.retainAll(questionSet);
			
			//Jaccard similarity
			double score = intersection.size() / totalSet.size();
			//Build annotation and save to index
			answerScore.setScore(score);
			answerScore.setAnswer(aNGram.getAnswer());
			answerScore.addToIndexes();	// OUT
		}
	}

	/*
	 * Concatenates two string arrays
	 */
	public static String[] concat(String[] a, String[] b){
        int length = a.length + b.length;
        String[] result = new String[length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }
	
	/*
	 * Obtains the string array from an 
	 * annotation array given an input string
	 */
	public String[] getStrArr(String inStr, FSArray inArr) {
		if( inArr.size() < 1 )	return null;
		
		String[] outArr = new String[inArr.size()];
		for(int copyIdx = 0; copyIdx<inArr.size(); ++copyIdx) {
			outArr[copyIdx] = Tool.getAnnoStr(inStr, (Annotation)inArr.get(copyIdx));
		}
		return outArr;
	}
}

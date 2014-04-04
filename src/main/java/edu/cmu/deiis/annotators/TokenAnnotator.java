package edu.cmu.deiis.annotators;

import java.util.Iterator;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.cas.FSArray;

import edu.cmu.deiis.types.*;

public class TokenAnnotator extends JCasAnnotator_ImplBase {
	public TokenAnnotator() {
		
	}
	
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		//Get the input document
		String docText = aJCas.getDocumentText();
		
		//Get the input questions
		FSIndex qIndex = aJCas.getAnnotationIndex(Question.type);
		Iterator qIter = qIndex.iterator();
		
		//Cycle through all the questions
		String tmpStr = "";
		Question question = null;
		while (qIter.hasNext()) {
			//Get the question
			question = (Question)qIter.next();
			
			//Get question string
			tmpStr = question.getCoveredText();
			//System.out.println("TokenAnnotator> Question: "+ tmpStr);
			
			//Tokenize
			FSArray	tokensArr = buildTokensArr(aJCas, question, tmpStr);
			//System.out.println("TokenAnnotator> #tokens="+tokensArr.size());
			//Add to the index
			QuestionTokens	qTokensAnno = new QuestionTokens(aJCas);
			qTokensAnno.setQuestion(question);
			qTokensAnno.setTokens(tokensArr);
			qTokensAnno.addToIndexes();
		}
		
		//Cycle through all the answers
		FSIndex aIndex = aJCas.getAnnotationIndex(Answer.type);
		Iterator aIter = aIndex.iterator();
		Answer answer = null;
		while (aIter.hasNext()) {
			//Get the answer
			answer = (Answer)aIter.next();
			
			//Get question string
			tmpStr = answer.getCoveredText();
			//System.out.println("TokenAnnotator> Answer: "+ tmpStr);
			
			//Tokenize
			FSArray	tokensArr = buildTokensArr(aJCas, answer, tmpStr);
			//System.out.println("TokenAnnotator> #tokens="+tokensArr.size());
			//Add to the index
			AnswerTokens	qTokensAnno = new AnswerTokens(aJCas);
			qTokensAnno.setAnswer(answer);
			qTokensAnno.setTokens(tokensArr);
			qTokensAnno.addToIndexes();
		}
	}
	
	/*
	 * Obtains the Token annotation array from a 
	 * given annotation and input string
	 */
	public FSArray buildTokensArr(JCas aJCas, Annotation inAnno, String inStr) {
		if(inStr.isEmpty())	return null;
		
		//Tokenize the input string without blankspaces nor punctuation
		String[]	strTokens = cleanStrArr(inStr.split("[ .,;]+")) ;
		int			lastPos = 0;
		int			offset = inAnno.getBegin();
		
		//Create new array
		FSArray tokensArr = new FSArray(aJCas, strTokens.length);		
		//Create an annotation for each token
		for(int tokenIdx=0; tokenIdx<strTokens.length; ++tokenIdx){
			Token annotation = new Token(aJCas);
			//Search from last pos for next token
			int startPos = inStr.indexOf(strTokens[tokenIdx], lastPos);
			//Update last ps
			lastPos = startPos+strTokens[tokenIdx].length();
			//build up annotation, considering offset
			annotation.setBegin(startPos+offset);
			annotation.setEnd(startPos+strTokens[tokenIdx].length()+offset);
			annotation.addToIndexes();
			tokensArr.set(tokenIdx, annotation);
		}
		
		return tokensArr;
	}
	
	/*
	 * Removes the empty string elements from a string array
	 */
	public String[] cleanStrArr(String[] inStrArr) {
		if(inStrArr == null)	return null;
		
		int emptyCount = 0;
		for(int checkIdx=0; checkIdx<inStrArr.length; ++checkIdx) {
			if(inStrArr[checkIdx].isEmpty()){
				emptyCount++;
			}
		}
		
		if(emptyCount==0)		return inStrArr;
		
		int copyIdx = 0;
		String[] outStrArr = new String[inStrArr.length-emptyCount];
		if(outStrArr.length==0)	return outStrArr;
		for(int scanIdx=0; scanIdx<inStrArr.length; ++scanIdx) {
			if(!inStrArr[scanIdx].isEmpty()){
				outStrArr[copyIdx++]=inStrArr[scanIdx];
			}
		}
		
		return outStrArr;
	}
}
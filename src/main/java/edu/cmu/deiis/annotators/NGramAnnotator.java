package edu.cmu.deiis.annotators;

import java.util.Iterator;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;

import edu.cmu.deiis.types.*;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.cas.FSArray;

public class NGramAnnotator extends JCasAnnotator_ImplBase {

	public NGramAnnotator() {
		
	}
	
	/**
	  * @see JCasAnnotator_ImplBase#process(JCas)
	  */
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		// Get input document text string
	    String docText = aJCas.getDocumentText();
	    
		//Get the input questions
		FSIndex		qIndex = aJCas.getAnnotationIndex(QuestionTokens.type);
		Iterator	qIter = qIndex.iterator();
		//System.out.println("NGramAnnotator> Question indexes obtained");
		while(qIter.hasNext()) {
			QuestionNGram	qNGram = new QuestionNGram(aJCas);
			QuestionTokens	qTokens = (QuestionTokens)qIter.next();
			FSArray 		tokenArr = qTokens.getTokens();
			
			//Build unigrams
			NGram unigram = new NGram(aJCas);
			nGramBuilder(aJCas, 1, unigram, tokenArr);
			
			//Build bigrams
			NGram bigram = new NGram(aJCas);
			nGramBuilder(aJCas, 2, bigram, tokenArr);
			
			//Build trigrams
			NGram trigram = new NGram(aJCas);
			nGramBuilder(aJCas, 3, trigram, tokenArr);
			
			qNGram.setQuestion(qTokens.getQuestion());
			qNGram.setUnigram(unigram);
			qNGram.setBigram(bigram);
			qNGram.setTrigram(trigram);
			qNGram.addToIndexes();
			
			
			//System.out.println("NGramAnnotator> "+ qNGram.getQuestion().getCoveredText());
			//System.out.println("NGramAnnotator> unigram.size = "+ unigram.getElements().size());
			//System.out.println("NGramAnnotator> bigram.size = "+ bigram.getElements().size());
			//System.out.println("NGramAnnotator> trigram.size = "+ trigram.getElements().size());
			
		}
		
		//Get the input answers
		FSIndex		aIndex = aJCas.getAnnotationIndex(AnswerTokens.type);
		Iterator	aIter = aIndex.iterator();
		//System.out.println("NGramAnnotator> Answer indexes obtained");
		while(aIter.hasNext()) {
			AnswerNGram		aNGram = new AnswerNGram(aJCas);
			AnswerTokens	aTokens = (AnswerTokens)aIter.next();
			FSArray 		tokenArr = aTokens.getTokens();
			
			//Build unigrams
			NGram unigram = new NGram(aJCas);
			nGramBuilder(aJCas, 1, unigram, tokenArr);
			
			//Build bigrams
			NGram bigram = new NGram(aJCas);
			nGramBuilder(aJCas, 2, bigram, tokenArr);
			
			//Build trigrams
			NGram trigram = new NGram(aJCas);
			nGramBuilder(aJCas, 3, trigram, tokenArr);
			
			aNGram.setAnswer(aTokens.getAnswer());
			aNGram.setUnigram(unigram);
			aNGram.setBigram(bigram);
			aNGram.setTrigram(trigram);
			aNGram.addToIndexes();
			
			//System.out.println("NGramAnnotator> "+ docText.substring(aNGram.getAnswer().getBegin(), aNGram.getAnswer().getEnd()));
			//System.out.println("NGramAnnotator> unigram.size = "+ unigram.getElements().size());
			//System.out.println("NGramAnnotator> bigram.size = "+ bigram.getElements().size());
			//System.out.println("NGramAnnotator> trigram.size = "+ trigram.getElements().size());
		}
	}
	
	/*
	 * Builds an NGram annotation given an n window size 
	 * and a Token annotation array
	 */
	public void nGramBuilder(JCas aJCas, int n, NGram nGram, FSArray tokenArr) {
		if(nGram == null)	return;
		
		int window = n-1;
		nGram.setN(n);
		FSArray nGramArr = new FSArray(aJCas,tokenArr.size()-window);
		
		for(int tokIdx = window; tokIdx<tokenArr.size(); ++tokIdx) {
			Annotation newElem = new Annotation(aJCas);
			newElem.setBegin( ((Token)tokenArr.get(tokIdx-window)).getBegin());
			newElem.setEnd( ((Token)tokenArr.get(tokIdx)).getEnd());
			nGramArr.set(tokIdx-window, newElem);
		}
		nGram.setElements(nGramArr);
	}
}

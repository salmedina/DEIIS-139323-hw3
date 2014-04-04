package edu.cmu.deiis.tools;

import java.util.Properties;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import edu.stanford.nlp.ling.CoreAnnotations.CharacterOffsetBeginAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.CharacterOffsetEndAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

import edu.cmu.deiis.types.EntityMention;
import edu.cmu.deiis.types.Sentence;
import edu.cmu.deiis.types.Token;

/**
 *	This annotator retrieves sentences, named entities and tokens.
 */
public class StanfordCoreNlpAnnotator extends JCasAnnotator_ImplBase {

	private StanfordCoreNLP stfdCore;

	public void initialize(UimaContext aContext)
			throws ResourceInitializationException {
		
		//Initialize the core with our options
		super.initialize(aContext);
		Properties props = new Properties();
		props.put("annotators", "tokenize, ssplit, pos, lemma,ner");

		stfdCore = new StanfordCoreNLP(props);
	}

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		String documentText = aJCas.getDocumentText();		// get the doc String
		Annotation document = new Annotation(documentText);	// set the String into an annotator to feed CoreNLP
		stfdCore.annotate(document);						// make it work

		//Named entity aux vars
		String preNe = "";
		int neBegin = 0;
		int neEnd = 0;

		// Iterate sentences annotated by Core NLP
		for (CoreMap tmpSentence : document.get(SentencesAnnotation.class)) {
			int sentStart = tmpSentence.get(CharacterOffsetBeginAnnotation.class);
			int sentEnd = tmpSentence.get(CharacterOffsetEndAnnotation.class);

			//Import into our type system
			Sentence sSent = new Sentence(aJCas, sentStart, sentEnd);
			sSent.addToIndexes();

			// Iterate sentence's tokens
			for (CoreLabel token : tmpSentence.get(TokensAnnotation.class)) {
				int startIndex = token.get(CharacterOffsetBeginAnnotation.class);
				int endIndex = token.get(CharacterOffsetEndAnnotation.class);

				//Import token into our type system
				Token sToken = new Token(aJCas, startIndex, endIndex);
				sToken.setLemma(token.get(LemmaAnnotation.class));
				sToken.setPOS(token.get(PartOfSpeechAnnotation.class));
				sToken.addToIndexes(aJCas);

				// Add NER annotation
				String namedEnt = token.get(NamedEntityTagAnnotation.class);
				if (namedEnt != null) {
					if (namedEnt.equals(preNe) && !preNe.equals("")) {
						//If already added and not empty: DO_NOTHING
					} else if (preNe.equals("")) {
						// if the previous is start of sentence(no label).
						neBegin = startIndex;
						preNe = namedEnt;
					} else {
						//If it has a label
						if (!preNe.equals("O")) {// "O": no label
							//Import Named Entity into our index
							EntityMention sne = new EntityMention(aJCas);
							sne.setBegin(neBegin);
							sne.setEnd(neEnd);
							sne.setEntityType(preNe);
							sne.addToIndexes(aJCas);
						}
						// set the next span of NE
						neBegin = startIndex;
						preNe = namedEnt;
					}
					neEnd = endIndex;
				}
			}
		}
	}
}
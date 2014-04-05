
/* First created by JCasGen Thu Mar 06 01:23:46 CST 2014 */
package edu.cmu.deiis.types;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;

/** 
 * Updated by JCasGen Fri Apr 04 19:11:37 CST 2014
 * @generated */
public class QuestionNGram_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (QuestionNGram_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = QuestionNGram_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new QuestionNGram(addr, QuestionNGram_Type.this);
  			   QuestionNGram_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new QuestionNGram(addr, QuestionNGram_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = QuestionNGram.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.deiis.types.QuestionNGram");
 
  /** @generated */
  final Feature casFeat_unigram;
  /** @generated */
  final int     casFeatCode_unigram;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getUnigram(int addr) {
        if (featOkTst && casFeat_unigram == null)
      jcas.throwFeatMissing("unigram", "edu.cmu.deiis.types.QuestionNGram");
    return ll_cas.ll_getRefValue(addr, casFeatCode_unigram);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setUnigram(int addr, int v) {
        if (featOkTst && casFeat_unigram == null)
      jcas.throwFeatMissing("unigram", "edu.cmu.deiis.types.QuestionNGram");
    ll_cas.ll_setRefValue(addr, casFeatCode_unigram, v);}
    
  
 
  /** @generated */
  final Feature casFeat_bigram;
  /** @generated */
  final int     casFeatCode_bigram;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getBigram(int addr) {
        if (featOkTst && casFeat_bigram == null)
      jcas.throwFeatMissing("bigram", "edu.cmu.deiis.types.QuestionNGram");
    return ll_cas.ll_getRefValue(addr, casFeatCode_bigram);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setBigram(int addr, int v) {
        if (featOkTst && casFeat_bigram == null)
      jcas.throwFeatMissing("bigram", "edu.cmu.deiis.types.QuestionNGram");
    ll_cas.ll_setRefValue(addr, casFeatCode_bigram, v);}
    
  
 
  /** @generated */
  final Feature casFeat_trigram;
  /** @generated */
  final int     casFeatCode_trigram;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getTrigram(int addr) {
        if (featOkTst && casFeat_trigram == null)
      jcas.throwFeatMissing("trigram", "edu.cmu.deiis.types.QuestionNGram");
    return ll_cas.ll_getRefValue(addr, casFeatCode_trigram);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setTrigram(int addr, int v) {
        if (featOkTst && casFeat_trigram == null)
      jcas.throwFeatMissing("trigram", "edu.cmu.deiis.types.QuestionNGram");
    ll_cas.ll_setRefValue(addr, casFeatCode_trigram, v);}
    
  
 
  /** @generated */
  final Feature casFeat_question;
  /** @generated */
  final int     casFeatCode_question;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getQuestion(int addr) {
        if (featOkTst && casFeat_question == null)
      jcas.throwFeatMissing("question", "edu.cmu.deiis.types.QuestionNGram");
    return ll_cas.ll_getRefValue(addr, casFeatCode_question);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setQuestion(int addr, int v) {
        if (featOkTst && casFeat_question == null)
      jcas.throwFeatMissing("question", "edu.cmu.deiis.types.QuestionNGram");
    ll_cas.ll_setRefValue(addr, casFeatCode_question, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public QuestionNGram_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_unigram = jcas.getRequiredFeatureDE(casType, "unigram", "edu.cmu.deiis.types.NGram", featOkTst);
    casFeatCode_unigram  = (null == casFeat_unigram) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_unigram).getCode();

 
    casFeat_bigram = jcas.getRequiredFeatureDE(casType, "bigram", "edu.cmu.deiis.types.NGram", featOkTst);
    casFeatCode_bigram  = (null == casFeat_bigram) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_bigram).getCode();

 
    casFeat_trigram = jcas.getRequiredFeatureDE(casType, "trigram", "edu.cmu.deiis.types.NGram", featOkTst);
    casFeatCode_trigram  = (null == casFeat_trigram) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_trigram).getCode();

 
    casFeat_question = jcas.getRequiredFeatureDE(casType, "question", "edu.cmu.deiis.types.Question", featOkTst);
    casFeatCode_question  = (null == casFeat_question) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_question).getCode();

  }
}



    
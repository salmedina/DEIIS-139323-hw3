
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
 * Updated by JCasGen Thu Apr 03 01:46:42 CST 2014
 * @generated */
public class AnswerNGram_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (AnswerNGram_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = AnswerNGram_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new AnswerNGram(addr, AnswerNGram_Type.this);
  			   AnswerNGram_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new AnswerNGram(addr, AnswerNGram_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = AnswerNGram.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.deiis.types.AnswerNGram");
 
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
      jcas.throwFeatMissing("unigram", "edu.cmu.deiis.types.AnswerNGram");
    return ll_cas.ll_getRefValue(addr, casFeatCode_unigram);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setUnigram(int addr, int v) {
        if (featOkTst && casFeat_unigram == null)
      jcas.throwFeatMissing("unigram", "edu.cmu.deiis.types.AnswerNGram");
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
      jcas.throwFeatMissing("bigram", "edu.cmu.deiis.types.AnswerNGram");
    return ll_cas.ll_getRefValue(addr, casFeatCode_bigram);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setBigram(int addr, int v) {
        if (featOkTst && casFeat_bigram == null)
      jcas.throwFeatMissing("bigram", "edu.cmu.deiis.types.AnswerNGram");
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
      jcas.throwFeatMissing("trigram", "edu.cmu.deiis.types.AnswerNGram");
    return ll_cas.ll_getRefValue(addr, casFeatCode_trigram);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setTrigram(int addr, int v) {
        if (featOkTst && casFeat_trigram == null)
      jcas.throwFeatMissing("trigram", "edu.cmu.deiis.types.AnswerNGram");
    ll_cas.ll_setRefValue(addr, casFeatCode_trigram, v);}
    
  
 
  /** @generated */
  final Feature casFeat_answer;
  /** @generated */
  final int     casFeatCode_answer;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getAnswer(int addr) {
        if (featOkTst && casFeat_answer == null)
      jcas.throwFeatMissing("answer", "edu.cmu.deiis.types.AnswerNGram");
    return ll_cas.ll_getRefValue(addr, casFeatCode_answer);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setAnswer(int addr, int v) {
        if (featOkTst && casFeat_answer == null)
      jcas.throwFeatMissing("answer", "edu.cmu.deiis.types.AnswerNGram");
    ll_cas.ll_setRefValue(addr, casFeatCode_answer, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public AnswerNGram_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_unigram = jcas.getRequiredFeatureDE(casType, "unigram", "edu.cmu.deiis.types.NGram", featOkTst);
    casFeatCode_unigram  = (null == casFeat_unigram) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_unigram).getCode();

 
    casFeat_bigram = jcas.getRequiredFeatureDE(casType, "bigram", "edu.cmu.deiis.types.NGram", featOkTst);
    casFeatCode_bigram  = (null == casFeat_bigram) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_bigram).getCode();

 
    casFeat_trigram = jcas.getRequiredFeatureDE(casType, "trigram", "edu.cmu.deiis.types.NGram", featOkTst);
    casFeatCode_trigram  = (null == casFeat_trigram) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_trigram).getCode();

 
    casFeat_answer = jcas.getRequiredFeatureDE(casType, "answer", "edu.cmu.deiis.types.Answer", featOkTst);
    casFeatCode_answer  = (null == casFeat_answer) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_answer).getCode();

  }
}



    


/* First created by JCasGen Thu Mar 06 01:23:46 CST 2014 */
package edu.cmu.deiis.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



/** 
 * Updated by JCasGen Thu Apr 03 01:46:42 CST 2014
 * XML source: /home/zal/workspace/hw3-139323/src/main/resources/descriptors/deiis_types.xml
 * @generated */
public class AnswerNGram extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(AnswerNGram.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected AnswerNGram() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public AnswerNGram(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public AnswerNGram(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public AnswerNGram(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: unigram

  /** getter for unigram - gets 
   * @generated
   * @return value of the feature 
   */
  public NGram getUnigram() {
    if (AnswerNGram_Type.featOkTst && ((AnswerNGram_Type)jcasType).casFeat_unigram == null)
      jcasType.jcas.throwFeatMissing("unigram", "edu.cmu.deiis.types.AnswerNGram");
    return (NGram)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((AnswerNGram_Type)jcasType).casFeatCode_unigram)));}
    
  /** setter for unigram - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setUnigram(NGram v) {
    if (AnswerNGram_Type.featOkTst && ((AnswerNGram_Type)jcasType).casFeat_unigram == null)
      jcasType.jcas.throwFeatMissing("unigram", "edu.cmu.deiis.types.AnswerNGram");
    jcasType.ll_cas.ll_setRefValue(addr, ((AnswerNGram_Type)jcasType).casFeatCode_unigram, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: bigram

  /** getter for bigram - gets 
   * @generated
   * @return value of the feature 
   */
  public NGram getBigram() {
    if (AnswerNGram_Type.featOkTst && ((AnswerNGram_Type)jcasType).casFeat_bigram == null)
      jcasType.jcas.throwFeatMissing("bigram", "edu.cmu.deiis.types.AnswerNGram");
    return (NGram)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((AnswerNGram_Type)jcasType).casFeatCode_bigram)));}
    
  /** setter for bigram - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setBigram(NGram v) {
    if (AnswerNGram_Type.featOkTst && ((AnswerNGram_Type)jcasType).casFeat_bigram == null)
      jcasType.jcas.throwFeatMissing("bigram", "edu.cmu.deiis.types.AnswerNGram");
    jcasType.ll_cas.ll_setRefValue(addr, ((AnswerNGram_Type)jcasType).casFeatCode_bigram, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: trigram

  /** getter for trigram - gets 
   * @generated
   * @return value of the feature 
   */
  public NGram getTrigram() {
    if (AnswerNGram_Type.featOkTst && ((AnswerNGram_Type)jcasType).casFeat_trigram == null)
      jcasType.jcas.throwFeatMissing("trigram", "edu.cmu.deiis.types.AnswerNGram");
    return (NGram)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((AnswerNGram_Type)jcasType).casFeatCode_trigram)));}
    
  /** setter for trigram - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setTrigram(NGram v) {
    if (AnswerNGram_Type.featOkTst && ((AnswerNGram_Type)jcasType).casFeat_trigram == null)
      jcasType.jcas.throwFeatMissing("trigram", "edu.cmu.deiis.types.AnswerNGram");
    jcasType.ll_cas.ll_setRefValue(addr, ((AnswerNGram_Type)jcasType).casFeatCode_trigram, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: answer

  /** getter for answer - gets 
   * @generated
   * @return value of the feature 
   */
  public Answer getAnswer() {
    if (AnswerNGram_Type.featOkTst && ((AnswerNGram_Type)jcasType).casFeat_answer == null)
      jcasType.jcas.throwFeatMissing("answer", "edu.cmu.deiis.types.AnswerNGram");
    return (Answer)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((AnswerNGram_Type)jcasType).casFeatCode_answer)));}
    
  /** setter for answer - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setAnswer(Answer v) {
    if (AnswerNGram_Type.featOkTst && ((AnswerNGram_Type)jcasType).casFeat_answer == null)
      jcasType.jcas.throwFeatMissing("answer", "edu.cmu.deiis.types.AnswerNGram");
    jcasType.ll_cas.ll_setRefValue(addr, ((AnswerNGram_Type)jcasType).casFeatCode_answer, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    
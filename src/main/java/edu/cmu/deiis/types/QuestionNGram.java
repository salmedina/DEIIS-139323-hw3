

/* First created by JCasGen Thu Mar 06 01:23:46 CST 2014 */
package edu.cmu.deiis.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



/** 
 * Updated by JCasGen Sat Mar 29 04:39:00 CST 2014
 * XML source: /home/zal/workspace/hw3-139323/src/main/resources/descriptors/deiis_types.xml
 * @generated */
public class QuestionNGram extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(QuestionNGram.class);
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
  protected QuestionNGram() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public QuestionNGram(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public QuestionNGram(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public QuestionNGram(JCas jcas, int begin, int end) {
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
    if (QuestionNGram_Type.featOkTst && ((QuestionNGram_Type)jcasType).casFeat_unigram == null)
      jcasType.jcas.throwFeatMissing("unigram", "edu.cmu.deiis.types.QuestionNGram");
    return (NGram)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((QuestionNGram_Type)jcasType).casFeatCode_unigram)));}
    
  /** setter for unigram - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setUnigram(NGram v) {
    if (QuestionNGram_Type.featOkTst && ((QuestionNGram_Type)jcasType).casFeat_unigram == null)
      jcasType.jcas.throwFeatMissing("unigram", "edu.cmu.deiis.types.QuestionNGram");
    jcasType.ll_cas.ll_setRefValue(addr, ((QuestionNGram_Type)jcasType).casFeatCode_unigram, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: bigram

  /** getter for bigram - gets 
   * @generated
   * @return value of the feature 
   */
  public NGram getBigram() {
    if (QuestionNGram_Type.featOkTst && ((QuestionNGram_Type)jcasType).casFeat_bigram == null)
      jcasType.jcas.throwFeatMissing("bigram", "edu.cmu.deiis.types.QuestionNGram");
    return (NGram)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((QuestionNGram_Type)jcasType).casFeatCode_bigram)));}
    
  /** setter for bigram - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setBigram(NGram v) {
    if (QuestionNGram_Type.featOkTst && ((QuestionNGram_Type)jcasType).casFeat_bigram == null)
      jcasType.jcas.throwFeatMissing("bigram", "edu.cmu.deiis.types.QuestionNGram");
    jcasType.ll_cas.ll_setRefValue(addr, ((QuestionNGram_Type)jcasType).casFeatCode_bigram, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: trigram

  /** getter for trigram - gets 
   * @generated
   * @return value of the feature 
   */
  public NGram getTrigram() {
    if (QuestionNGram_Type.featOkTst && ((QuestionNGram_Type)jcasType).casFeat_trigram == null)
      jcasType.jcas.throwFeatMissing("trigram", "edu.cmu.deiis.types.QuestionNGram");
    return (NGram)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((QuestionNGram_Type)jcasType).casFeatCode_trigram)));}
    
  /** setter for trigram - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setTrigram(NGram v) {
    if (QuestionNGram_Type.featOkTst && ((QuestionNGram_Type)jcasType).casFeat_trigram == null)
      jcasType.jcas.throwFeatMissing("trigram", "edu.cmu.deiis.types.QuestionNGram");
    jcasType.ll_cas.ll_setRefValue(addr, ((QuestionNGram_Type)jcasType).casFeatCode_trigram, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: question

  /** getter for question - gets 
   * @generated
   * @return value of the feature 
   */
  public Question getQuestion() {
    if (QuestionNGram_Type.featOkTst && ((QuestionNGram_Type)jcasType).casFeat_question == null)
      jcasType.jcas.throwFeatMissing("question", "edu.cmu.deiis.types.QuestionNGram");
    return (Question)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((QuestionNGram_Type)jcasType).casFeatCode_question)));}
    
  /** setter for question - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setQuestion(Question v) {
    if (QuestionNGram_Type.featOkTst && ((QuestionNGram_Type)jcasType).casFeat_question == null)
      jcasType.jcas.throwFeatMissing("question", "edu.cmu.deiis.types.QuestionNGram");
    jcasType.ll_cas.ll_setRefValue(addr, ((QuestionNGram_Type)jcasType).casFeatCode_question, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    


/* First created by JCasGen Thu Apr 03 01:35:48 CST 2014 */
package org.cleartk.syntax.dependency.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;
import org.cleartk.score.type.ScoredAnnotation;


/** 
 * Updated by JCasGen Fri Apr 04 19:11:37 CST 2014
 * XML source: /home/zal/workspace/hw3-139323/src/main/resources/descriptors/deiis_types.xml
 * @generated */
public class DependencyNode extends ScoredAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(DependencyNode.class);
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
  protected DependencyNode() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public DependencyNode(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public DependencyNode(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public DependencyNode(JCas jcas, int begin, int end) {
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
  //* Feature: HeadRelations

  /** getter for HeadRelations - gets 
   * @generated
   * @return value of the feature 
   */
  public FSArray getHeadRelations() {
    if (DependencyNode_Type.featOkTst && ((DependencyNode_Type)jcasType).casFeat_HeadRelations == null)
      jcasType.jcas.throwFeatMissing("HeadRelations", "org.cleartk.syntax.dependency.type.DependencyNode");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((DependencyNode_Type)jcasType).casFeatCode_HeadRelations)));}
    
  /** setter for HeadRelations - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setHeadRelations(FSArray v) {
    if (DependencyNode_Type.featOkTst && ((DependencyNode_Type)jcasType).casFeat_HeadRelations == null)
      jcasType.jcas.throwFeatMissing("HeadRelations", "org.cleartk.syntax.dependency.type.DependencyNode");
    jcasType.ll_cas.ll_setRefValue(addr, ((DependencyNode_Type)jcasType).casFeatCode_HeadRelations, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for HeadRelations - gets an indexed value - 
   * @generated
   * @param i index in the array to get
   * @return value of the element at index i 
   */
  public DependencyRelation getHeadRelations(int i) {
    if (DependencyNode_Type.featOkTst && ((DependencyNode_Type)jcasType).casFeat_HeadRelations == null)
      jcasType.jcas.throwFeatMissing("HeadRelations", "org.cleartk.syntax.dependency.type.DependencyNode");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((DependencyNode_Type)jcasType).casFeatCode_HeadRelations), i);
    return (DependencyRelation)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((DependencyNode_Type)jcasType).casFeatCode_HeadRelations), i)));}

  /** indexed setter for HeadRelations - sets an indexed value - 
   * @generated
   * @param i index in the array to set
   * @param v value to set into the array 
   */
  public void setHeadRelations(int i, DependencyRelation v) { 
    if (DependencyNode_Type.featOkTst && ((DependencyNode_Type)jcasType).casFeat_HeadRelations == null)
      jcasType.jcas.throwFeatMissing("HeadRelations", "org.cleartk.syntax.dependency.type.DependencyNode");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((DependencyNode_Type)jcasType).casFeatCode_HeadRelations), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((DependencyNode_Type)jcasType).casFeatCode_HeadRelations), i, jcasType.ll_cas.ll_getFSRef(v));}
   
    
  //*--------------*
  //* Feature: ChildRelations

  /** getter for ChildRelations - gets 
   * @generated
   * @return value of the feature 
   */
  public FSArray getChildRelations() {
    if (DependencyNode_Type.featOkTst && ((DependencyNode_Type)jcasType).casFeat_ChildRelations == null)
      jcasType.jcas.throwFeatMissing("ChildRelations", "org.cleartk.syntax.dependency.type.DependencyNode");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((DependencyNode_Type)jcasType).casFeatCode_ChildRelations)));}
    
  /** setter for ChildRelations - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setChildRelations(FSArray v) {
    if (DependencyNode_Type.featOkTst && ((DependencyNode_Type)jcasType).casFeat_ChildRelations == null)
      jcasType.jcas.throwFeatMissing("ChildRelations", "org.cleartk.syntax.dependency.type.DependencyNode");
    jcasType.ll_cas.ll_setRefValue(addr, ((DependencyNode_Type)jcasType).casFeatCode_ChildRelations, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for ChildRelations - gets an indexed value - 
   * @generated
   * @param i index in the array to get
   * @return value of the element at index i 
   */
  public DependencyRelation getChildRelations(int i) {
    if (DependencyNode_Type.featOkTst && ((DependencyNode_Type)jcasType).casFeat_ChildRelations == null)
      jcasType.jcas.throwFeatMissing("ChildRelations", "org.cleartk.syntax.dependency.type.DependencyNode");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((DependencyNode_Type)jcasType).casFeatCode_ChildRelations), i);
    return (DependencyRelation)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((DependencyNode_Type)jcasType).casFeatCode_ChildRelations), i)));}

  /** indexed setter for ChildRelations - sets an indexed value - 
   * @generated
   * @param i index in the array to set
   * @param v value to set into the array 
   */
  public void setChildRelations(int i, DependencyRelation v) { 
    if (DependencyNode_Type.featOkTst && ((DependencyNode_Type)jcasType).casFeat_ChildRelations == null)
      jcasType.jcas.throwFeatMissing("ChildRelations", "org.cleartk.syntax.dependency.type.DependencyNode");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((DependencyNode_Type)jcasType).casFeatCode_ChildRelations), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((DependencyNode_Type)jcasType).casFeatCode_ChildRelations), i, jcasType.ll_cas.ll_getFSRef(v));}
  }

    
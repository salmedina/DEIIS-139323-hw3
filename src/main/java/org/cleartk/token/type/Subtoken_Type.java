
/* First created by JCasGen Thu Apr 03 01:35:48 CST 2014 */
package org.cleartk.token.type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.cleartk.score.type.ScoredAnnotation_Type;

/** 
 * Updated by JCasGen Fri Apr 04 19:11:37 CST 2014
 * @generated */
public class Subtoken_Type extends ScoredAnnotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Subtoken_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Subtoken_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Subtoken(addr, Subtoken_Type.this);
  			   Subtoken_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Subtoken(addr, Subtoken_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Subtoken.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.cleartk.token.type.Subtoken");
 
  /** @generated */
  final Feature casFeat_position;
  /** @generated */
  final int     casFeatCode_position;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getPosition(int addr) {
        if (featOkTst && casFeat_position == null)
      jcas.throwFeatMissing("position", "org.cleartk.token.type.Subtoken");
    return ll_cas.ll_getIntValue(addr, casFeatCode_position);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setPosition(int addr, int v) {
        if (featOkTst && casFeat_position == null)
      jcas.throwFeatMissing("position", "org.cleartk.token.type.Subtoken");
    ll_cas.ll_setIntValue(addr, casFeatCode_position, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public Subtoken_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_position = jcas.getRequiredFeatureDE(casType, "position", "uima.cas.Integer", featOkTst);
    casFeatCode_position  = (null == casFeat_position) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_position).getCode();

  }
}



    
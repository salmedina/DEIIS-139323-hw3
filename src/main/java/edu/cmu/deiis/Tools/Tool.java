package edu.cmu.deiis.Tools;

import edu.cmu.deiis.types.Annotation;

/*
 * This class is an static auxiliary for misc purposes
 */
public class Tool {
	/*
	 * Obtains the string of an annotation
	 * given an input string
	 */
	public static String getAnnoStr(String docStr, Annotation anno) {
		return docStr.substring(anno.getBegin(), anno.getEnd());
	}
	
	/*
	 * Gets the string value of a boolean var
	 */
	public static String boolToStr(boolean val) {
		if(val)
			return "True";
		
		return "False";
	}
}

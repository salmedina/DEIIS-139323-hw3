/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package edu.cmu.deiis.cpe;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.examples.SourceDocumentInformation;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;
import org.apache.uima.util.CasToInlineXml;

import edu.cmu.deiis.types.Question;
import edu.cmu.deiis.types.AnswerScore;
import edu.cmu.deiis.types.Result;

/**
 * A simple CAS consumer that generates inline XML and writes it to a file. UTF-8 encoding is used.
 * <p>
 * This CAS Consumer takes one parameter:
 * <ul>
 * <li><code>OutputDirectory</code> - path to directory into which output files will be written</li>
 * </ul>
 * 
 * 
 */
public class PrintConsumer extends CasConsumer_ImplBase {
  /**
   * Name of configuration parameter that must be set to the path of a directory into which the
   * output files will be written.
   */
  public static final String PARAM_OUTPUTDIR = "OutputDirectory";

  private File mOutputDir;

  private CasToInlineXml cas2xml;

  private int mDocNum;

  public void initialize() throws ResourceInitializationException {
    mDocNum = 0;
    mOutputDir = new File(((String) getConfigParameterValue(PARAM_OUTPUTDIR)).trim());
    if (!mOutputDir.exists()) {
      mOutputDir.mkdirs();
    }
  }

  /**
   * Processes the CasContainer which was populated by the TextAnalysisEngines. <br>
   * In this case, the CAS is converted to XML and written into the output file .
   * 
   * @param aCAS
   *          CasContainer which has been populated by the TAEs
   * 
   * @throws ResourceProcessException
   *           if there is an error in processing the Resource
   * 
   * @see org.apache.uima.collection.base_cpm.CasObjectProcessor#processCas(org.apache.uima.cas.CAS)
   */
  public void processCas(CAS aCAS) throws ResourceProcessException {
    JCas jcas;
    try {
      jcas = aCAS.getJCas();
    } catch (CASException e) {
      throw new ResourceProcessException(e);
    }
    
 // 	retrieve the filename of the input file from the CAS
    FSIterator it = jcas.getAnnotationIndex(SourceDocumentInformation.type).iterator();
    File outFile = null;
    if (it.hasNext()) {
      SourceDocumentInformation fileLoc = (SourceDocumentInformation) it.next();
      File inFile;
      String outFileName ="out";
      try {
        inFile = new File(new URL(fileLoc.getUri()).getPath());
        outFileName = ((String) getConfigParameterValue(PARAM_OUTPUTDIR)).trim()+"/" +inFile.getName();
        if (fileLoc.getOffsetInSource() > 0) {
          outFileName += fileLoc.getOffsetInSource();
        }
      } catch (MalformedURLException e1) {
        // invalid URL, use default processing below
      }
      
      
      try {
	      PrintWriter writer = new PrintWriter(outFileName, "UTF-8");
	
	      // retrieve the filename of the input file from the CAS
	      FSIterator<?> questionIter = jcas.getAnnotationIndex(Question.type).iterator();
	      FSIterator<?> answerIter = jcas.getAnnotationIndex(AnswerScore.type).iterator();
	      FSIterator<?> resultIter = jcas.getAnnotationIndex(Result.type).iterator();
	
	      System.out.println("\nCONSUMER ACTION");
	      System.out.println(outFileName);
	      //Print the question
	      writer.printf("Q: %s\n", ((Question)questionIter.next()).getCoveredText());

	      //Print the answers
	      while (answerIter.hasNext()) {
	      	AnswerScore tmpAnswer = (AnswerScore)answerIter.next();
	      	writer.printf("A: %s %.2f %s\n", tmpAnswer.getAnswer().getIsCorrect()?"+":"-" , 
	  	    			tmpAnswer.getScore(),
	  	    			tmpAnswer.getAnswer().getCoveredText());
	      }
	      while (resultIter.hasNext()) {
	      	Result tmpRes = (Result)resultIter.next();
	      	writer.printf("\nPrecision @%d: %.2f%%", tmpRes.getN(), tmpRes.getPrecision());
	      }
	      writer.close();
      }catch(IOException e) {
    	  throw new ResourceProcessException(e);
      }
    }
  }
}

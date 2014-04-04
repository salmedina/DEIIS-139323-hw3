package edu.cmu.deiis.tools;

import java.util.HashMap;
import java.util.Map;

import org.apache.uima.aae.client.UimaAsBaseCallbackListener;
import org.apache.uima.aae.client.UimaAsynchronousEngine;
import org.apache.uima.adapter.jms.client.BaseUIMAAsynchronousEngine_impl;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;

public class Pipeline {
	private UimaAsynchronousEngine uimaAsEngine = null;
	private String uimaAsID = "";
	
	public Pipeline(UimaAsBaseCallbackListener callback) throws Exception 
    {
        System.out.println("UIMA AS Client");
        System.out.println("==============================================");

        // CREATE UIMA AE
        uimaAsEngine = new BaseUIMAAsynchronousEngine_impl();
        // add given callback listener 
        uimaAsEngine.addStatusCallbackListener(callback);

        //DEPLOY UIMA AE
        // preparing map for use in deploying services
        Map<String,Object> deployCtx = new HashMap<String,Object>();
        System.out.println(System.getenv("UIMA_HOME") + "/bin/dd2spring.xsl");
        System.out.println(System.getenv("UIMA_HOME") + "/saxon/saxon8.jar");
        deployCtx.put(UimaAsynchronousEngine.DD2SpringXsltFilePath, System.getenv("UIMA_HOME") + "/bin/dd2spring.xsl");
        deployCtx.put(UimaAsynchronousEngine.SaxonClasspath, "file:" + System.getenv("UIMA_HOME") + "/saxon/saxon8.jar");
        // creating aggregate analysis engine
        System.out.println("Deploying analysis engine");
        uimaAsID = uimaAsEngine.deploy("./src/main/resources/hw2-139323-aae-deploy.xml", deployCtx);

        //RUN UIMA AS AE
        // preparing map for use in a UIMA client for submitting text to process
        System.out.println("Initialising UIMA client");
        deployCtx.put(UimaAsynchronousEngine.ServerUri, "tcp://mu.lti.cs.cmu.edu:61616");
        deployCtx.put(UimaAsynchronousEngine.Endpoint,  "hw2-139323-Q");
        uimaAsEngine.initialize(deployCtx);
    }
    
    /**
     * Uses the UIMA analysis engine to process the provided document text.
     */
    public void process(String text) throws CASException, Exception{
        CAS cas = uimaAsEngine.getCAS();
        cas.setDocumentText(text);
        uimaAsEngine.sendCAS(cas);
    }
    
    public void undeploy() throws Exception {
    	if ( uimaAsEngine != null && 
    		!uimaAsID.isEmpty()) {
    		uimaAsEngine.undeploy(uimaAsID);
    	}
    }
}
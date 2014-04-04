package edu.cmu.deiis.tools;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.File;

import org.apache.uima.aae.client.UimaASProcessStatus;
import org.apache.uima.aae.client.UimaAsBaseCallbackListener;
import org.apache.uima.aae.monitor.statistics.AnalysisEnginePerformanceMetrics;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.text.AnnotationFS;
import org.apache.uima.collection.EntityProcessStatus;

public class Application {

	/** Time when pipeline was started. */
	private static long startTime = 0;
    
	public static void main(String[] args) throws CASException, Exception {
		// This is the INPUT STRING
		String content = new Scanner(new File("./src/main/resources/inputData/q001.txt")).useDelimiter("\\Z").next();
		System.out.println(content);
		String SAMPLE_DOCUMENT_TEXT = "some input text to process";
		
		// Listener for when the analysis engine is complete
		UimaAsBaseCallbackListener asyncListener = new UimaAsBaseCallbackListener() {
			/**
			 * Called once the text is processed
			 */
			@Override
			public void entityProcessComplete(CAS output, EntityProcessStatus aStatus) {
				// Validate status of the execution
				if (aStatus != null && aStatus.isException()) {
			      List exceptions = aStatus.getExceptions();
			      for (int i = 0; i < exceptions.size(); i++) {
			        ((Throwable) exceptions.get(i)).printStackTrace();
			      }
			      //uimaAsEngine.stop();
			      return;
			    }
				
				// Process the retrieved Cas here
			    if ( aStatus instanceof UimaASProcessStatus ) {
			      String casReferenceId = 
			        ((UimaASProcessStatus)aStatus).getCasReferenceId();
			      List<AnalysisEnginePerformanceMetrics> metrics = 
			        ((UimaASProcessStatus)aStatus).getPerformanceMetricsList();
			    }
			    
				// record the time that this was complete
				long endTime = System.currentTimeMillis();

				// display the time spent processing the text
				System.out.println("Time spent in pipeline: " + (endTime - startTime));
				
				// confirm that the expected annotations were added to the CAS
				System.out.println("Confirming what was added...");
				FSIterator<AnnotationFS> annotationsIterator = output.getAnnotationIndex().iterator();
				while (annotationsIterator.hasNext()){
					AnnotationFS annotation = (AnnotationFS) annotationsIterator.next();
					System.out.println("  Found: " + annotation.getClass().getName());
				}
			}
		};
		
		// constructs a class to create and run a UIMA pipeline
		Pipeline uimaPipeline = new Pipeline(asyncListener);

		// run the sample document through the pipeline
		System.out.println("Processing document...");
		startTime = System.currentTimeMillis();
		uimaPipeline.process(SAMPLE_DOCUMENT_TEXT);
    }
}

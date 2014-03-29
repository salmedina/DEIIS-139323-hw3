package edu.cmu.deiis.cpe;

import org.apache.uima.UIMAFramework;
import org.apache.uima.cas.CAS;
import org.apache.uima.collection.CollectionProcessingEngine;
import org.apache.uima.collection.EntityProcessStatus;
import org.apache.uima.collection.StatusCallbackListener;
import org.apache.uima.collection.metadata.CpeDescription;
import org.apache.uima.util.XMLInputSource;

class Launcher {
	public static void main(String[] args) throws Exception {
		// Create CPE description
		//TODO: hard coded file, need to add with relative path
		CpeDescription mCPEDesc = UIMAFramework.getXMLParser().
		parseCpeDescription(new XMLInputSource(
				"E:\\MCC\\Semester 4\\IIS\\Workspace\\hw3-139323\\src\\main\\resources\\descriptors\\hw3-139323-cpe.xml"
		));
		//Produce CPE
		CollectionProcessingEngine mCPE = UIMAFramework.produceCollectionProcessingEngine(mCPEDesc);
		//Create listener
		mCPE.addStatusCallbackListener(new StatusCallbackListener() {

			@Override
			public void initializationComplete() {
				// TODO Auto-generated method stub

			}

			@Override
			public void batchProcessComplete() {
				// TODO Auto-generated method stub

			}

			@Override
			public void collectionProcessComplete() {
				// TODO Auto-generated method stub

			}

			@Override
			public void paused() {
				// TODO Auto-generated method stub

			}

			@Override
			public void resumed() {
				// TODO Auto-generated method stub

			}

			@Override
			public void aborted() {
				// TODO Auto-generated method stub

			}

			@Override
			public void entityProcessComplete(CAS aCas,
					EntityProcessStatus aStatus) {
				// TODO Auto-generated method stub

			}

		});
		//Start Processing
		mCPE.process();
	}

}

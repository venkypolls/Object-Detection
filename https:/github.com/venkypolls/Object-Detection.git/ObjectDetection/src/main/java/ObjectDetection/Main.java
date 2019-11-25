package ObjectDetection;
import java.io.*;
import java.util.Arrays;

import com.ibm.cloud.sdk.core.security.IamAuthenticator;
//import com.ibm.cloud.sdk.core.service.security.IamOptions;
import com.ibm.watson.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.visual_recognition.v3.model.ClassifyOptions;
public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("true");
		IamAuthenticator authenticator = new IamAuthenticator("GMEIU-KCqpTuqU4on2pRU5eLiWCLRHsp-emjHHA9wlbS");
	    VisualRecognition visualRecognition = new VisualRecognition("2018-03-19", authenticator);
	    visualRecognition.setServiceUrl("https://gateway.watsonplatform.net/visual-recognition/api");

//	    ClassifyOptions classifyOptions = new ClassifyOptions.Builder()
//	        .url("https://ibm.biz/BdzLPG")
//	        .build();
//	    ClassifiedImages result = visualRecognition.classify(classifyOptions).execute().getResult();
//	    System.out.println(
//	        "\n******** Classify with the General model ********\n" + result
//	            + "\n******** END Classify with the General model ********\n");
//	    String output = result.getImages().get(0).getClassifiers().get(0).getClasses().get(0).getXClass();
//	    System.out.println(output);
//	    
	    
	    InputStream imagesStream = new FileInputStream("//Users//venkateshpolepally//Desktop//pexels-photo-1227515.jpeg");
	    ClassifyOptions classifyOptions = new ClassifyOptions.Builder()
	      .imagesFile(imagesStream).imagesFilename("wall")
	      .classifierIds(Arrays.asList("default"))
	      .build();
	    ClassifiedImages result = visualRecognition.classify(classifyOptions).execute().getResult();
	    String output = result.getImages().get(0).getClassifiers().get(0).getClasses().get(0).getXClass();
	    System.out.println(output);
	    //System.out.println(result);
	}

}

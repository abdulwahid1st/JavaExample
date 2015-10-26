/**
 * 
 */
package com.enawe.component.modules;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.integration.annotation.Headers;
import org.springframework.integration.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 *
 * example-springmvc
 * com.enawe.component.modules > FileBatchRequestTransformer.java
 * @author N Abdul Wh
 *
 * Oct 4, 2015 - 9:50:22 AM
 */
@Component("fileBatchRequestTransformer")
public class FileBatchRequestTransformer {

	final static Logger logger = Logger.getLogger(FileBatchRequestTransformer.class);
	
//	public JobLaunchRequest fromFile(@Headers Map<String, Object> map, @Payload File file) throws Exception {
//		
//	}
	public File doProcess(@Headers Map<String, Object> map, @Payload File input) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug(String.format("a new file has appeared (%s).", input.getAbsolutePath()));
			for (String k : map.keySet()) {
				logger.debug(String.format("header %s = %s", k, map.get(k)));
			}
		}
		BufferedReader br = new BufferedReader(new FileReader(input));
		String line;
		
		File output = new File(input.getName());
		FileWriter fw = new FileWriter(output);
		BufferedWriter bw = new BufferedWriter(fw);
		
		while ((line = br.readLine()) != null) {
			logger.debug(line);
			bw.write(line+",SUCCESS");
			bw.newLine();
		}
		
		bw.close();
		br.close();
		input.delete();
		return output;
	}
	public String doProcess(@Payload String input) throws Exception{
		if(logger.isDebugEnabled()){
			logger.debug("@@@@ ->"+input.split("\\n")[0]);
		}
		return input.toUpperCase();
	}
	public byte[] doProcess(@Payload byte[] input) {
		if(logger.isDebugEnabled()){
			logger.debug("@@@@ ->"+input.length);
		}
		return new String(input).toUpperCase().getBytes();
	}
}

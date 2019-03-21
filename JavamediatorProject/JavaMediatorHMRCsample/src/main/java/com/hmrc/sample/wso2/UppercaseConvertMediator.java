package com.hmrc.sample.wso2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.synapse.MessageContext; 
import org.apache.synapse.mediators.AbstractMediator;

public class UppercaseConvertMediator extends AbstractMediator { 
    private String name;
    Log log=LogFactory.getLog(UppercaseConvertMediator.class);
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean mediate(MessageContext context) { 
		convertToUppercase(context);
		return true;
	}
	private void convertToUppercase(MessageContext context) {
		String city=(String)context.getProperty("CITY");
		log.debug("Values obtained from seuence is" +city);
		String converted=city.toUpperCase();
		context.setProperty("CONVERTED",name+ "is lives at" + converted);
	}
}

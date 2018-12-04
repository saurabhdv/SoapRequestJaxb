package com.Actimize.drivers;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.Actimize.pojo.Amount;
import com.Actimize.pojo.Generic;
import com.Actimize.pojo.OnlineSession;
import com.Actimize.pojo.RetailTWIRequest;
import com.Actimize.pojo.TrxOppositeAccountData;
import com.Actimize.utils.SoapToJavaObjectsConverter;

public class MainDriver {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, JAXBException {
		String filePath = ".\\src\\xml\\demo.xml";
		
		
		RetailTWIRequest je = (RetailTWIRequest)SoapToJavaObjectsConverter.getUnmarshelledClassObject(filePath, RetailTWIRequest.class);
       
		Generic generic = je.getGeneric();
        TrxOppositeAccountData trxOppositeAccountData = generic.getTrxOppositeAccountData();
       
        
        
        String accountAmount = generic.getAmount().getAccountAmount();
       
        System.out.println(generic.getTrxMonitoredAccountData().getAccountNumber());
        
        
      /*  OnlineSession onlineSession = generic.getOnlineSession();
        System.out.println(onlineSession.getHttpHeader().getHttpHeaderFields());
        System.out.println( trxOppositeAccountData.getAccountName());
      //  System.out.println(amount.getAccountAmount());
*/	}
}

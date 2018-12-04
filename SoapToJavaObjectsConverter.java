package com.Actimize.utils;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class SoapToJavaObjectsConverter {

	public static Object getUnmarshelledClassObject(String filePath, Class className) throws ParserConfigurationException, SAXException, IOException, JAXBException{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        db.parse(new File(filePath));
        JAXBContext jc = JAXBContext.newInstance(className);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Object classObject = unmarshaller.unmarshal(new File(filePath));
        return classObject;
	}
}

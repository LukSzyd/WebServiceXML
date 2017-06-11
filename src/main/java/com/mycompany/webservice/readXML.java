/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webservice;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import com.mycompany.webservice.JDOMXMLReader;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;
/**
 *
 * @author Lukasz
 */
@WebService(serviceName = "readXML")
public class readXML {

    /**
     * This is a sample web service operation
     */
    JDOMXMLReader reader;
    Properties prop = new Properties();
    InputStream input = null;
    
    final static Logger logger = Logger.getLogger(readXML.class);
    
    @WebMethod(operationName = "readXML")
    public String readXML() {
        try {
            
            String filename = "properties.properties";
    	    input = readXML.class.getClassLoader().getResourceAsStream(filename);
            // load a properties file
            prop.load(input);
            logger.debug("This is debug : " + prop.getProperty("filePath"));
        } catch (FileNotFoundException ex) {
                logger.error("This is error : " + ex);
        } catch (IOException ex) {
                logger.error("This is error : " + ex);
        }


		
        return reader.getFile(prop.getProperty("filePath"));
    }
}

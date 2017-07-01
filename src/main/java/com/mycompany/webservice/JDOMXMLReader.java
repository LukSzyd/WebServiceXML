/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webservice;

/**
 *
 * @author Lukasz
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
 
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.DOMBuilder;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.StAXEventBuilder;
import org.jdom2.input.StAXStreamBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.mycompany.webservice.Employee;
import static com.mycompany.webservice.readXML.logger;
import org.apache.log4j.Logger;

import com.mycompany.webservice.exportToCSV;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;

 
public class JDOMXMLReader {
    
    private static exportToCSV exportToCsv;
    final static Logger logger = Logger.getLogger(readXML.class);
    static String csvFile = "C:/logs/user.csv";
    static FileWriter writer;
    public static String getFile(String fileName){
        //final String fileName = "/Users/pankaj/employees.xml";
        org.jdom2.Document jdomDoc;
        StringBuilder tmp = new StringBuilder(); // Using default 16 character size
        try {
            //we can create JDOM Document from DOM, SAX and STAX Parser Builder classes
            jdomDoc = useDOMParser(fileName);
            Element root = jdomDoc.getRootElement();
            List<Element> empListElements = root.getChildren("Employee");
            List<Employee> empList = new ArrayList<>();
            for (Element empElement : empListElements) {
                Employee emp = new Employee();
                emp.setId(Integer.parseInt(empElement.getAttributeValue("id")));
                emp.setAge(Integer.parseInt(empElement.getChildText("age")));
                emp.setName(empElement.getChildText("name"));
                emp.setRole(empElement.getChildText("role"));
                emp.setGender(empElement.getChildText("gender"));
                empList.add(emp);
                logger.debug("This is debug : " + emp);
            }
            
            writer = new FileWriter(csvFile);
            writer.flush();
            for (Employee emp : empList){
                //lets print Employees list information
                System.out.println(emp);
                tmp.append(emp);
                saveToCsv(emp.toString());
            }
            writer.close();    
                
        } catch (Exception e) {
            logger.error("This is error : " + e);
        }
        return tmp.toString();
    }
 
 
    //Get JDOM document from DOM Parser
    public static org.jdom2.Document useDOMParser(String fileName)
            throws ParserConfigurationException, SAXException, IOException {
        //creating DOM Document
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new File(fileName));
        DOMBuilder domBuilder = new DOMBuilder();
        return domBuilder.build(doc);
 
    }
    
    private static void saveToCsv(String tmp){
       
        try {
            exportToCsv.writeLine(writer, Arrays.asList(tmp), ',', '"');
        } catch (IOException ex) {
            logger.error("This is error : " + ex);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webservice;

import org.jdom2.Document;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lukasz
 */
public class JDOMXMLReaderTest {
    
    public JDOMXMLReaderTest() {
    }

    /**
     * Test of getFile method, of class JDOMXMLReader.
     */
    @org.junit.Test
    public void testGetFile() {
        System.out.println("getFile");
        String fileName = "";
        String expResult = "";
        String result = JDOMXMLReader.getFile(fileName);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of useDOMParser method, of class JDOMXMLReader.
     */
    @org.junit.Test
    public void testUseDOMParser() throws Exception {
        System.out.println("useDOMParser");
        String fileName = "";
        Document expResult = null;
        Document result = JDOMXMLReader.useDOMParser(fileName);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}

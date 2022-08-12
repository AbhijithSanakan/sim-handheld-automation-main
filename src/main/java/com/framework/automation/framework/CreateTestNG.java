package com.framework.automation.framework;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import com.framework.automation.framework.support.ConfigProp;
import com.framework.automation.framework.support.ParallelRunHolder;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 * The CreateTestNG class is used to create a TestNG xml according to the two input Excels mentioned in Test Data Folder
 *
 * @since 04-10-2019
 * @version 1.0
 *
 */
public class CreateTestNG {

    /**
     * The main method is used test if TesntNG creation is working as expected
     *
     * @param -
     * @return
     * @throws
     * @see -
     * @since 08-23-2019
     * @version 1.0
     *
     */
    public static void main(String argv[]) {
            try {
                if(ConfigProp.getPropertyValue("web_or_service").equalsIgnoreCase("yes")) {
                    String parallelDetailsWebOrService;
                    parallelDetailsWebOrService = ConfigProp.getPropertyValue("web_or_service");

                    Map<String, String> tempMap = new HashMap<String, String>();
                    String[] elements = parallelDetailsWebOrService.split(",");
                    for (String s1 : elements) {
                        String[] keyValue = s1.split("=");
                        tempMap.put(keyValue[0].toString(), keyValue[1].toString());
                    }
                    ParallelRunHolder.init(tempMap);
                    String filepath = "TestNgD.xml";
                    DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                    Document doc = docBuilder.parse(filepath);

                    // Get the root element
                    Node company = doc.getFirstChild();

                    // Get the staff element , it may not working if tag has spaces, or
                    // whatever weird characters in front...it's better to use
                    // getElementsByTagName() to get it directly.
                    // Node staff = company.getFirstChild();

                    // Get the staff element by tag name directly
                    Node staff = doc.getElementsByTagName("test").item(0);

                    // update staff attribute
                    NamedNodeMap attr = staff.getAttributes();
                    Node nodeAttrParallel = attr.getNamedItem("parallel");
                    nodeAttrParallel.setTextContent(ParallelRunHolder.getValue("Browser"));
                    Node nodeAttrName = attr.getNamedItem("name");
                    nodeAttrName.setTextContent(ConfigProp.getPropertyValue("test_name"));
                    Node nodeAttrDataProvider = attr.getNamedItem("data-provider-thread-count");
                    nodeAttrDataProvider.setTextContent(ConfigProp.getPropertyValue("noOfDataProvider"));

                    // write the content into xml file
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    DOMSource source = new DOMSource(doc);
                    StreamResult result = new StreamResult(new File(filepath));
                    transformer.transform(source, result);

                    System.out.println("Done with TestngM.xml");
                }

            } catch (ParserConfigurationException  pce) {
                pce.printStackTrace();
            } catch (TransformerException tfe) {
                tfe.printStackTrace();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            } catch (SAXException sae) {
                sae.printStackTrace();
            }
        }
}

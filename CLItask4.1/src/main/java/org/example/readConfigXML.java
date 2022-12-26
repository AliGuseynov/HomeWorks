package org.example;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;



public class readConfigXML {

    public static List<String>  wantedNodes  = new ArrayList<String>() ;
    public static List<String>  wantedAttributes= new ArrayList<String>()   ;
    public static void init(){
        wantedNodes.add("HomeScreenName") ;
        wantedNodes.add("HomeScreenAttributes") ;
        wantedAttributes.add("Logo") ;
    }

    public static void main(String[] args) throws IOException, JDOMException {
        init() ;

        SAXBuilder builder = new SAXBuilder();
        String folderPath = "C:\\Users\\User\\Desktop\\backend\\";
        String fileName = "testXml.xml";
        String filePath = folderPath + fileName;
        File xmlFile = new File(filePath);

        List<String> nodes = new ArrayList<String>() ;
        List<String> attributeNodes = new ArrayList<String>() ;

            Document document = (Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            List configList = rootNode.getChildren();
            for (int i = 0; i < configList.size(); i++)
            {
                Element node = (Element) configList.get(i);
//                System.out.println(node.getChildren());
                if(wantedNodes.contains(node.getName())){
                    nodes.add(node.getName()) ;
                    List dataNodes = node.getChildren();
                    for (int j = 0; j < dataNodes.size(); ++j)
                    {
                        Element dataNode = (Element) dataNodes.get(j);
                        if(wantedAttributes.contains(dataNode.getName())){
                            attributeNodes.add(dataNode.getValue()) ;
                        }
                    }
                }
            }
        System.out.println(nodes);
    }

}

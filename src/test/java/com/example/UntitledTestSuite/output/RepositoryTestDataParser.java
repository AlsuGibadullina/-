package com.example.UntitledTestSuite.output;

import com.example.UntitledTestSuite.dataClasses.RepositoryData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RepositoryTestDataParser {

    private final static String PATH = "D:\\IdeaProjects\\Tests\\src\\test\\java\\com\\example\\UntitledTestSuite\\output\\repositories.xml";

    public List<RepositoryData> parseData() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(PATH));
        document.getDocumentElement().normalize();
        Element root = document.getDocumentElement();
        System.out.println(root.getNodeName());
        NodeList nList = document.getElementsByTagName("repository");

        ArrayList<RepositoryData> repositories = new ArrayList<>();
        for (int temp = 0; temp < nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            System.out.println();
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;

                String repoId = eElement.getAttribute("id");
                String repoName = eElement.getElementsByTagName("name").item(0).getTextContent();
                String repoDescription = eElement.getElementsByTagName("description").item(0).getTextContent();
                RepositoryData repositoryData = new RepositoryData(repoName, repoDescription);
                repositories.add(repositoryData);
            }
        }
        return repositories;
    }
}

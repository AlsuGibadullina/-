package com.example.UntitledTestSuite.output;

import com.example.UntitledTestSuite.dataClasses.RepositoryData;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class RepositoryTestDataGenerator {

    private final static String PATH = "D:\\IdeaProjects\\Tests\\src\\test\\java\\com\\example\\UntitledTestSuite\\output\\repositories.xml";
    private final int generatedDataCount = 50;
    private final Faker faker = new Faker();

    public static void main(String[] args) {
        RepositoryTestDataGenerator markTestDataGenerator = new RepositoryTestDataGenerator();
        markTestDataGenerator.createXML();
    }

    private RepositoryData generateRepositoryData() {
        Name name = faker.name();
        return new RepositoryData(name.firstName(), name.title());
    }

    private void createXML() {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            //root elements
            Document doc = docBuilder.newDocument();

            Element rootElement = doc.createElement("markDataArray");
            doc.appendChild(rootElement);

            for (int i = 0; i < generatedDataCount; i++) {
                RepositoryData repositoryData = generateRepositoryData();

                Element repositoryElem = doc.createElement("repository");
                rootElement.appendChild(repositoryElem);

                Attr attr = doc.createAttribute("id");
                attr.setValue(String.valueOf(i));
                repositoryElem.setAttributeNode(attr);

                Element name = doc.createElement("name");
                name.appendChild(doc.createTextNode(repositoryData.getName()));
                repositoryElem.appendChild(name);

                Element description = doc.createElement("description");
                description.appendChild(doc.createTextNode(repositoryData.getDescription()));
                repositoryElem.appendChild(description);
            }

            //write the content into xml file
            TransformerFactory transformerFactory =  TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            StreamResult result =  new StreamResult(new File(PATH));
            transformer.transform(source, result);

            System.out.println("Done");

        }catch(ParserConfigurationException | TransformerException pce){
            pce.printStackTrace();
        }
    }
}

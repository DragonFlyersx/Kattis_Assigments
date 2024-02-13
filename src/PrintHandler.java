import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import java.util.ArrayList;

public class PrintHandler extends DefaultHandler {
    PrintStream out;
    int amount = 0;
    int indent = 0;

    ArrayList<String> unique_tags;


    public PrintHandler(PrintStream _out) {
        out = _out;
    }

    public void setDocumentLocator(Locator locator) {
        out.printf("setDocumentLocator(%s)\n", locator.getSystemId());
    }

    public void startDocument() {
        out.printf("startDocument()\n");
        unique_tags = new ArrayList<>();

    }

    public void startElement(String uri, String localName, String qName, Attributes atts) {
        out.printf("startElement(%s, %d attributes)\n", qName, atts.getLength());
            //unique_tags.add(unique_tags.size(), "<" + qName + ">");
           /* if(qName.equals("tag")){ // get the value v of the attribute.
                System.out.println(atts.getValue("v"));
            }*/
            String x = "<" + qName + ">";

            if(indent > 0){
            for(int i = 0; i < indent; i++) {
                x = "-" + x;
                }
            }
            System.out.println(x);
            unique_tags.add(unique_tags.size(), x);
            indent++;

    }

    public void characters(char[] ch, int start, int length) {
        out.printf("characters(%s)\n", new String(ch, start, length));
    }

    public void endElement(String uri, String localName, String qName) {
        out.printf("endElement(%s)\n", qName);
        indent--;
        amount++;
    }

    public void endDocument() {
        out.printf("End document\n");
        System.out.println(amount);
        for(String t: unique_tags){
            System.out.println(t);
        }
    }

    public static void main(String[] args) {
        try {
            XMLReader reader = SAXParserFactory
                    .newInstance()
                    .newSAXParser()
                    .getXMLReader();
            reader.setContentHandler(new PrintHandler(System.out));
            String pathtofile="/Users/mathiaslarsen/IdeaProjects/Kattis/xml-samples/rhubarb.xml";
            reader.parse(pathtofile);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
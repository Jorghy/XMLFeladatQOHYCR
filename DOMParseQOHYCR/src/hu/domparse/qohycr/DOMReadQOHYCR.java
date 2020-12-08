package hu.domparse.qohycr;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMReadQOHYCR {

	private static void printNode(Node n) {
		//Végig megyünk az elemeken
		NodeList nl = n.getChildNodes();
		for (int i = 0; i < nl.getLength(); i++) {
			if(nl.item(i).getNodeName() != "#text") {
				//Gyerek elemeket is kilistázzuk
				Node no = nl.item(i);
				System.out.println(no.getNodeName());
				//Ha még a gyereknek is van gyereke abba is bele lépünk
				if(no.hasChildNodes()) {
					for(int j = 0; j < no.getChildNodes().getLength(); j++) {
						Node node = no.getChildNodes().item(j);
						if(node.getNodeType() == Node.ELEMENT_NODE) {
							System.out.println("\t" + node.getNodeName() + ": " + node.getTextContent());
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			Document document = db.parse("D:\\Project\\Eclipse\\DOMParseQOHYCR\\XMLqohycr.xml");
			Element root = document.getDocumentElement();
			
			printNode(root);
			DOMModifyQOHYCR.modifyDuration(root);
			printNode(root);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

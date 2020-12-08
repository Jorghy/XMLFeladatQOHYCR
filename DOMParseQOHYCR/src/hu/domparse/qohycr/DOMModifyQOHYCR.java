package hu.domparse.qohycr;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMModifyQOHYCR {
	public static void modifyDuration(Node root) {
		try {
			System.out.println(root.getNodeType());
			//Lekérjük a node listát
			NodeList nl = root.getChildNodes();
			for(int i = 0; i< nl.getLength(); i++){
				//Megnézük, hogy a vizsgalat node-nál vagyunk-e
				if (nl.item(i).getNodeName() == "vizsgalat") {
					for(int k = 0; k < nl.item(i).getChildNodes().getLength(); k++) {
						//A vizsgálat node idotartam erteket változtatjuk
						if(nl.item(i).getChildNodes().item(k).getNodeName() == "idotartam") {
							int duration = Integer.parseInt(nl.item(i).getChildNodes().item(k).getTextContent());
							nl.item(i).getChildNodes().item(k).setTextContent(String.valueOf(duration + 15));
						}
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
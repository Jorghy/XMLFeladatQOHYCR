package hu.domparse.qohycr;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMModifyQOHYCR {
	public static void modifyDuration(Node root) {
		try {
			System.out.println(root.getNodeType());
			//Lek�rj�k a node list�t
			NodeList nl = root.getChildNodes();
			for(int i = 0; i< nl.getLength(); i++){
				//Megn�z�k, hogy a vizsgalat node-n�l vagyunk-e
				if (nl.item(i).getNodeName() == "vizsgalat") {
					for(int k = 0; k < nl.item(i).getChildNodes().getLength(); k++) {
						//A vizsg�lat node idotartam erteket v�ltoztatjuk
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
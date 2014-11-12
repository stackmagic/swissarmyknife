package net.swisstech.swissarmyknife.iso;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import net.swisstech.log.Logger;
import net.swisstech.log.LoggerFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * translate 3-letter language codes to 2-letter language codes
 * @since 1.1.4
 */
public final class Iso639 {

	private static final Logger LOG = LoggerFactory.getLogger(Iso639.class);

	private static final Map<String, String> THREE_TO_TWO_LETTER_MAPPING = new HashMap<String, String>();

	private static final boolean ENABLED;

	public static final String FILE_NAME = "/usr/share/xml/iso-codes/iso_639_3.xml";

	static {

		// some of the most basic mappings
		THREE_TO_TWO_LETTER_MAPPING.put("deu", "de");
		THREE_TO_TWO_LETTER_MAPPING.put("eng", "en");
		THREE_TO_TWO_LETTER_MAPPING.put("fra", "fr");
		THREE_TO_TWO_LETTER_MAPPING.put("ger", "de");

		try {
			File file = new File(FILE_NAME);

			if (file.exists()) {
				ENABLED = true;
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				Document doc = db.parse(file);
				NodeList entryList = doc.getDocumentElement().getChildNodes();
				int length = entryList.getLength();
				for (int i = 0; i < length; i++) {
					Node entry = entryList.item(i);
					if (entry.getNodeType() != Node.ELEMENT_NODE) {
						continue;
					}

					// the 2-letter code
					String p1Code = getAttributeText(entry, "part1_code");

					// the 3-letter code
					String p2Code = getAttributeText(entry, "part2_code");

					if (p1Code == null || p2Code == null) {
						continue;
					}

					p1Code = p1Code.toLowerCase();
					p2Code = p2Code.toLowerCase();

					THREE_TO_TWO_LETTER_MAPPING.put(p2Code, p1Code);
				}
			}
			else {
				ENABLED = false;
				LOG.error("### ---------------------------------------------------------------------------");
				LOG.error("### File %s does not exist", FILE_NAME);
				LOG.error("### ISO630 language code translations will NOT be available");
				LOG.error("### on debian, install the 'iso-codes' package");
				LOG.error("### ---------------------------------------------------------------------------");
			}
		}
		catch (ParserConfigurationException e) {
			throw new RuntimeException(e);
		}
		catch (SAXException e) {
			throw new RuntimeException(e);
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/** private constructor for utility class */
	private Iso639() {}

	private static String getAttributeText(Node entry, String attributeName) {
		NamedNodeMap attributes = entry.getAttributes();
		if (attributes == null) {
			return null;
		}
		Node attribute = attributes.getNamedItem(attributeName);
		if (attribute == null) {
			return null;
		}
		return attribute.getNodeValue();
	}

	public static int getMappingCount() {
		return THREE_TO_TWO_LETTER_MAPPING.size();
	}

	public static String convert(String threeLetterCode) {
		if (!ENABLED) {
			return threeLetterCode;
		}
		if (threeLetterCode == null) {
			return null;
		}

		String twoLetterCode = THREE_TO_TWO_LETTER_MAPPING.get(threeLetterCode.toLowerCase());
		if (twoLetterCode == null) {
			return threeLetterCode;
		}
		return twoLetterCode;
	}
}

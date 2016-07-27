package guerer.example;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import java.util.logging.Logger;

public class JAXBUtil {
	private static Logger logger = Logger.getLogger("JAXBUtil");

	public static String marshalNameSpace(Object obj) {
		StringWriter out = new StringWriter();
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());

			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
					Boolean.TRUE);

			marshaller.marshal(obj, out);
			return out.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				out.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T unmarshal(String xmlString, Class<T> classType) {
		StringReader in = new StringReader(xmlString);
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(classType);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			return (T) unmarshaller.unmarshal(in);
		} catch (Exception e) {
			logger.info("Xml String: " + xmlString);
			throw new RuntimeException(e);
		} finally {
			try {
				in.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

}

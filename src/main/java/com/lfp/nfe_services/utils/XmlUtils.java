package com.lfp.nfe_services.utils;

import static jakarta.xml.bind.JAXBContext.newInstance;

import com.lfp.nfe_services.model.xml.Nfe;
import jakarta.xml.bind.JAXBException;
import java.io.StringReader;

public class XmlUtils {

  private  XmlUtils() {}

  public static Nfe parseToNfeObject(final String xmlContent) throws JAXBException {
    final var context = newInstance(Nfe.class);
    final var unmarshaller = context.createUnmarshaller();
    final var reader = new StringReader(xmlContent);

    return (Nfe) unmarshaller.unmarshal(reader);
  }
}

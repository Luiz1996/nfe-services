package com.lfp.nfe_services.model.xml;

import static jakarta.xml.bind.annotation.XmlAccessType.FIELD;

import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "NFe")
@XmlAccessorType(FIELD)
public class Nfe {

  @XmlElement(name = "infNFe")
  private InfNfe infNfe;

  public InfNfe getInfNfe() {
    return infNfe;
  }

  public void setInfNfe(InfNfe infNfe) {
    this.infNfe = infNfe;
  }
}

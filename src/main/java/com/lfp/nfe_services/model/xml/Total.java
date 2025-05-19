package com.lfp.nfe_services.model.xml;

import static jakarta.xml.bind.annotation.XmlAccessType.FIELD;

import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(FIELD)
public class Total {

  @XmlElement(name = "ICMSTot")
  private IcmsTot icmsTot;

  public IcmsTot getIcmsTot() {
    return icmsTot;
  }

  public void setIcmsTot(IcmsTot icmsTot) {
    this.icmsTot = icmsTot;
  }
}

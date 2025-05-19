package com.lfp.nfe_services.model.xml;

import static jakarta.xml.bind.annotation.XmlAccessType.FIELD;

import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(FIELD)
public class InfNfe {

  @XmlAttribute(name = "Id")
  private String id;

  @XmlAttribute(name = "versao")
  private String versao;

  @XmlElement(name = "ide")
  private Ide ide;

  @XmlElement(name = "total")
  private Total total;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getVersao() {
    return versao;
  }

  public void setVersao(String versao) {
    this.versao = versao;
  }

  public Ide getIde() {
    return ide;
  }

  public void setIde(Ide ide) {
    this.ide = ide;
  }

  public Total getTotal() {
    return total;
  }

  public void setTotal(Total total) {
    this.total = total;
  }
}

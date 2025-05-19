package com.lfp.nfe_services.model.xml;

import static jakarta.xml.bind.annotation.XmlAccessType.FIELD;

import com.lfp.nfe_services.model.xml.adapters.LocalDateAdapter;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@XmlAccessorType(FIELD)
public class Ide {

  @XmlElement(name = "cUF")
  private String cUf;

  @XmlElement(name = "cNF")
  private String cNf;

  @XmlElement(name = "natOp")
  private String natOp;

  @XmlElement(name = "indPag")
  private String indPag;

  @XmlElement(name = "mod")
  private String mod;

  @XmlElement(name = "serie")
  private String serie;

  @XmlElement(name = "nNF")
  private String nNf;

  @XmlElement(name = "dEmi")
  @XmlJavaTypeAdapter(LocalDateAdapter.class)
  private LocalDate dEmi;

  @XmlElement(name = "dSaiEnt")
  @XmlJavaTypeAdapter(LocalDateAdapter.class)
  private LocalDate dSaiEnt;

  @XmlElement(name = "tpNF")
  private String tpNf;

  @XmlElement(name = "cMunFG")
  private String cMunFg;

  @XmlElement(name = "tpImp")
  private String tpImp;

  @XmlElement(name = "tpEmis")
  private String tpEmis;

  @XmlElement(name = "cDV")
  private String cDv;

  @XmlElement(name = "tpAmb")
  private String tpAmb;

  @XmlElement(name = "finNFe")
  private String finNfe;

  @XmlElement(name = "procEmi")
  private String procEmi;

  @XmlElement(name = "verProc")
  private String verProc;

  public String getcUf() {
    return cUf;
  }

  public void setcUf(String cUf) {
    this.cUf = cUf;
  }

  public String getcNf() {
    return cNf;
  }

  public void setcNf(String cNf) {
    this.cNf = cNf;
  }

  public String getNatOp() {
    return natOp;
  }

  public void setNatOp(String natOp) {
    this.natOp = natOp;
  }

  public String getIndPag() {
    return indPag;
  }

  public void setIndPag(String indPag) {
    this.indPag = indPag;
  }

  public String getMod() {
    return mod;
  }

  public void setMod(String mod) {
    this.mod = mod;
  }

  public String getSerie() {
    return serie;
  }

  public void setSerie(String serie) {
    this.serie = serie;
  }

  public String getnNf() {
    return nNf;
  }

  public void setnNf(String nNf) {
    this.nNf = nNf;
  }

  public LocalDate getdEmi() {
    return dEmi;
  }

  public void setdEmi(LocalDate dEmi) {
    this.dEmi = dEmi;
  }

  public LocalDate getdSaiEnt() {
    return dSaiEnt;
  }

  public void setdSaiEnt(LocalDate dSaiEnt) {
    this.dSaiEnt = dSaiEnt;
  }

  public String getTpNf() {
    return tpNf;
  }

  public void setTpNf(String tpNf) {
    this.tpNf = tpNf;
  }

  public String getcMunFg() {
    return cMunFg;
  }

  public void setcMunFg(String cMunFg) {
    this.cMunFg = cMunFg;
  }

  public String getTpImp() {
    return tpImp;
  }

  public void setTpImp(String tpImp) {
    this.tpImp = tpImp;
  }

  public String getTpEmis() {
    return tpEmis;
  }

  public void setTpEmis(String tpEmis) {
    this.tpEmis = tpEmis;
  }

  public String getcDv() {
    return cDv;
  }

  public void setcDv(String cDv) {
    this.cDv = cDv;
  }

  public String getTpAmb() {
    return tpAmb;
  }

  public void setTpAmb(String tpAmb) {
    this.tpAmb = tpAmb;
  }

  public String getFinNfe() {
    return finNfe;
  }

  public void setFinNfe(String finNfe) {
    this.finNfe = finNfe;
  }

  public String getProcEmi() {
    return procEmi;
  }

  public void setProcEmi(String procEmi) {
    this.procEmi = procEmi;
  }

  public String getVerProc() {
    return verProc;
  }

  public void setVerProc(String verProc) {
    this.verProc = verProc;
  }
}

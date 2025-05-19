package com.lfp.nfe_services.model.xml;

import static jakarta.xml.bind.annotation.XmlAccessType.FIELD;

import com.lfp.nfe_services.model.xml.adapters.BigDecimalAdapter;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;

@XmlAccessorType(FIELD)
public class IcmsTot {

  @XmlElement(name = "vBC")
  @XmlJavaTypeAdapter(BigDecimalAdapter.class)
  private BigDecimal vBc;

  @XmlElement(name = "vICMS")
  @XmlJavaTypeAdapter(BigDecimalAdapter.class)
  private BigDecimal vIcms;

  @XmlElement(name = "vBCST")
  @XmlJavaTypeAdapter(BigDecimalAdapter.class)
  private BigDecimal vBcst;

  @XmlElement(name = "vST")
  @XmlJavaTypeAdapter(BigDecimalAdapter.class)
  private BigDecimal vSt;

  @XmlElement(name = "vProd")
  @XmlJavaTypeAdapter(BigDecimalAdapter.class)
  private BigDecimal vProd;

  @XmlElement(name = "vFrete")
  @XmlJavaTypeAdapter(BigDecimalAdapter.class)
  private BigDecimal vFrete;

  @XmlElement(name = "vSeg")
  @XmlJavaTypeAdapter(BigDecimalAdapter.class)
  private BigDecimal vSeg;

  @XmlElement(name = "vDesc")
  @XmlJavaTypeAdapter(BigDecimalAdapter.class)
  private BigDecimal vDesc;

  @XmlElement(name = "vII")
  @XmlJavaTypeAdapter(BigDecimalAdapter.class)
  private BigDecimal vIi;

  @XmlElement(name = "vIPI")
  @XmlJavaTypeAdapter(BigDecimalAdapter.class)
  private BigDecimal vIpi;

  @XmlElement(name = "vPIS")
  @XmlJavaTypeAdapter(BigDecimalAdapter.class)
  private BigDecimal vPis;

  @XmlElement(name = "vCOFINS")
  @XmlJavaTypeAdapter(BigDecimalAdapter.class)
  private BigDecimal vCofins;

  @XmlElement(name = "vOutro")
  @XmlJavaTypeAdapter(BigDecimalAdapter.class)
  private BigDecimal vOutro;

  @XmlElement(name = "vNF")
  @XmlJavaTypeAdapter(BigDecimalAdapter.class)
  private BigDecimal vNf;

  public BigDecimal getvBc() {
    return vBc;
  }

  public void setvBc(BigDecimal vBc) {
    this.vBc = vBc;
  }

  public BigDecimal getvIcms() {
    return vIcms;
  }

  public void setvIcms(BigDecimal vIcms) {
    this.vIcms = vIcms;
  }

  public BigDecimal getvBcst() {
    return vBcst;
  }

  public void setvBcst(BigDecimal vBcst) {
    this.vBcst = vBcst;
  }

  public BigDecimal getvSt() {
    return vSt;
  }

  public void setvSt(BigDecimal vSt) {
    this.vSt = vSt;
  }

  public BigDecimal getvProd() {
    return vProd;
  }

  public void setvProd(BigDecimal vProd) {
    this.vProd = vProd;
  }

  public BigDecimal getvFrete() {
    return vFrete;
  }

  public void setvFrete(BigDecimal vFrete) {
    this.vFrete = vFrete;
  }

  public BigDecimal getvSeg() {
    return vSeg;
  }

  public void setvSeg(BigDecimal vSeg) {
    this.vSeg = vSeg;
  }

  public BigDecimal getvDesc() {
    return vDesc;
  }

  public void setvDesc(BigDecimal vDesc) {
    this.vDesc = vDesc;
  }

  public BigDecimal getvIi() {
    return vIi;
  }

  public void setvIi(BigDecimal vIi) {
    this.vIi = vIi;
  }

  public BigDecimal getvIpi() {
    return vIpi;
  }

  public void setvIpi(BigDecimal vIpi) {
    this.vIpi = vIpi;
  }

  public BigDecimal getvPis() {
    return vPis;
  }

  public void setvPis(BigDecimal vPis) {
    this.vPis = vPis;
  }

  public BigDecimal getvCofins() {
    return vCofins;
  }

  public void setvCofins(BigDecimal vCofins) {
    this.vCofins = vCofins;
  }

  public BigDecimal getvOutro() {
    return vOutro;
  }

  public void setvOutro(BigDecimal vOutro) {
    this.vOutro = vOutro;
  }

  public BigDecimal getvNf() {
    return vNf;
  }

  public void setvNf(BigDecimal vNf) {
    this.vNf = vNf;
  }
}

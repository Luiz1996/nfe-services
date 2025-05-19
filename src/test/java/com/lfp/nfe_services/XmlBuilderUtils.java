package com.lfp.nfe_services;

public class XmlBuilderUtils {

  public static String getXml() {
    return
                      """
											<NFe xmlns="http://www.portalfiscal.inf.br/nfe">
											<infNFe Id="NFe351107887061210001355567891690820711234568802" versao="2.00">
												<ide>
													<cUF>35</cUF>
													<cNF>12345680</cNF>
													<natOp>emissao de teste</natOp>
													<indPag>0</indPag>
													<mod>55</mod>
													<serie>678</serie>
													<nNF>916900207</nNF>
													<dEmi>2011-07-07</dEmi>
													<dSaiEnt>2011-07-07</dSaiEnt>
													<tpNF>1</tpNF>
													<cMunFG>3106200</cMunFG>
													<tpImp>2</tpImp>
													<tpEmis>1</tpEmis>
													<cDV>2</cDV>
													<tpAmb>2</tpAmb>
													<finNFe>1</finNFe>
													<procEmi>0</procEmi>
													<verProc>1.50</verProc>
												</ide>
												<total>
													<ICMSTot>
														<vBC>0.00</vBC>
														<vICMS>0.00</vICMS>
														<vBCST>0.00</vBCST>
														<vST>0.00</vST>
														<vProd>3000.00</vProd>
														<vFrete>0.00</vFrete>
														<vSeg>0.00</vSeg>
														<vDesc>0.00</vDesc>
														<vII>0.00</vII>
														<vIPI>0.00</vIPI>
														<vPIS>0.00</vPIS>
														<vCOFINS>0.00</vCOFINS>
														<vOutro>0.00</vOutro>
														<vNF>3000.00</vNF>
													</ICMSTot>
												</total>
											</infNFe>
											</NFe>
											""";
  }

  public static String getXmlInJson() {
    return """
        {
        	"xml": "<?xml version=\\"1.0\\" encoding=\\"UTF-8\\"?>\\r\\n<NFe xmlns=\\"http://www.portalfiscal.inf.br/nfe\\">\\r\\n\\t<infNFe Id=\\"NFe351107887061210001355567891690820711234568802\\" versao=\\"2.00\\">\\r\\n\\t\\t<ide>\\r\\n\\t\\t\\t<cUF>35</cUF>\\r\\n\\t\\t\\t<cNF>12345680</cNF>\\r\\n\\t\\t\\t<natOp>emissao de teste</natOp>\\r\\n\\t\\t\\t<indPag>0</indPag>\\r\\n\\t\\t\\t<mod>55</mod>\\r\\n\\t\\t\\t<serie>678</serie>\\r\\n\\t\\t\\t<nNF>916900207</nNF>\\r\\n\\t\\t\\t<dEmi>2011-07-07</dEmi>\\r\\n\\t\\t\\t<dSaiEnt>2011-07-07</dSaiEnt>\\r\\n\\t\\t\\t<tpNF>1</tpNF>\\r\\n\\t\\t\\t<cMunFG>3106200</cMunFG>\\r\\n\\t\\t\\t<tpImp>2</tpImp>\\r\\n\\t\\t\\t<tpEmis>1</tpEmis>\\r\\n\\t\\t\\t<cDV>2</cDV>\\r\\n\\t\\t\\t<tpAmb>2</tpAmb>\\r\\n\\t\\t\\t<finNFe>1</finNFe>\\r\\n\\t\\t\\t<procEmi>0</procEmi>\\r\\n\\t\\t\\t<verProc>1.50</verProc>\\r\\n\\t\\t</ide>\\r\\n\\t\\t<total>\\r\\n\\t\\t\\t<ICMSTot>\\r\\n\\t\\t\\t\\t<vBC>0.00</vBC>\\r\\n\\t\\t\\t\\t<vICMS>0.00</vICMS>\\r\\n\\t\\t\\t\\t<vBCST>0.00</vBCST>\\r\\n\\t\\t\\t\\t<vST>0.00</vST>\\r\\n\\t\\t\\t\\t<vProd>3000.00</vProd>\\r\\n\\t\\t\\t\\t<vFrete>0.00</vFrete>\\r\\n\\t\\t\\t\\t<vSeg>0.00</vSeg>\\r\\n\\t\\t\\t\\t<vDesc>0.00</vDesc>\\r\\n\\t\\t\\t\\t<vII>0.00</vII>\\r\\n\\t\\t\\t\\t<vIPI>0.00</vIPI>\\r\\n\\t\\t\\t\\t<vPIS>0.00</vPIS>\\r\\n\\t\\t\\t\\t<vCOFINS>0.00</vCOFINS>\\r\\n\\t\\t\\t\\t<vOutro>0.00</vOutro>\\r\\n\\t\\t\\t\\t<vNF>3000.00</vNF>\\r\\n\\t\\t\\t</ICMSTot>\\r\\n\\t\\t</total>\\r\\n\\t</infNFe>\\r\\n</NFe>",
        	"dateTime": "2025-05-17T19:28:07.619499"
        }
        """;
  }
}

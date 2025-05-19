package com.lfp.nfe_services.model.xml.adapters;

import static java.math.BigDecimal.ZERO;
import static org.springframework.util.StringUtils.hasText;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.math.BigDecimal;

public class BigDecimalAdapter extends XmlAdapter<String, BigDecimal> {

  @Override
  public BigDecimal unmarshal(final String value) {
    return hasText(value) ? new BigDecimal(value) : ZERO;
  }

  @Override
  public String marshal(final BigDecimal value) {
    return value.toString();
  }
}


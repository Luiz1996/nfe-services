package com.lfp.nfe_services.model.xml.adapters;

import static java.time.LocalDate.parse;
import static java.time.format.DateTimeFormatter.ofPattern;
import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.hasText;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

  private static final DateTimeFormatter FORMATTER = ofPattern("yyyy-MM-dd");

  @Override
  public LocalDate unmarshal(final String value) {
    return !hasText(value) ? null : parse(value, FORMATTER);
  }

  @Override
  public String marshal(final LocalDate value) {
    return isNull(value) ? null : value.format(FORMATTER);
  }
}


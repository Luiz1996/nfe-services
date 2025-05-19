package com.lfp.nfe_services.kafka.event;

import static java.time.Clock.systemUTC;
import static java.time.LocalDateTime.now;

import java.time.LocalDateTime;

public class NfeUploadEvent {

  private String xml;
  private final LocalDateTime dateTime;

  public NfeUploadEvent(String xml) {
    this.xml = xml;
    this.dateTime = now(systemUTC());
  }

  public String getXml() {
    return xml;
  }

  public void setXml(String xml) {
    this.xml = xml;
  }

  public LocalDateTime getDateTime() {
    return dateTime;
  }
}

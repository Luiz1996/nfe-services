package com.lfp.nfe_services.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("nfe_basic_data")
public class NfeBasicDataEntity {

  @Id
  @Column("nfe_basic_data_id")
  private UUID id;

  @Column("topic_key")
  private UUID topicKey;

  @Column("emission_date")
  private LocalDate emissionDate;

  @Column("total_value")
  private BigDecimal totalValue;

  @Column("upload_date_time")
  private LocalDateTime uploadDateTime;

  public NfeBasicDataEntity(
      final UUID topicKey,
      final LocalDate emissionDate,
      final BigDecimal totalValue,
      final LocalDateTime uploadDateTime) {
    this.topicKey = topicKey;
    this.emissionDate = emissionDate;
    this.totalValue = totalValue;
    this.uploadDateTime = uploadDateTime;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public UUID getTopicKey() {
    return topicKey;
  }

  public void setTopicKey(UUID topicKey) {
    this.topicKey = topicKey;
  }

  public LocalDate getEmissionDate() {
    return emissionDate;
  }

  public void setEmissionDate(LocalDate emissionDate) {
    this.emissionDate = emissionDate;
  }

  public BigDecimal getTotalValue() {
    return totalValue;
  }

  public void setTotalValue(BigDecimal totalValue) {
    this.totalValue = totalValue;
  }

  public LocalDateTime getUploadDateTime() {
    return uploadDateTime;
  }

  public void setUploadDateTime(LocalDateTime uploadDateTime) {
    this.uploadDateTime = uploadDateTime;
  }
}

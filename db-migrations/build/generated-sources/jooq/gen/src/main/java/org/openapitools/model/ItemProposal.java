package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.model.ItemProposalItem;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ItemProposal
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-09-13T08:20:36.992431+02:00[Europe/Berlin]", comments = "Generator version: 7.7.0")
public class ItemProposal {

  private ItemProposalItem item;

  private String reason;

  private String modifiedBy;

  private String emailNotification;

  private Boolean ignoreItem = false;

  public ItemProposal() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ItemProposal(String reason, String modifiedBy) {
    this.reason = reason;
    this.modifiedBy = modifiedBy;
  }

  public ItemProposal item(ItemProposalItem item) {
    this.item = item;
    return this;
  }

  /**
   * Get item
   * @return item
   */
  @Valid 
  @Schema(name = "item", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("item")
  public ItemProposalItem getItem() {
    return item;
  }

  public void setItem(ItemProposalItem item) {
    this.item = item;
  }

  public ItemProposal reason(String reason) {
    this.reason = reason;
    return this;
  }

  /**
   * Reason for the proposal
   * @return reason
   */
  @NotNull @Size(max = 1024) 
  @Schema(name = "reason", example = "DDD und Event Driven Integration werden immer wichtig. Wir sollten ein Framework im Portfolio haben, mit dem wir DDD gut unterstützen können. ", description = "Reason for the proposal", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("reason")
  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public ItemProposal modifiedBy(String modifiedBy) {
    this.modifiedBy = modifiedBy;
    return this;
  }

  /**
   * Who modified the process
   * @return modifiedBy
   */
  @NotNull @Size(max = 64) 
  @Schema(name = "modifiedBy", example = "Max Mustermann (MMA)", description = "Who modified the process", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("modifiedBy")
  public String getModifiedBy() {
    return modifiedBy;
  }

  public void setModifiedBy(String modifiedBy) {
    this.modifiedBy = modifiedBy;
  }

  public ItemProposal emailNotification(String emailNotification) {
    this.emailNotification = emailNotification;
    return this;
  }

  /**
   * Get emailNotification
   * @return emailNotification
   */
  @Size(max = 254) @javax.validation.constraints.Email 
  @Schema(name = "emailNotification", example = "max.mustermann@opitz-consulting.com", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("emailNotification")
  public String getEmailNotification() {
    return emailNotification;
  }

  public void setEmailNotification(String emailNotification) {
    this.emailNotification = emailNotification;
  }

  public ItemProposal ignoreItem(Boolean ignoreItem) {
    this.ignoreItem = ignoreItem;
    return this;
  }

  /**
   * Signals if an item should be ignored instantly
   * @return ignoreItem
   */
  
  @Schema(name = "ignoreItem", description = "Signals if an item should be ignored instantly", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ignoreItem")
  public Boolean getIgnoreItem() {
    return ignoreItem;
  }

  public void setIgnoreItem(Boolean ignoreItem) {
    this.ignoreItem = ignoreItem;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ItemProposal itemProposal = (ItemProposal) o;
    return Objects.equals(this.item, itemProposal.item) &&
        Objects.equals(this.reason, itemProposal.reason) &&
        Objects.equals(this.modifiedBy, itemProposal.modifiedBy) &&
        Objects.equals(this.emailNotification, itemProposal.emailNotification) &&
        Objects.equals(this.ignoreItem, itemProposal.ignoreItem);
  }

  @Override
  public int hashCode() {
    return Objects.hash(item, reason, modifiedBy, emailNotification, ignoreItem);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ItemProposal {\n");
    sb.append("    item: ").append(toIndentedString(item)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    modifiedBy: ").append(toIndentedString(modifiedBy)).append("\n");
    sb.append("    emailNotification: ").append(toIndentedString(emailNotification)).append("\n");
    sb.append("    ignoreItem: ").append(toIndentedString(ignoreItem)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}


package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ItemProposalItem
 */

@JsonTypeName("ItemProposal_item")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-09-13T08:20:36.992431+02:00[Europe/Berlin]", comments = "Generator version: 7.7.0")
public class ItemProposalItem {

  private UUID uuid;

  private String name;

  private String description;

  public ItemProposalItem() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ItemProposalItem(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public ItemProposalItem uuid(UUID uuid) {
    this.uuid = uuid;
    return this;
  }

  /**
   * Get uuid
   * @return uuid
   */
  @Valid 
  @Schema(name = "uuid", example = "570c5538-154a-4d2b-9531-c7a858abd893", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("uuid")
  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public ItemProposalItem name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of Item
   * @return name
   */
  @NotNull @Size(max = 64) 
  @Schema(name = "name", example = "Axon Framework", description = "Name of Item", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ItemProposalItem description(String description) {
    this.description = description;
    return this;
  }

  /**
   * description of item
   * @return description
   */
  @NotNull @Size(max = 1024) 
  @Schema(name = "description", example = "Eine Beschreibung des Items", description = "description of item", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ItemProposalItem itemProposalItem = (ItemProposalItem) o;
    return Objects.equals(this.uuid, itemProposalItem.uuid) &&
        Objects.equals(this.name, itemProposalItem.name) &&
        Objects.equals(this.description, itemProposalItem.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, name, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ItemProposalItem {\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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


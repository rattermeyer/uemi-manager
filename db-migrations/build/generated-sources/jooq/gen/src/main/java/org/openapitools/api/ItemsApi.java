/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.7.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import org.openapitools.model.Error;
import org.openapitools.model.Item;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-09-13T08:20:36.992431+02:00[Europe/Berlin]", comments = "Generator version: 7.7.0")
@Validated
@Tag(name = "Items", description = "the Items API")
public interface ItemsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /items
     * Get a list of all items that have been reviewed.
     *
     * @param itemType Filter items by type (optional)
     * @return Successful operation (status code 200)
     *         or  (status code 400)
     *         or  (status code 404)
     */
    @Operation(
        operationId = "getItems",
        description = "Get a list of all items that have been reviewed.",
        tags = { "Items" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Item.class)))
            }),
            @ApiResponse(responseCode = "400", description = "", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            }),
            @ApiResponse(responseCode = "404", description = "", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/items",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<Item>> getItems(
        @Parameter(name = "itemType", description = "Filter items by type", in = ParameterIn.QUERY) @Valid @RequestParam(value = "itemType", required = false) String itemType
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"itemType\" : \"LIFECYCLE_MANAGED\", \"name\" : \"Axon Framework\", \"description\" : \"Eine Beschreibung des Items\", \"uuid\" : \"570c5538-154a-4d2b-9531-c7a858abd893\" }, { \"itemType\" : \"LIFECYCLE_MANAGED\", \"name\" : \"Axon Framework\", \"description\" : \"Eine Beschreibung des Items\", \"uuid\" : \"570c5538-154a-4d2b-9531-c7a858abd893\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}

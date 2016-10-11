package org.stepio.strings.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.stepio.strings.model.ErrorResponse;
import org.stepio.strings.model.LongestWordPair;
import org.stepio.strings.model.StringsRequest;
import org.stepio.strings.model.StringsResponse;
import org.stepio.strings.sort.StringSorter;

import java.util.List;

/**
 * REST API for sorting strings according to the predefined rules.
 *
 * @author stepio
 */
@Api(description = "REST interface for Strings API")
@RestController
@RequestMapping("/v1/strings")
public class StringsController {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    protected StringSorter sorter;

    /**
     * Reads from JSON collection containing strings, sorts the input strings by the longest word contained in the string and feeds the output into JSON collection formatter,
     * which prints JSON to response body. If there are several words of the same length 'biggest by lexicographical comparison' should be selected among them.
     *
     * @param stringsList   strings to sort
     * @return              top 5 sorted strings
     */
    @ApiOperation(
            value = "Perform sorting of strings",
            notes = "Reads from JSON collection containing strings, sorts the input strings by the longest word contained in the string and feeds the output into JSON collection formatter, " +
                    "which prints JSON to response body. If there are several words of the same length 'biggest by lexicographical comparison' should be selected among them.")
    @RequestMapping(path = "/sort",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> validateResults(@RequestBody StringsRequest stringsList) {
        List<LongestWordPair> sortedList = this.sorter.sort(stringsList.getStrings());
        return ResponseEntity.status(HttpStatus.OK).body(new StringsResponse(sortedList));
    }

    /**
     * Maps {@link IllegalArgumentException} to {@link HttpStatus#BAD_REQUEST} HTTP status code.
     *
     * @param ex    thrown {@link IllegalArgumentException}
     * @return      constructed {@link ResponseEntity}
     */
    @ExceptionHandler
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException ex) {
        this.log.warn("Request validation failed", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(ex.getMessage()));
    }
}

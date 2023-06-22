package com.cource.management.customresponse;

import java.util.HashMap;
import java.util.Map;

public class ResponseMessages {
    public static final Map<String, String> MESSAGE = new HashMap<String, String>() {{

        //success response
        put("SUCCESS", "Success Response");
        put("CREATED", "Data Created");

        //SystemErrors
        put("DATA_NOT_CREATED", "Data Not Created");
        put("DATA_NOT_FOUND", "Data Not Found");
        put("REQUIRED_FIELD", "Required Field");
        put("REQUEST_FAILED", "Json Request Failed");
        put("JSON_PARSE_ERROR", "Json Parse Error");
        put("MAPPING_ERROR", "Mapping Error");
        put("FIELD_ERROR", "Field Error");
        put("JPA_QUERY_EXCEPTION", "JPA/Database Exception");
        put("MODEL_NOT_FOUND", "Data Not Found");
        put("PAGE_NOT_FOUND", "Page Not Found");

        //FrameworkErrors
        put("SERVER_ERROR", "Something Went Wrong please check");
        put("EXCEPTION", "Something Went Wrong.... Check!!!");
        put("RUNTIME_EXCEPTION", "Something Went Wrong");
        put("ILLEGAL_ARGUMENT_EXCEPTION", "Invalid Request");
        put("SERVER_REQUEST_TIMEOUT", "request timeout");
        put("ACCESS_FORBIDDEN_ERROR", "Access forbidden");
        put("SERVICE_UNAVAILABLE", "service unavailable");
        put("ATTRIBUTE_ERROR", "Attribute error");
        put("METHOD_ARGUMENT_NOT_VALID_ERROR", "method argument not valid");
        put("METHOD_ARGUMENT_TYPE_MISMATCH_EXCEPTION", "method argument Type not valid");

        //CustomErrors
        put("UPDATE_FAILED", "Update Failed");
        put("DELETE_FAILED", "Delete Failed");
        put("Course_Not_FoundException", "CourseDto Not Found");
        put("Language_Not_Found_Exception", "Language_Not_Found_Exception");
        put("Writer_Not_Found_Exception", "Writer_Not_Found_Exception");
        put("DEFAULT_ERROR", "An unexpected error occurred. Please try again later or contact support if the issue persists");
    }};
}
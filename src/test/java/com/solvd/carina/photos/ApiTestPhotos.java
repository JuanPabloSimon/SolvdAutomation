package com.solvd.carina.photos;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.carina.demo.api.photos.GetPhotoMethod;
import com.solvd.carina.demo.api.photos.PatchPhotoMethods;
import com.solvd.carina.demo.api.photos.PostPhotoMethods;
import io.restassured.response.Response;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class ApiTestPhotos implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void testGetPhoto() {
        GetPhotoMethod getPhotosMethods = new GetPhotoMethod();
        getPhotosMethods.callAPIExpectSuccess();
        getPhotosMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getPhotosMethods.validateResponseAgainstSchema("api/photos/_get/rs.schema");
    }

    @Test
    public void testPostPhoto() {
        LOGGER.info("TEST POST PHOTO");
        setCases("48659652");
        PostPhotoMethods api = new PostPhotoMethods();
        api.callAPI();
        api.validateResponse();
    }

    @Test
    public void testPostPhotoWithMissingField() {
        LOGGER.info("TEST POST PHOTO, MISSING FIELDS");
        PostPhotoMethods api = new PostPhotoMethods();
        api.getProperties().remove("title");
        api.getProperties().remove("url");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test
    public void testPatchPhoto() {
        LOGGER.info("TEST PATCH");
        setCases("48659652");
        PostPhotoMethods api = new PostPhotoMethods();
        Response r = api.callAPIExpectSuccess();
        api.validateResponse();
        PatchPhotoMethods api2 = new PatchPhotoMethods();
        api2.replaceUrlPlaceholder("id", Integer.toString(r.jsonPath().getInt("id")));
        api2.callAPIExpectSuccess();
        api.validateResponse();
    }
}

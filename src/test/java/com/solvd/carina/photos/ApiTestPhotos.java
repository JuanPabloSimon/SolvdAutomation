package com.solvd.carina.photos;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.APIMethodPoller;
import com.solvd.carina.demo.api.photos.PostPhotoMethods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ApiTestPhotos implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

//    @Test
//    public void TestGetPhoto() {
//        GetPhotoMethod getPhotosMethods = new GetPhotoMethod();
//        getPhotosMethods.callAPIExpectSuccess();
//        getPhotosMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
//        getPhotosMethods.validateResponseAgainstSchema("api/photos/_get/rs.schema");
//    }

    @Test
    public void TestPostPhoto() {
        LOGGER.info("TEST POST PHOTO");
        setCases("48659652");
        PostPhotoMethods api = new PostPhotoMethods();
        AtomicInteger counter = new AtomicInteger(0);

        api.callAPIWithRetry()
                .withLogStrategy(APIMethodPoller.LogStrategy.ALL)
                .peek(rs -> counter.getAndIncrement())
                .until(rs -> counter.get() == 4)
                .pollEvery(1, ChronoUnit.SECONDS)
                .stopAfter(10, ChronoUnit.SECONDS)
                .execute();
        api.validateResponse();
    }
}

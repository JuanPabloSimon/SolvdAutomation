package com.solvd.carina.demo.api.photos;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.env.base_url}/photos", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/photos/_post/rq.json")
@ResponseTemplatePath(path = "api/photos/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class PostPhotoMethods extends AbstractApiMethodV2 {
    public PostPhotoMethods() {
        setProperties("api/photos/photo.properties");
    }
}

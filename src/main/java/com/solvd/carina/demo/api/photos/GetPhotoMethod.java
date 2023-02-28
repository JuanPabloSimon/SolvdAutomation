package com.solvd.carina.demo.api.photos;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;

@Endpoint(url = "https://jsonplaceholder.typicode.com/photos", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/photos/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetPhotoMethod extends AbstractApiMethodV2 {
    public void GetPhotosMethods() {
        // replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}

package com.arjuncode.Springbootlearn.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id = "features")
public class FeatureEndpoint {

    private final Map<String, Feature> featureMap =
            new ConcurrentHashMap<>();

    //this is a constructor
    public FeatureEndpoint() {
        featureMap.put("Department",new Feature(true));
        featureMap.put("User",new Feature(false));
        featureMap.put("Authentication",new Feature(false));
    }

    //this is a get operation so we add @ReadOperation annotation
    @ReadOperation
    public Map<String, Feature> features(){
        return featureMap;
    }
    //this endpoint will return whole map

    @ReadOperation
    public Feature feature(@Selector String featureName){
        return featureMap.get(featureName);
    }
    //this will return only particular feature
    //@selector will select only particular feature

    //Inner class
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Feature{
        private boolean isEnbaled;

    }
}

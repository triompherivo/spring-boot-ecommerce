package com.triompherivo.ecommerce.config;

import com.triompherivo.ecommerce.entity.Product;
import com.triompherivo.ecommerce.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import javax.persistence.Column;
@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        HttpMethod[] theUnsupportedActions = {HttpMethod.PUT,HttpMethod.DELETE,HttpMethod.POST};
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure((metadata,httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metadata,httpMethods) -> httpMethods.disable(theUnsupportedActions));

        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((metadata,httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metadata,httpMethods) -> httpMethods.disable(theUnsupportedActions));




    }
}

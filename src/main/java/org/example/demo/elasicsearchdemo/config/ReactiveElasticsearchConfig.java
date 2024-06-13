package org.example.demo.elasicsearchdemo.config;

import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ReactiveElasticsearchConfiguration;

//@Configuration
public class ReactiveElasticsearchConfig extends ReactiveElasticsearchConfiguration {
    //config crud async
    @Override
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .build();
    }
}

package com.malik.ElasticRESTAPI.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
public class ElasticConfig {

    @Bean
    public TransportClient elasticClient() throws UnknownHostException {
        return new PreBuiltTransportClient(Settings.builder().put("client.transport.ignore_cluster_name", true).build())
                .addTransportAddress(new TransportAddress(InetAddress.getByName("elasticingest01.cluster.ph"), 9300))
                .addTransportAddress(new TransportAddress(InetAddress.getByName("elasticingest02.cluster.ph"), 9300));
    }
}

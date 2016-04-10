package by.bsuir.timetable.desktop;

import org.apache.http.HttpHost;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

//@Component
public class RestTemplateFactory implements FactoryBean<RestTemplate>, InitializingBean {

    @Value("${host}")
    String hostName;

    @Value("${port}")
    int hostPort;

    private RestTemplate restTemplate;

    @Override
    public RestTemplate getObject() {
        return restTemplate;
    }

    @Override
    public Class<RestTemplate> getObjectType() {
        return RestTemplate.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() {
        HttpHost host = new HttpHost(hostName, hostPort, "http");
        restTemplate = new RestTemplate(
                new HttpComponentsClientHttpRequestFactoryBasicAuth(host));
    }
}


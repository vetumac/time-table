package by.bsuir.timetable.desktop;

import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.springframework.web.client.RestTemplate;

public class StatefullRestTemplate extends RestTemplate {
    private final HttpClient httpClient;
    private final CookieStore cookieStore;
    private final HttpContext httpContext;
    private final StatefullHttpComponentsClientHttpRequestFactory statefullHttpComponentsClientHttpRequestFactory;

    public StatefullRestTemplate() {
        super();
        httpClient = HttpClientBuilder.create().build();
        cookieStore = new BasicCookieStore();
        httpContext = new BasicHttpContext();
        httpContext.setAttribute(HttpClientContext.COOKIE_STORE, getCookieStore());
        statefullHttpComponentsClientHttpRequestFactory = new StatefullHttpComponentsClientHttpRequestFactory(httpClient, httpContext);
        super.setRequestFactory(statefullHttpComponentsClientHttpRequestFactory);
    }

    public HttpClient getHttpClient() {
        return httpClient;
    }

    public CookieStore getCookieStore() {
        return cookieStore;
    }

    public HttpContext getHttpContext() {
        return httpContext;
    }

    public StatefullHttpComponentsClientHttpRequestFactory getStatefulHttpClientRequestFactory() {
        return statefullHttpComponentsClientHttpRequestFactory;
    }
}
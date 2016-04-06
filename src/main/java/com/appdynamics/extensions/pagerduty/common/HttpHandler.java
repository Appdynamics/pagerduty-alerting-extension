package com.appdynamics.extensions.pagerduty.common;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.appdynamics.TaskInputArgs;
import com.appdynamics.extensions.http.Response;
import com.appdynamics.extensions.http.SimpleHttpClient;
import com.appdynamics.extensions.pagerduty.Configuration;
import com.google.common.base.Strings;

public class HttpHandler {

    public static final String HTTPS = "https";
    public static final String HTTP = "http";
    public static final String COLON = ":";
    public static final String FORWARD_SLASH = "/";

    final Configuration config;
    private static Logger logger = Logger.getLogger(HttpHandler.class);

    public HttpHandler(Configuration config){
        this.config = config;
    }

    /**
     * Posts the data on VictorOps Endpoint.
     * @param data
     * @return
     */
    public Response postAlert(String data) {
        Map<String, String> httpConfigMap = createHttpConfigMap();
        logger.debug("Building the httpClient");
        SimpleHttpClient simpleHttpClient = SimpleHttpClient.builder(httpConfigMap)
                .connectionTimeout(Integer.parseInt(config.getConnectTimeout()))
                .socketTimeout(Integer.parseInt(config.getSocketTimeout()))
                .build();
        String targetUrl = buildTargetUrl();
        logger.debug("Posting data to VO at " + targetUrl);
        Response response = simpleHttpClient.target(targetUrl)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .post(data);
        logger.debug("HTTP Response status from VO " + response.getStatus());
        return response;
    }


    private Map<String, String> createHttpConfigMap() {
        Map<String,String> map = new HashMap<String, String>();
        if(isSSLEnabled()) {
            map.put("use-ssl", "true");
        }
        if(this.config.getProxy() != null) {
            if (!Strings.isNullOrEmpty(this.config.getProxy().getHost())) {
                map.put(TaskInputArgs.PROXY_HOST, this.config.getProxy().getHost());
            }
            if (!Strings.isNullOrEmpty(this.config.getProxy().getPort())) {
                map.put(TaskInputArgs.PROXY_PORT, this.config.getProxy().getPort());
            }
            if (!Strings.isNullOrEmpty(this.config.getProxy().getUri())) {
                map.put(TaskInputArgs.PROXY_URI, this.config.getProxy().getUri());
            }
            if (!Strings.isNullOrEmpty(this.config.getProxy().getUser())) {
                map.put(TaskInputArgs.PROXY_USER, this.config.getProxy().getUser());
                // Don't put any password if not specified
                if (!Strings.isNullOrEmpty(this.config.getProxy().getPassword())) {
                    map.put(TaskInputArgs.PROXY_PASSWORD, this.config.getProxy().getPassword());
                } else if (!Strings.isNullOrEmpty(this.config.getProxy().getPasswordEncrypted())) {
                    map.put(TaskInputArgs.PROXY_PASSWORD_ENCRYPTED, this.config.getProxy().getPasswordEncrypted());
                }
            }
        }
        return map;
    }

    private boolean isSSLEnabled() {
        return config.getProtocol().equalsIgnoreCase(HTTPS);
    }



    private String buildTargetUrl() {
        StringBuilder sb = new StringBuilder();
        if(isSSLEnabled()){
            sb.append(HTTPS);
        }
        else{
            sb.append(HTTP);
        }
        sb.append(COLON).append(FORWARD_SLASH)
                .append(FORWARD_SLASH)
                .append(config.getHost())
                .append(config.getUrlPath());

        return sb.toString();
    }
}

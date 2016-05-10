/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.raja.niruraji.pa.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.ws.rs.core.MediaType;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.json.JSONObject;

/**
 * 
 * @author Rajaram Kaliyaperumal
 * @since 2016-05-09
 * @version 0.1
 */
public class RestClientApacheHttpClient implements RestClient{
     private final static org.apache.logging.log4j.Logger LOGGER = 
            LogManager.getLogger(RestClientApacheHttpClient.class);

    @Override
    public JSONObject getJSON(String url) throws IllegalArgumentException {
        JSONObject jsonObject  = null; 
        String result = this.getString(url);
        jsonObject = new JSONObject(result);
        return jsonObject;        
    }

    @Override
    public String getString(String url) {
        if (url == null || url.isEmpty()){             
            String errorMsg = "The url can't be NULL or empty";            
            LOGGER.error(errorMsg);            
            throw(new IllegalArgumentException(errorMsg));         
        }
        String result = null;
        try {			
            // create HTTP Client			
            HttpClient httpClient = HttpClientBuilder.create().build(); 			
            // Create new getRequest with below mentioned URL			
            HttpGet getRequest = new HttpGet(url); 			
            // Add additional header to getRequest which accepts application/xml data			
            getRequest.addHeader(HttpHeaders.ACCEPT, 
                    MediaType.APPLICATION_JSON); 			
            // Execute your request and catch response			
            HttpResponse response = httpClient.execute(getRequest); 			
            // Check for HTTP response code: 200 = success			
            if (response.getStatusLine().getStatusCode() != 200) {
                String msg = "API call failed : HTTP error code : " + 
                                response.getStatusLine().getStatusCode();
                LOGGER.warn(msg);
                throw new RuntimeException(msg);			
            }            
            result = EntityUtils.toString(response.getEntity());
        } catch (ClientProtocolException e) {
            String msg = "API call failed : " + e.getMessage();                
            LOGGER.warn(msg);
        } catch (IOException e) {			
            String msg = "Error reading api response : " + e.getMessage();                
            LOGGER.error(msg);
        }
        return result;
    }
    
   
    
}

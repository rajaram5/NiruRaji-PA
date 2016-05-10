/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.raja.niruraji.pa.domain;

import org.json.JSONObject;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rajaram
 */
public class RestClientApacheHttpClientTest {
    
    private final RestClientApacheHttpClient test = 
            new RestClientApacheHttpClient();
    private final String testUrl = 
            "http://buienradar.nl/json/Places?term=utrecht";
    private final String testJsonUrl = 
            "http://buienradar.nl/Json/GetTwentyFourHourForecast?"
            + "geolocationid=2751773";
    
    public RestClientApacheHttpClientTest() {
    }
    
    /**
     * Test of getString method, null url.
     */
    @Test(expected = IllegalArgumentException.class)
    public void nullURL() {
        System.out.println("getString");
        test.getString(null);
        fail("The test is excepted to throw exeception");
    }
    
    /**
     * Test of getString method, empty url.
     */
    @Test(expected = IllegalArgumentException.class)
    public void emptyURL() {
        System.out.println("getString");
        test.getString("");
        fail("The test is excepted to throw exeception");
    }
    
    /**
     * Test of getString method, invalid url.
     */
    @Test
    public void invalidURL() {
        System.out.println("getString");
        String result = test.getString("blabla");
        assertNull(result);
    }

    /**
     * Test of getString method, valid url.
     */
    @Test
    public void validURL() {
        System.out.println("getString");
        String result = test.getString(testUrl);
        assertNotNull(result);
    }
    
    /**
     * Test of getJSON method, valid json url.
     */
    @Test
    public void validJsonURL() {
        System.out.println("getJSON");
        JSONObject result = test.getJSON(testJsonUrl);
        assertNotNull(result);
    }
    
}

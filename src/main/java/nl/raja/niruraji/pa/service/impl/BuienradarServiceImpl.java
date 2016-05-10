/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.raja.niruraji.pa.service.impl;

import java.util.ArrayList;
import java.util.List;
import nl.raja.niruraji.pa.Forecast;
import nl.raja.niruraji.pa.Location;
import nl.raja.niruraji.pa.domain.RestClient;
import nl.raja.niruraji.pa.domain.RestClientApacheHttpClient;
import nl.raja.niruraji.pa.service.BuienradarService;
import org.apache.logging.log4j.LogManager;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * 
 * @author Rajaram Kaliyaperumal
 * @since 2016-05-09
 * @version 0.1
 */
public class BuienradarServiceImpl implements BuienradarService{
    
    private RestClient restClient = new RestClientApacheHttpClient();
    private final static org.apache.logging.log4j.Logger LOGGER = 
            LogManager.getLogger(BuienradarServiceImpl.class);

    @Override
    public List<Location> getLocation(String locationTerm) throws 
            IllegalArgumentException {
        if (locationTerm == null || locationTerm.isEmpty()){             
            String errorMsg = "The locationTerm can't be NULL or empty";            
            LOGGER.error(errorMsg);            
            throw(new IllegalArgumentException(errorMsg));         
        }
        List<Location> locations = new ArrayList();
        String url = "http://buienradar.nl/json/Places?term=" + locationTerm;
        String response = restClient.getString(url);
        if (response != null || !response.isEmpty()) {
            if ((response.charAt(0) == '[') && 
                    (response.charAt((response.length() -1)) == ']')) {
                response = "{ \"results\":" + response + "}" ;
            } 
            JSONObject result = new JSONObject(response);
            JSONArray resultRows = (JSONArray)result.get("results");
            for (int i =0; i <resultRows.length(); i++) {                 
                JSONObject objects = resultRows.getJSONObject(i);                
                JSONObject geolocation = (JSONObject)objects.get("location");
                Location location = new Location();
                location.setId(objects.get("id").toString());
                location.setAsciiname(objects.get("asciiname").toString());
                location.setCountry(objects.get("country").toString());
                location.setCountryCode(objects.get("countrycode").toString());
                location.setName(objects.get("name").toString());
                location.setLatitude(geolocation.get("lat").toString());
                location.setLongitude(geolocation.get("lon").toString());
                locations.add(location);
            }
            
            
        }
        return locations;
    }

    @Override
    public boolean isItRaining(String locationID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isItSunny(String locationID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Forecast nextThreeHoursForecast(String locationID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

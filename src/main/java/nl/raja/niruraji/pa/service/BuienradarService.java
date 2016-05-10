/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.raja.niruraji.pa.service;

import nl.raja.niruraji.pa.Location;
import nl.raja.niruraji.pa.Forecast;
import java.util.List;

/**
 * 
 * @author Rajaram Kaliyaperumal
 * @since 2016-05-09
 * @version 0.1
 */
public interface BuienradarService {
    public List<Location> getLocation(String locationTerm);
    public boolean isItRaining(String locationID);
    public boolean isItSunny(String locationID);
    public Forecast nextThreeHoursForecast(String locationID);
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.raja.niruraji.pa.domain;

import org.json.JSONObject;

/**
 * 
 * @author Rajaram Kaliyaperumal
 * @since 2016-05-09
 * @version 0.1
 */
public interface RestClient {
    
    public JSONObject getJSON(String url);
    public String getString(String url);
    
}

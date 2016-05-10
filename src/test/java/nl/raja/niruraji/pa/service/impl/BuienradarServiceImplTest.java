/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.raja.niruraji.pa.service.impl;

import java.util.List;
import nl.raja.niruraji.pa.Forecast;
import nl.raja.niruraji.pa.Location;
import nl.raja.niruraji.pa.service.BuienradarService;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rajaram
 */
public class BuienradarServiceImplTest {
    
    private final BuienradarService test = new BuienradarServiceImpl();
    private final String testLocationTerm = "utrecht";
    
    public BuienradarServiceImplTest() {
    }
    
    /**
     * Test of getLocation method, for null LocationTerm.
     */
    @Test(expected = IllegalArgumentException.class)
    public void nullLocationTerm() {
        System.out.println("getLocation");
        test.getLocation(null);
        fail("The test is excepted to throw exeception");
    }
    
    /**
     * Test of getLocation method, for empty LocationTerm.
     */
    @Test(expected = IllegalArgumentException.class)
    public void emptyLocationTerm() {
        System.out.println("getLocation");
        test.getLocation(null);
        fail("The test is excepted to throw exeception");
    }

    /**
     * Test of getLocation method, for valid LocationTerm.
     */
    @Test
    public void validLocationTerm() {
        System.out.println("getLocation");
        List<Location> result = test.getLocation(testLocationTerm);
        assertEquals(3, result.size());
    }

    /**
     * Test of isItRaining method, of class BuienradarServiceImpl.
     */
    @Test
    public void testIsItRaining() {
        System.out.println("isItRaining");
        String locationID = "";
        BuienradarServiceImpl instance = new BuienradarServiceImpl();
        boolean expResult = false;
        boolean result = instance.isItRaining(locationID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isItSunny method, of class BuienradarServiceImpl.
     */
    @Test
    public void testIsItSunny() {
        System.out.println("isItSunny");
        String locationID = "";
        BuienradarServiceImpl instance = new BuienradarServiceImpl();
        boolean expResult = false;
        boolean result = instance.isItSunny(locationID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nextThreeHoursForecast method, of class BuienradarServiceImpl.
     */
    @Test
    public void testNextThreeHoursForecast() {
        System.out.println("nextThreeHoursForecast");
        String locationID = "";
        BuienradarServiceImpl instance = new BuienradarServiceImpl();
        Forecast expResult = null;
        Forecast result = instance.nextThreeHoursForecast(locationID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

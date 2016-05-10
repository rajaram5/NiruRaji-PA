/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.raja.niruraji.pa.domain;

/**
 *
 * @author rajaram
 */
public class RestClientExeception extends Exception {

    /**
     * Creates a new instance of <code>RestClientExeception</code> without
     * detail message.
     */
    public RestClientExeception() {
    }

    /**
     * Constructs an instance of <code>RestClientExeception</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public RestClientExeception(String msg) {
        super(msg);
    }
}

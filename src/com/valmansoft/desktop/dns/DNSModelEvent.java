/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valmansoft.desktop.dns;

/**
 *
 * @author val
 */
public class DNSModelEvent {
    private String newIp;

    public DNSModelEvent() {
    }

    public DNSModelEvent(String newIp) {
        this.newIp = newIp;
    }

    public String getNewIp() {
        return newIp;
    }

    public void setNewIp(String newIp) {
        this.newIp = newIp;
    }
    
}

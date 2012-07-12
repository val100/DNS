/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.valmansoft.desktop.dns;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author val
 */
public class DNSModel {
    private String ipHostInput;
    private String ipHostOutput;
    
    private List<DNSModelListener> listeners;

    public DNSModel() {
        listeners = new ArrayList<DNSModelListener>();
    }

    public String getIp() {
        return ipHostInput;
    }

    public void setIp(String ip) {
        this.ipHostInput = ip;
        fireIpChanged(new DNSModelEvent(ip));
    }

    public String getIpHostInput() {
        return ipHostInput;
    }

    public void setIpHostInput(String ipHostInput) {
        this.ipHostInput = ipHostInput;
        fireIpChanged(new DNSModelEvent(ipHostInput));
    }

    public String getIpHostOutput() {
        return ipHostOutput;
    }

    public void setIpHostOutput(String ipHostOutput) {
        this.ipHostOutput = ipHostOutput;
        fireIpChanged(new DNSModelEvent(ipHostOutput));
    }
    
    
    
    public void addDNSModelListener(DNSModelListener listener) {
        listeners.add(listener);
    }
    public void removeDNSModelListener(DNSModelListener listener) {
        listeners.remove(listener);
    }
    
    public void fireIpChanged(DNSModelEvent event) {
        for(DNSModelListener dnsml:listeners) {
            dnsml.ipChanged(event);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itinerario.security;

import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author Sandersoon
 */
public class GrantedAuthorityImpl implements GrantedAuthority{
    
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String getAuthority() {
       return this.name;
    }
    
}

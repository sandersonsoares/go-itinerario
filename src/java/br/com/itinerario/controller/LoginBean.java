/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itinerario.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Sanderson
 */
@ManagedBean
@RequestScoped
public class LoginBean extends DefaultBean {

    public void mostrarErro(String erro) {
        if (erro.equalsIgnoreCase("erro")) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email ou Senha Inválidos", null));
        }
    }

}

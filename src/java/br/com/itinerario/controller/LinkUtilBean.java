package br.com.itinerario.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class LinkUtilBean {

    private static final String FACES_REDIRECT = "?faces-redirect=true";

    public String login() {
        return "/index.xhtml" + FACES_REDIRECT;
    }

    public String home() {
        return "/privado/index.xhtml" + FACES_REDIRECT;
    }

    public String formularioCursos(Long id) {
        final String link = "/privado/academico/cursos/formulario.xhtml" + FACES_REDIRECT;
        if (id == null) {
            return link;
        } else {
            return link + "&id=" + id;
        }
    }

    public String novoPassageiro() {
        return "/privado/passageiros/formulario.xhtml" + FACES_REDIRECT;
    }

    public String novoVeiculo() {
        return "/privado/veiculo/formulario.xhtml" + FACES_REDIRECT;
    }
    
    public String novoGrupo() {
        return "/privado/grupos/formulario.xhtml" + FACES_REDIRECT;
    }

    public String listaVeiculos() {
        return "/privado/veiculo/lista.xhtml" + FACES_REDIRECT;
    }
    
    public String listaPassageiros() {
        return "/privado/passageiros/lista.xhtml" + FACES_REDIRECT;
    }
    
    public String paginaPrincipal() {
        return "/privado/principal.xhtml" + FACES_REDIRECT;
    }
}

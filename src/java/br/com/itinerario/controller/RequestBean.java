package br.com.itinerario.controller;


import br.com.itinerario.facade.Facade;
import br.com.itinerario.model.Usuario;
import br.com.itinerario.security.RequestWrapper;
import java.util.Map;
import java.util.TreeMap;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Sandersoon
 */
@ManagedBean
@RequestScoped
public class RequestBean extends DefaultBean {
    
    private String user;
    private String senha;
    private Facade fachada;
    
    public String login() {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext extenalContext = facesContext.getExternalContext();
            HttpServletRequest request = (HttpServletRequest) extenalContext.getRequest();
            String[] usuario = {user};
            String[] password = {senha};
            Map<String, String[]> modifiableParameters = new TreeMap<String, String[]>();
            modifiableParameters.put("j_username", usuario);
            modifiableParameters.put("j_password", password);
            RequestWrapper wrapper = new RequestWrapper(request, modifiableParameters);
            RequestDispatcher dispatcher = ((ServletRequest) extenalContext.getRequest()).getRequestDispatcher("/j_spring_security_check");
            dispatcher.forward(wrapper, (ServletResponse) extenalContext.getResponse());
            facesContext.responseComplete();
        } catch (Exception e) {
            imprimirErro(e.getMessage());
        }
        return null;
    }
    
    public String logout() {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext extenalContext = facesContext.getExternalContext();
            RequestDispatcher dispatcher = ((ServletRequest) extenalContext
                    .getRequest())
                    .getRequestDispatcher("/j_spring_security_logout");
            dispatcher.forward((ServletRequest) extenalContext.getRequest(),
                    (ServletResponse) extenalContext.getResponse());
            facesContext.responseComplete();
            return this.linkBean.home();
        } catch (Exception e) {
            imprimirErro(e.getMessage());
        }
        return null;
    }
    
    public Usuario getUsuarioLogado() {
        fachada = new Facade();
        Object usuarioLogado = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (usuarioLogado instanceof UserDetails) {
            username = ((UserDetails) usuarioLogado).getUsername();
        } else {
            username = usuarioLogado.toString();
        }
        
        return fachada.logarUsuario(username);
    }
    
    public boolean isUserRoles(String role) {
        return FacesContext.getCurrentInstance().getExternalContext().isUserInRole(role);
    }
    
    public String getUser() {
        return user;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setUser(String user) {
        this.user = user;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import br.com.itinerario.enums.Permissoes;
import br.com.itinerario.enums.Sexo;
import br.com.itinerario.facade.Facade;
import br.com.itinerario.model.Grupo;
import br.com.itinerario.model.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sanderson
 */
public class Main {

    public static void main(String[] args) {
        
        Usuario user = new Usuario();
        user.setCpf("888.888.888-88");
        user.setDataNascimento(new Date());
        user.setEmail("admin@admin.com");
        
        List<Permissoes> permissoes = new ArrayList<>();
        for (Permissoes p : Permissoes.values()) {
            permissoes.add(p);
        }
        
        Grupo gp = new Grupo();
        gp.setTitulo("Administradores");
        gp.setPermissoes(permissoes);
        
        user.setGrupo(gp);
        user.setNome("Administrador");
        user.setSenha("admin");
        user.setSexo(Sexo.MASCULINO);
        user.setTelefone("(83) 9999-9999");
        user.setStatus(true);
        user.setUsername("admin");
        
        Facade fachada = new Facade();
        try {
            fachada.cadastrarUsuario(user);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

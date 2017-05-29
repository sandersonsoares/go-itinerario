/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itinerario.security;

import br.com.itinerario.enums.Permissoes;
import br.com.itinerario.facade.Facade;
import br.com.itinerario.model.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author Sandersoon e Gernan =D
 */
public class UserDetailServiceImpl implements UserDetailsService {

    private Facade fachada;

    public UserDetailServiceImpl() {
        this.fachada = new Facade();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = fachada.logarUsuario(username);

        if (username.equals(usuario.getUsername()) || username.equalsIgnoreCase(usuario.getEmail())) {
            UserDetailImpl user = new UserDetailImpl();
            user.setUsername(username);
            user.setPassword(usuario.getSenha());
            user.setStatus(true);
            for (Permissoes perm : usuario.getGrupo().getPermissoes()) {
                user.addAuthority(perm.name());
            }
            return user;
        }
        throw new UsernameNotFoundException("Usuário inválido!");
    }

}

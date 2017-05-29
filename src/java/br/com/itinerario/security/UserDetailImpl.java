package br.com.itinerario.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Sandersoon
 */
public class UserDetailImpl implements UserDetails {

    private String username;
    private String password;
    private boolean status;
    private List<GrantedAuthorityImpl> authorities;

    public void setUsername(String userName) {
        this.username = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(ArrayList<GrantedAuthorityImpl> authorities) {
        this.authorities = authorities;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void addAuthority(String authorityName) {
        if (this.authorities == null) {
            authorities = new ArrayList<>();
        }
        GrantedAuthorityImpl aut = new GrantedAuthorityImpl();
        aut.setName(authorityName);
        authorities.add(aut);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}

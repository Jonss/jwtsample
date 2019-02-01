package jupiterstein.com.jwtsample.security;

import jupiterstein.com.jwtsample.models.Profile;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class UserSpringSecurity implements UserDetails {

    private Long id;
    private String password;
    private String email;
    private Collection<? extends GrantedAuthority> authorities;

    public UserSpringSecurity(Long id, String password, String email, Set<Profile> profiles) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.authorities = profiles.stream().map(x -> new SimpleGrantedAuthority(x.getRole_customer())).collect(Collectors.toSet());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
         return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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

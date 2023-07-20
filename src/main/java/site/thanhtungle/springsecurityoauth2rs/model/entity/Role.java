package site.thanhtungle.springsecurityoauth2rs.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "roles")
@AllArgsConstructor
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private long roleId;

    private String authority;

    public Role() {
        super();
    }

    public Role(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }
}

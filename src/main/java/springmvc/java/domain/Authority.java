package springmvc.java.domain;

import javax.persistence.*;

/**
 * Created by ziga on 11/24/16.
 */

@Entity
@Table(name="authorities")
public class Authority {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id",unique = true,nullable = false)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "authority", nullable = false)
    private String authority;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
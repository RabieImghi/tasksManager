    package org.example.taskmanager.entity;
    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;
    import org.example.taskmanager.util.Manage;
    import org.mindrot.jbcrypt.BCrypt;

    import java.io.Serializable;

    @Entity
    @Table(name = "users")
    @Data
    public class User implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "username", nullable = false, unique = true)
        private String username;

        @Column(name = "firstname", nullable = false)
        private String firstname;

        @Column(name = "lastname", nullable = false)
        private String lastname;

        @Column(name = "password", nullable = false)
        private String password;

        @Column(name = "email", nullable = false, unique = true)
        private String email;

        @Enumerated(EnumType.STRING)
        @Column(name = "manage")
        private Manage manage;

        private int token = 2;

        public User(String username, String firstname, String lastname, String password, String email, Manage manage) {
            this.username = username;
            this.firstname = firstname;
            this.lastname = lastname;
            this.password = hashPassword(password);
            this.email = email;
            this.manage = manage;
        }
        private String hashPassword(String password) {
            return BCrypt.hashpw(password, BCrypt.gensalt());
        }
        public User() {}
    }
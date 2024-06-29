package proBarber.proBarber.model;


import jakarta.persistence.*;

@Entity
public class Usuario{

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private long id;


    @Column(
            name = "Usuario", length = 50
    )
    private String Usuario;
    @Column(
            name = "Senha", length = 50
    )
    private String Senha;
    @Column(
            name = "Nome", length = 50
    )
    private String Nome;
    @Column(
            name = "Email", length = 50
    )
    private String Email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
package br.com.erudio.data.vo.v1.security;
// MODIFIQUEI AQUI
import java.io.Serializable;
import java.util.Objects;

public class AccountCredentialsVO implements Serializable{

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;

    private String permissao;

    public AccountCredentialsVO() {}

    public AccountCredentialsVO(String username, String password,String permissao ) {
        this.username = username;
        this.password = password;
        this.permissao = permissao;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountCredentialsVO that = (AccountCredentialsVO) o;

        if (!Objects.equals(username, that.username)) return false;
        if (!Objects.equals(password, that.password)) return false;
        return Objects.equals(permissao, that.permissao);
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (permissao != null ? permissao.hashCode() : 0);
        return result;
    }
}
package br.com.erudio.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonPropertyOrder({"id", "userName", "fullName", "password"})
public class UserVO extends RepresentationModel<UserVO> implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	@Mapping("id")
	private Long key;
	private String userName;
	private String fullName;
	private String password;

	private Boolean accountNonExpired;

	private Boolean accountNonLocked;

	private Boolean credentialsNonExpired;

	private Boolean enabled;

	private String permissao;


	public UserVO() {}

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {

		return password;
	}

	public void setPassword(String password) {


		Map<String, PasswordEncoder> encoders = new HashMap<>();
		encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
		DelegatingPasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("pbkdf2", encoders);
		passwordEncoder.setDefaultPasswordEncoderForMatches(new Pbkdf2PasswordEncoder());

		String result = passwordEncoder.encode(password);

		String senha = result.replace("{pbkdf2}", "");

		this.password = senha;
	}

	public Boolean getAccountNonExpired() {
		return Boolean.TRUE;
	}

	public void setAccountNonExpired(Boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public Boolean getAccountNonLocked() {
		return  Boolean.TRUE;
	}

	public void setAccountNonLocked(Boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public Boolean getCredentialsNonExpired() {
		return  Boolean.TRUE;
	}

	public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public Boolean getEnabled() {
		return  Boolean.TRUE;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
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
		if (!super.equals(o)) return false;

		UserVO userVO = (UserVO) o;

		if (!Objects.equals(key, userVO.key)) return false;
		if (!Objects.equals(userName, userVO.userName)) return false;
		if (!Objects.equals(fullName, userVO.fullName)) return false;
		if (!Objects.equals(password, userVO.password)) return false;
		if (!Objects.equals(accountNonExpired, userVO.accountNonExpired))
			return false;
		if (!Objects.equals(accountNonLocked, userVO.accountNonLocked))
			return false;
		if (!Objects.equals(credentialsNonExpired, userVO.credentialsNonExpired))
			return false;
		if (!Objects.equals(enabled, userVO.enabled)) return false;
		return Objects.equals(permissao, userVO.permissao);
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (key != null ? key.hashCode() : 0);
		result = 31 * result + (userName != null ? userName.hashCode() : 0);
		result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
		result = 31 * result + (password != null ? password.hashCode() : 0);
		result = 31 * result + (accountNonExpired != null ? accountNonExpired.hashCode() : 0);
		result = 31 * result + (accountNonLocked != null ? accountNonLocked.hashCode() : 0);
		result = 31 * result + (credentialsNonExpired != null ? credentialsNonExpired.hashCode() : 0);
		result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
		result = 31 * result + (permissao != null ? permissao.hashCode() : 0);
		return result;
	}
}
package br.com.erudio.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "products")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 180)
	private String name;

	@Column(nullable = false, length = 250)
	private String description;

	@Column(name = "purchase_price", nullable = false)
	private Double purchasePrice;

	@Column(name = "selling_price", nullable = false)
	private Double sellingPrice;

	@Column(nullable = false)
	private Long quantity;

	@Column(name = "enabled")
	private Boolean enabled;

	public Product() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Product product = (Product) o;

		if (!Objects.equals(id, product.id)) return false;
		if (!Objects.equals(name, product.name)) return false;
		if (!Objects.equals(description, product.description)) return false;
		if (!Objects.equals(purchasePrice, product.purchasePrice))
			return false;
		if (!Objects.equals(sellingPrice, product.sellingPrice))
			return false;
		if (!Objects.equals(quantity, product.quantity)) return false;
		return Objects.equals(enabled, product.enabled);
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + (purchasePrice != null ? purchasePrice.hashCode() : 0);
		result = 31 * result + (sellingPrice != null ? sellingPrice.hashCode() : 0);
		result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
		result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
		return result;
	}
}
package br.com.erudio.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({"id", "author", "launchDate", "price", "title"})
public class ProductVO extends RepresentationModel<ProductVO> implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	@Mapping("id")
	private Long key;
	private String name;
	private String description;
	private Double purchasePrice;
	private Double sellingPrice;
	private Long quantity;
	private Boolean enabled;

	public ProductVO() {}

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
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
		if (!super.equals(o)) return false;

		ProductVO productVO = (ProductVO) o;

		if (!Objects.equals(key, productVO.key)) return false;
		if (!Objects.equals(name, productVO.name)) return false;
		if (!Objects.equals(description, productVO.description))
			return false;
		if (!Objects.equals(purchasePrice, productVO.purchasePrice))
			return false;
		if (!Objects.equals(sellingPrice, productVO.sellingPrice))
			return false;
		if (!Objects.equals(quantity, productVO.quantity)) return false;
		return Objects.equals(enabled, productVO.enabled);
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (key != null ? key.hashCode() : 0);
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + (purchasePrice != null ? purchasePrice.hashCode() : 0);
		result = 31 * result + (sellingPrice != null ? sellingPrice.hashCode() : 0);
		result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
		result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
		return result;
	}
}
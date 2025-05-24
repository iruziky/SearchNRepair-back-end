package app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Smartphone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String link;
    private String title;
    private String price;
    private String category;
    private String brand;
    private String model;
    private String condition;
    private String memory;
    private String color;
    private String batteryLife;
    @Column(columnDefinition = "boolean default false")
    private boolean isBreak = false;
    
    @Lob
    @Column
    private String description;
    
    @Lob
    @Column
    private String images;

	@Override
	public String toString() {
	    return "Smartphone{" +
	           "id=" + id +
	           ", link='" + link + '\'' +
	           ", title='" + title + '\'' +
	           ", price=" + price +
	           ", category='" + category + '\'' +
	           ", brand='" + brand + '\'' +
	           ", model='" + model + '\'' +
	           ", condition='" + condition + '\'' +
	           ", memory='" + memory + '\'' +
	           ", color='" + color + '\'' +
	           ", batteryLife='" + batteryLife + '\'' +
	           ", description='" + description + '\'' +
	           ", images='" + images + '\'' +
	           ", isBreak='" + isBreak + '\'' +
	           '}';
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBatteryLife() {
		return batteryLife;
	}

	public void setBatteryLife(String batteryLife) {
		this.batteryLife = batteryLife;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}
	
	public boolean isBreak() {
		return isBreak;
	}

	public void setBreak(boolean isBreak) {
		this.isBreak = isBreak;
	}
}

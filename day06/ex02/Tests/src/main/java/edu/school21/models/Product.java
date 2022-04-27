package edu.school21.models;

import java.util.Objects;

public class Product {
	int id;
	String name;
	int price;
	public Product(int id, String name, int price){
		this.id = id;
		this.name = name;
		this.price = price;
	}
	@Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
	@Override
	public boolean equals(Object o) {
		// return true;
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Product product = (Product) o;
		return (price == product.price) && (id == product.id) && (name.equals(product.name));
	}

@Override
public int hashCode() {
    return Objects.hash(id, name, price);
}




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
	
}

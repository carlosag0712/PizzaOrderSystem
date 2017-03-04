package com.amandaprettypizza.enums;

public enum PizzaCrustEnum 
{
	
	THIN("thin", 0.0),
	REGULAR("regular", 0.0),
	THICK("thick", 0.0),
	GLUTEN_FREE("gluten free", 3.0),
	AMANDA_CLAPHAM_BUTT_THICK("Amanda-Clapham-Butt thick", 10.0);
	
	private String description;
	private Double price;
	
	private PizzaCrustEnum(String description, Double price)
	{
		this.description = description;
		this.price = price;
		
	}

	public String getDescription() {
		return description;
	}

	public Double getPrice() {
		return price;
	}
	
	

}

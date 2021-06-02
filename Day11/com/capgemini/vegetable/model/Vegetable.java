package com.capgemini.vegetable.model;

public class Vegetable implements Comparable<Vegetable>{

	private Integer vegId;
	private String vegName;
	private Float vegPrice;
	
	//default constructor
	public Vegetable() {
		super();
	}
	
	//Parameterized constructor
	public Vegetable(int vegId, String vegName, Float vegPrice) {
		super();
		this.vegId = vegId;
		this.vegName = vegName;
		this.vegPrice = vegPrice;
	}

	@Override
	public int compareTo(Vegetable veg) {
		// TODO Auto-generated method stub
		return vegPrice.compareTo(veg.vegPrice);
	}

	public Integer getVegId() {
		return vegId;
	}

	public void setVegId(Integer vegId) {
		this.vegId = vegId;
	}

	public String getVegName() {
		return vegName;
	}

	public void setVegName(String vegName) {
		this.vegName = vegName;
	}

	public Float getVegPrice() {
		return vegPrice;
	}

	public void setVegPrice(Float vegPrice) {
		this.vegPrice = vegPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vegId == null) ? 0 : vegId.hashCode());
		result = prime * result + ((vegName == null) ? 0 : vegName.hashCode());
		result = prime * result + ((vegPrice == null) ? 0 : vegPrice.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vegetable other = (Vegetable) obj;
		if (vegId == null) {
			if (other.vegId != null)
				return false;
		} else if (!vegId.equals(other.vegId))
			return false;
		if (vegName == null) {
			if (other.vegName != null)
				return false;
		} else if (!vegName.equals(other.vegName))
			return false;
		if (vegPrice == null) {
			if (other.vegPrice != null)
				return false;
		} else if (!vegPrice.equals(other.vegPrice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vegetable Id : " + vegId + ", Name : " + vegName + ", Price : " + vegPrice;
	}
	

}

package com.capgemini.vegetable.model;

import java.util.Comparator;

public class VegetableComparatorByPrice implements Comparator<Vegetable>{

	@Override
	public int compare(Vegetable v1, Vegetable v2) {
		// TODO Auto-generated method stub
		if(v1.getVegPrice()==v2.getVegPrice())
			return 0;
		if(v1.getVegPrice()>v2.getVegPrice())
			return 1;
		return -1;
	}

}

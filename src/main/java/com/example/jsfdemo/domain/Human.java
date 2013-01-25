package com.example.jsfdemo.domain;

import java.util.List;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
public class Human {

	private String Name = "unknown";
	private String Pesel = "";

	@Size(min = 2, max = 20)
	public String getName() {
		return Name;
	}



	public void setName(String Name) {
		this.Name = Name;
	}

	@Pattern(regexp = "[0-9]")
	public String getPesel() {
		return Pesel;
	}
	public void setPesel(String Pesel) {
		this.Pesel = Pesel;
	}
	public void setWrappedData(List<Human> allHumans) {


	}



}



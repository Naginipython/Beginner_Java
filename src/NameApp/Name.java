package NameApp;/*
 * Name: Benjamin McCann
 * Date: 11/04/2020
 * Course Number: CSC-220
 * Course Name: Data Structures and Algorithms
 * Problem Number: Chapter 13 HW
 * Email: bnmccann0001@student.stcc.edu
 * Create a Names class that takes a Name, Sex, and how many of that name there are. Created an equals class, compareTo, toString, and 
 * addToNumber methods.
 */

public class Name implements Comparable<Name> {
	private String name;
	private String sex;
	private int number;
	
	public Name(String name, String sex, int number)
		      throws NameAppException {
		this.setName(name);
		this.setSex(sex);
		this.setNumber(number);
	}
	
	//getters
	public String getName() {
		return name;
	}
	public String getSex() {
		return sex;
	}
	public int getNumber() {
		return number;
	}
	
	//setters
	public void setName(String name) throws NameAppException {
		if (name == null || name.trim().equals(""))
			throw new NameAppException("Blank name setting attempted");
		this.name = name;
	}
	public void setSex(String sex) throws NameAppException {
		if (sex.equals("M") || sex.equals("F"))
			this.sex = sex;
		else 
			throw new NameAppException("Sex has to be M or F");
		
	}
	public void setNumber(int number) throws NameAppException {
		if (number < 0)
			throw new NameAppException("Number can't be less than 1");
		this.number = number;
	}
	
	//methods
	public void addToNumber(int num) {
		if (num > 0)
			this.number += num;
	}
	
	public int compareTo (Name b) {
		//If number is Positive, its bigger. Negative, its smaller. 0 is the same.
		Name a = this;
		return a.getNumber() - b.getNumber();
	}
	
	public String toString() {
		return "Name:"+name+"; Sex:"+sex+"; Number:"+number;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		
		Name b = (Name) obj;
		if (!name.equals(b.getName()))
				return false;
		if (!sex.equals(b.getSex()))
			return false;
		return true;
	}
}
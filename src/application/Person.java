package application;

import java.util.Date;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Person {

	Person(){}
	private int pin;
	
	private String firstName;
	
	private String phoneNum;
	
	private Date bDay;
	
	private String email;
	
	private String address;
	
	private String creditCard;
	
	private String lastName;
	
	
	Person(int pinn,String lastname, String firstname, String CreditCard , String phone, Date b_Day, String adress){
		pin=pinn;
		firstName=firstname;
		lastName = lastname;
		phoneNum=phone;
		bDay = b_Day;
		email = null;//to be fixed later
		address = adress;
		creditCard=CreditCard;
		
	}


	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}


	public void setbDay(Date bDay) {
		this.bDay = bDay;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFirstName() {
		return firstName;
	}


	public String getPhoneNum() {
		return phoneNum;
	}


	public Date getbDay() {
		return bDay;
	}


	public String getEmail() {
		return email;
	}


	public String getAddress() {
		return address;
	}


	public String getCreditCard() {
		return creditCard;
	}


	public String getLastName() {
		return lastName;
	}
	

}

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

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Date getbDay() {
		return bDay;
	}
	public void setbDay(Date bDay) {
		this.bDay = bDay;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}

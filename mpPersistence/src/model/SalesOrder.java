package model;

import java.time.LocalDate;

/**
 *  @author (Nicklas)
 **/
public class SalesOrder {

	private int orderNo;
	private LocalDate deliveryDate;
	private boolean deliveryStatus;
	private double totalPrice;
	private String deliveryNote;
	private LocalDate date;
	
	//Constructor
	public SalesOrder(int orderNo, LocalDate deliveryDate,
			boolean deliveryStatus, double totalPrice, String deliveryNote, 
			LocalDate date) {
		//Initialization of instance variables
		this.orderNo = orderNo;
		this.deliveryDate = deliveryDate;
		this.deliveryStatus = deliveryStatus;
		this.totalPrice = totalPrice;
		this.deliveryNote = deliveryNote;
		this.date = date;
	}
	
	//Setters and getters
	public void setOrderNo(int newOrderNo) {
		this.orderNo = newOrderNo;
	}
	
	public void setDeliveryDate(LocalDate newDeliveryDate) {
		this.deliveryDate = newDeliveryDate;
	}
	
	public void setDeliveryStatus(boolean newDeliveryStatus) {
		this.deliveryStatus = newDeliveryStatus;
	}
	
	public void setTotalPrice(double newTotalPrice) {
		this.totalPrice = newTotalPrice;
	}
	
	public void setDeliveryNote( String newDeliveryNote) {
		this.deliveryNote = newDeliveryNote;
	}
	
	public void setDate(LocalDate newDate) {
		this.date = newDate;
	}
	public int getOrderNo(){
		return orderNo;
	}
	
	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}
	
	public boolean getDeliveryStatus(){
		return deliveryStatus;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}
	
	public String getDeliveryNote() {
		return deliveryNote;
	}
	
	public LocalDate getDate() {
		return date;
	}
}



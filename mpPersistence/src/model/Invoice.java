package model;

/**
 * @author (Mikal)
 **/

public class Invoice {

	private int invoiceNo;
	private int paymentDate;
	private int amount;
	
	// constructor
	public Invoice(int invoiceNo, int paymentDate, int amount) {
		this.invoiceNo = invoiceNo;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}
	
	// getters
	public int getInvoiceNo() {
		return invoiceNo;
	}
	public int getPaymentDate() {
		return paymentDate;
	}
	public int getAmount() {
		return amount;
	}
	
	// setters
	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public void setPaymentDate(int paymentDate) {
		this.paymentDate = paymentDate;
	}
	public void setAmount (int amount) {
		this.amount = amount;
	}
}

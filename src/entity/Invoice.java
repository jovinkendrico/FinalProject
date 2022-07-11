package entity;

import java.time.LocalDate;

public class Invoice {
    private String invoiceId;
    private Employee employee;
    private Customer customer;
    private LocalDate localDate;
    private double totalPrice;
    private double tax;
    private double discount;
    private double totalPay;
    private double paid;
    private double returned;

    public Invoice(String invoiceId, Employee employee, Customer customer, int year, int month, int dayOfMonth, double totalPrice, double tax, double discount, double totalPay, double paid, double returned) {
        this.invoiceId = invoiceId;
        this.employee = employee;
        this.customer = customer;
        this.totalPrice = totalPrice;
        this.tax = tax;
        this.localDate = LocalDate.of(year, month, dayOfMonth);
        this.discount = discount;
        this.totalPay = totalPay;
        this.paid = paid;
        this.returned = returned;
    }

    public String getInvoiceId() {
        return this.invoiceId;
    }

    public LocalDate getLocalDate() {
        return this.localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
    

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTax() {
        return this.tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getDiscount() {
        return this.discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotalPay() {
        return this.totalPay;
    }

    public void setTotalPay(double totalPay) {
        this.totalPay = totalPay;
    }

    public double getPaid() {
        return this.paid;
    }

    public void setPaid(double paid) {
        this.paid = paid;
    }

    public double getReturned() {
        return this.returned;
    }

    public void setReturned(double returned) {
        this.returned = returned;
    }
    
}

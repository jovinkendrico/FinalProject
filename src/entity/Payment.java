package entity;

public class Payment {
    private double totalPrice;
    private double tax;
    private double discount;
    private double totalPay;

    public Payment(double totalPrice, double tax, double discount, double totalPay) {
        this.totalPrice = totalPrice;
        this.tax = tax;
        this.discount = discount;
        this.totalPay = totalPay;
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

}

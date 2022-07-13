package entity;

public class Sale {
    private static int increment;
    private int saleId;
    private Invoice invoice;
    private Item item;
    private int quantity;
    private int total;

    public Sale(Invoice invoice, Item item, int quantity) {
        this.saleId = ++increment;
        this.invoice = invoice;
        this.item = item;
        this.quantity = quantity;
        this.total = item.getPrice() * quantity;
    }

    public int getSaleId() {
        return this.saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public Invoice getInvoice() {
        return this.invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Item getItem() {
        return this.item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public double getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}

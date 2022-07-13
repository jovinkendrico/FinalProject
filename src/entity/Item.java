package entity;

public class Item {
    private String itemId;
    private String itemName;
    private int price;
    private int amount;
    private Category category;



    public Item(String itemId, String itemName, int price, int amount, Category category) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.amount = amount;
        this.category = category;
    }



    public String getItemId() {
        return this.itemId;
    }

    public String getItemName() {
        return this.itemName;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
    
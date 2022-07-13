package entity;

public class Category {
    private static int increment = 0;
    private int categoryId;
    private String jenisKategori;


    public Category() {
    }

    public Category(String jenisKategori) {
        this.categoryId = ++increment;
        this.jenisKategori = jenisKategori;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getJenisKategori() {
        return this.jenisKategori;
    }

    public void setJenisKategori(String jenisKategori) {
        this.jenisKategori = jenisKategori;
    }
   
}

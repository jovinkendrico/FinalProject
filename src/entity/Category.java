package entity;

public class Category {
    private int categoryId;
    private String jenisKategori;


    public Category(int categoryId, String jenisKategori) {
        this.categoryId = categoryId;
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

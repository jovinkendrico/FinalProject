package entity;

import java.util.ArrayList;
import java.util.Scanner;
public class EmployeeAdmin extends Employee {

    
    public EmployeeAdmin(String employeeName, String userName, String password) {
        super(employeeName, userName, password, true);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void showCustomerData(ArrayList<Customer> dataCustomer) {
        // TODO Auto-generated method stub
        System.out.println("===============================");
        System.out.println("Cetak Data Customer");
        System.out.println("===============================");
        System.out.format("| %4s | %30s | %15s | %40s |", "ID", "Nama", "Phone", "Email");    
        System.out.println();
        for(Customer customer : dataCustomer){
            System.out.format("| %4d | %30s | %15s | %40s |", customer.getCustomerId(), customer.getCustomerName(), customer.getPhone(), customer.getEmail());    
            System.out.println();
        }
        System.out.println("===============================");
    }

    @Override
    public void showInvoiceData(ArrayList<Invoice> dataInvoice) {
        // TODO Auto-generated method stub
        System.out.println("===============================");
        System.out.println("Cetak Data Invoice");
        System.out.println("===============================");
        System.out.format("| %4s | %30s | %30s | %15s | %15s | %15s | %15s | %15s | %15s | %15s |", "ID", "Nama Kasir", "Nama Customer", "Tanggal", "Total Harga", "Tax", "Diskon", "Total Bayar", "Bayar", "Kembalian");    
        System.out.println();
        for (Invoice invoice : dataInvoice) {
            System.out.format("| %4d | %30s | %30s | %15s | %15f | %15f | %15f | %15f | %15f | %15f |", invoice.getInvoiceId(), invoice.getEmployee().getEmployeeName(), invoice.getCustomer().getCustomerName(), invoice.getLocalDate(), invoice.getTotalPrice(), invoice.getTax(), invoice.getDiscount(), invoice.getTotalPay(), invoice.getPaid(), invoice.getReturned());    
            System.out.println();
        }
        System.out.println("===============================");
    }

    @Override
    public void showItemData(ArrayList<Item> dataItem) {
        // TODO Auto-generated method stub
        System.out.println("===============================");
        System.out.println("Cetak Data Item");
        System.out.println("===============================");
        System.out.format("| %13s | %35s | %15s | %8s | %25s |", "ID", "Nama Item", "Harga", "Jumlah", "Jenis Kategori");    
        System.out.println();
        for (Item item : dataItem) {
            System.out.format("| %13s | %35s | %15d | %8d | %25s |", item.getItemId(), item.getItemName(), item.getPrice(), item.getAmount(), item.getCategory().getJenisKategori());      
            System.out.println();
        }
        System.out.println("===============================");
    }

    @Override
    public void showItemCategory(ArrayList<Category> dataCategory) {
        // TODO Auto-generated method stub
        System.out.println("===============================");
        System.out.println("Cetak Data Kategori Item");
        System.out.println("===============================");
        System.out.format("| %5s | %35s |", "ID", "Jenis Kategori");   
        System.out.println();
        for (Category category : dataCategory) {
            System.out.format("| %5d | %35s |", category.getCategoryId(), category.getJenisKategori());   
            System.out.println();
        }
        System.out.println("===============================");
    }

    public void showEmployeeData(ArrayList<Employee> dataEmployee){
        System.out.println("===============================");
        System.out.println("Cetak Data Karyawan");
        System.out.println("===============================");
        System.out.format("| %5s | %35s | %20s | %20s | %15s", "ID", "Nama", "Username", "Password", "Admin/Kasir");
        System.out.println();
        for (Employee employee : dataEmployee) {
            System.out.format("| %5d | %35s | %20s | %20s | %15s", employee.getEmployeeId(), employee.getEmployeeName(), employee.getUserName(), employee.getPassword(), ((employee.getIsAdmin()) ? "Admin": "Kasir"));
            System.out.println();
        }   
        System.out.println("===============================");
    }

    public void tambahDataKaryawan(Scanner scanner,ArrayList<Employee> dataEmployee){
        String nama;
        String username;
        String password;
        String pilihan;
        try {
            scanner.nextLine();
            System.out.println("===============================");
            System.out.println("Tambah Karyawan");
            System.out.println("===============================");
            System.out.print("Nama Karyawan = ");
            nama = scanner.nextLine();
            System.out.print("Username = ");            
            username = scanner.nextLine();
            System.out.print("Password = ");
            password = scanner.nextLine();
            System.out.print("[Kasir / Admin] = ");
            pilihan = scanner.nextLine();
            for(Employee employee : dataEmployee){
                if(employee.getUserName() == username){
                    throw new Exception("Username sudah ada masukkan username lain");
                }
            }
            if(password.length()<8){
                throw new Exception("Password harus memiliki 8 angka atau huruf");
            }
            if(pilihan.equalsIgnoreCase("kasir")){
                dataEmployee.add(new EmployeeCashier(nama, username, password));
                System.out.println("\n Data kasir berhasil ditambahkan..\n");
            }else if(pilihan.equalsIgnoreCase("admin")){
                dataEmployee.add(new EmployeeAdmin(nama, username, password));
                System.out.println("\n Data Admin berhasil ditambahkan..\n");
            }else{
                throw new Exception("Masukkan pilihan antara kasir atau admin");
            }
            
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Error : " + e.getMessage());
        } 
        System.out.println("===============================");
    }

    public void tambahDataItem(Scanner scanner, ArrayList<Item> dataItem, ArrayList<Category> dataCategory){
        String itemId;
        String namaItem;
        int price;
        int amount;
        String jenisKategori;
        try {
            scanner.nextLine();
            System.out.println("===============================");
            System.out.println("Tambah Item");
            System.out.println("===============================");
            System.out.print("ID Item = ");
            itemId = scanner.nextLine();
            System.out.print("Nama Barang = ");
            namaItem = scanner.nextLine();
            System.out.print("Harga Barang = ");
            price = scanner.nextInt();
            System.out.print("Total Barang = ");
            amount = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Jenis Kategori barang = ");
            jenisKategori = scanner.nextLine();
            for(Item item : dataItem){
                if(item.getItemId().equalsIgnoreCase(itemId)){
                    throw new Exception("ID Barang yang diinput sudah terdapat dalam data");
                }
            }
            int idxCategory = 0;
            boolean cDitemukan = false;
            Category hCategory = new Category();
            for (Category category : dataCategory){
                if(category.getJenisKategori().equalsIgnoreCase(jenisKategori)){
                    hCategory = dataCategory.get(idxCategory);
                    cDitemukan = true;
                    break;
                }
                idxCategory++;
            }
            if(cDitemukan){
                dataItem.add(new Item(itemId, namaItem, price, amount, hCategory));
                System.out.println("\n Data item berhasil ditambahkan..\n");
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    public void tambahDataCategory(Scanner scanner, ArrayList<Category> dataCategory){
        String kategori;
        try {
            scanner.nextLine();
            System.out.println("===============================");
            System.out.println("Tambah Kategori");
            System.out.println("===============================");
            System.out.print("Nama Category = ");
            kategori = scanner.nextLine();
            dataCategory.add(new Category(kategori));
            System.out.println("\n Data kategori berhasil ditambahkan..\n");
        }catch (Exception e) {
            //TODO: handle exception
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public void tambahDataCustomer(Scanner scanner, ArrayList<Customer> dataCustomer){
        String namaCustomer;
        String phoneCust;
        String emailCust;
        
        try {
            scanner.nextLine();
            System.out.println("===============================");
            System.out.println("Tambah Customer");
            System.out.println("===============================");
            System.out.print("Nama Customer = ");
            namaCustomer = scanner.nextLine();
            System.out.print("Nomor Hp Customer = ");
            phoneCust = scanner.nextLine();
            System.out.print("Email Customer = ");
            emailCust = scanner.nextLine();
            for (Customer customer : dataCustomer) {
                if(customer.getPhone().equals(phoneCust)) {
                    throw new Exception("Nomor telp Customer yang diinput sudah terdapat dalam data");
                }
            }
            dataCustomer.add(new Customer(namaCustomer, phoneCust, emailCust));
            System.out.println("\n Data kustomer berhasil ditambahkan..\n");
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Error : " + e.getMessage());
        }
        
    }
    
}

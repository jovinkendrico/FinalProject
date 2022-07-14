package entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class EmployeeCashier extends Employee {


    public EmployeeCashier(String employeeName, String userName, String password) {
        super(employeeName, userName, password, false);
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
        System.out.println("================================================================================================================");
        System.out.println("Cetak Data Item");
        System.out.println("================================================================================================================");
        System.out.format("| %13s | %35s | %15s | %8s | %25s |", "ID", "Nama Item", "Harga", "Jumlah", "Jenis Kategori");    
        System.out.println();
        for (Item item : dataItem) {
            System.out.format("| %13s | %35s | %15d | %8d | %25s |", item.getItemId(), item.getItemName(), item.getPrice(), item.getAmount(), item.getCategory().getJenisKategori());      
            System.out.println();
        }
        System.out.println("================================================================================================================");
    }
    @Override
    public void showItemCategory(ArrayList<Category> dataCategory) {
        // TODO Auto-generated method stub
        System.out.println("===============================================================");
        System.out.println("Cetak Data Kategori Item");
        System.out.println("===============================================================");
        System.out.format("| %5s | %35s |", "ID", "Jenis Kategori");   
        System.out.println();
        for (Category category : dataCategory) {
            System.out.format("| %5d | %35s |", category.getCategoryId(), category.getJenisKategori());   
            System.out.println();
        }
        System.out.println("===============================");
    }

    public void cashier(Employee employee, Scanner scanner, ArrayList<Customer> dataCustomer, ArrayList<Item> dataItem, ArrayList<Sale> dataSale, ArrayList<Invoice> dataInvoice){
        String phone = checkInputPhoneNumber(scanner);
        if(checkPhoneNumberRegistered(dataCustomer, phone)){
            tambahDataInvoiceSale(phone, dataCustomer, scanner, employee, dataItem, dataSale, dataInvoice);
        } else{
            tambahDataCustomer(scanner, dataCustomer, phone);
            tambahDataInvoiceSale(phone, dataCustomer, scanner, employee, dataItem, dataSale, dataInvoice);
        }
    }
    public void cetakInvoiceID(Scanner scanner, ArrayList<Invoice> dataInvoice, ArrayList<Sale> dataSale){
        int invoiceId;
        boolean iDitemukan = false;
        int idxInvoice = 0;
        while(true){
            try{
                System.out.print("Masukkan Invoice ID = ");
                invoiceId = scanner.nextInt();
                for (Invoice invoice : dataInvoice) {
                    if(invoice.getInvoiceId() == invoiceId){
                        iDitemukan = true;
                        break;
                    }
                    idxInvoice++;
                }          
                if(iDitemukan){
                    Invoice invoice = dataInvoice.get(idxInvoice);
                    cetakInvoice(dataSale, invoice);
                    break;
                }
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
        System.out.println("===============================");
    }
    private void cetakInvoice(ArrayList<Sale> dataSale , Invoice invoice){
        System.out.println("=============================================================================");
        System.out.println("                                    INVOICE                                  ");
        System.out.println("=============================================================================");
        System.out.println("Nama Customer = " + invoice.getCustomer().getCustomerName());
        System.out.println("Nama Kasir = " + invoice.getEmployee().getEmployeeName());
        System.out.println("Tanggal Transaksi = " + invoice.getLocalDate());
        System.out.println("=============================================================================");
        System.out.format("%8s %30s %10s %10s %10s \n", "ID", "Nama Item", "Jumlah", "Harga", "Total");    
        for (Sale sale : dataSale) {
            if(sale.getInvoice().getInvoiceId() == invoice.getInvoiceId()) System.out.format("%8s %30s %10s %10s %10s \n", sale.getItem().getItemId(), sale.getItem().getItemName(), sale.getQuantity(), sale.getItem().getPrice(), sale.getTotal());
        }
        System.out.println("=============================================================================");

        System.out.println("Total Harga = " + invoice.getTotalPrice());
        System.out.println("Tax         = " + invoice.getTax());
        System.out.println("Diskon      = " + invoice.getDiscount());
        System.out.println("Total Bayar = " + invoice.getTotalPay());
        System.out.println("Bayar       = " + invoice.getPaid());
        System.out.println("Kembalian   = " + invoice.getReturned());
        System.out.println("=============================================================================");

    }
    private void tambahDataCustomer(Scanner scanner, ArrayList<Customer> dataCustomer, String phone){
        String namaCustomer;
        String emailCust;
        while(true){
            try {
                scanner.nextLine();
                System.out.print("Nama Customer = ");
                namaCustomer = scanner.nextLine();
                System.out.print("Email Customer = ");
                emailCust = scanner.nextLine();
                dataCustomer.add(new Customer(namaCustomer, phone, emailCust));
                break;
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println("Error : " + e.getMessage());
            }
        }
    }
    private void tambahDataInvoiceSale(String phone, ArrayList<Customer> dataCustomer, Scanner scanner, Employee employee, ArrayList<Item> dataItem, ArrayList<Sale> dataSale, ArrayList<Invoice> dataInvoice){
        Customer customer = getDataCustomer(dataCustomer, phone);
        LocalDate localDate = getTanggalTransaksi(scanner);
        Invoice invoice = new Invoice(employee, customer, localDate);
        boolean tambahItem = true;
        while(tambahItem){
            tambahDataSale(scanner, invoice, dataItem, dataSale);
            scanner.nextLine();
            System.out.print("Tambah Item lain ? (y/n)");
            String pilihan = scanner.nextLine();
            if(pilihan.equalsIgnoreCase("n")){
                break;
            }
        }
        
        for (Sale sale : dataSale) {
            if(sale.getInvoice().getInvoiceId() == invoice.getInvoiceId()){
                invoice.tambahTotalPrice(sale.getTotal());
            }
        }

        invoice.setTax(0.11 * invoice.getTotalPrice());
        invoice.setTotalPay(invoice.getTotalPrice() + invoice.getTax() - invoice.getDiscount());

        System.out.println("Total Harga = " + invoice.getTotalPay());
        int bayar;
        while(true){
            try {
                System.out.print("Bayar = ");
                bayar = scanner.nextInt();
                if(bayar < invoice.getTotalPay()) throw new Exception("Kurang bayar");
                else{
                    System.out.println("Kembalian = " + (invoice.getTotalPay()-bayar));
                    invoice.setPaid(bayar);
                    invoice.setReturned((bayar-invoice.getTotalPay()));
                    break;
                }
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println("Error : " + e.getMessage());
            }
        }
        dataInvoice.add(invoice);

        cetakInvoice(dataSale, invoice);
    }
    private boolean checkPhoneNumberRegistered(ArrayList<Customer> dataCustomer, String phoneNumber){
        for(Customer customer : dataCustomer){
            if(customer.getPhone().equalsIgnoreCase(phoneNumber)){
                return true;
            }
        }
        return false;
    }
    private String checkInputPhoneNumber(Scanner scanner){
        String phone;
        while(true){
            try {
                scanner.nextLine();
                System.out.print("Masukkan No Telepon Customer = ");
                phone = scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage());
                //TODO: handle exception
            }            
        }
        return phone;
    }
    private Customer getDataCustomer(ArrayList<Customer> dataCustomer, String phoneNumber){
        for (Customer customer : dataCustomer) {
            if(customer.getPhone().equals(phoneNumber)){
                return customer;
            }
        }
        return null;
    }
    private LocalDate getTanggalTransaksi(Scanner scanner){
        while(true){
            try {
                System.out.print("Tahun Transaksi = ");
                int tahun = scanner.nextInt();
                System.out.print("Bulan Transaksi = ");
                int bulan = scanner.nextInt();
                System.out.print("Tanggal Transaksi = ");
                int tanggal = scanner.nextInt();
                if(bulan >12) throw new Exception("Masukkan tanggal, bulan atau tahun yang beanr");
                if(tanggal>31) throw new Exception("Masukkan tanngal, bulan atau tahun yang benar");
                LocalDate localDate = LocalDate.of(tahun, bulan, tanggal);
                return localDate;
            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage());
                //TODO: handle exception
            }
        }

    }
    private void tambahDataSale(Scanner scanner, Invoice invoice, ArrayList<Item> dataItem, ArrayList<Sale> dataSale){
        while(true){
            int amount;
            int idxItem = 0;
            try {
                scanner.nextLine();
                System.out.print("Kode item = ");
                String itemId = scanner.nextLine();
                boolean iFound = false;
                for (Item item : dataItem) {
                    if(item.getItemId().equalsIgnoreCase(itemId)){
                        iFound = true;
                        break;
                    }
                    idxItem++;
                }
                if(!iFound) throw new Exception("Masukkan item id yang benar");
                System.out.print("Jumlah dibeli = ");
                amount = scanner.nextInt();
                dataSale.add(new Sale(invoice, dataItem.get(idxItem), amount));
                for(Item item : dataItem){
                    if(item.getItemId().equals(itemId)){
                        item.setAmount(item.getAmount()-amount);
                    }
                }
                break;
            }catch(Exception e) {
                //TODO: handle exception
                System.out.println("Error : " + e.getMessage());
            } 
        }
    }
}

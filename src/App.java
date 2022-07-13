import java.util.ArrayList;
import java.util.Scanner;

import entity.Category;
import entity.Customer;
import entity.Employee;
import entity.EmployeeAdmin;
import entity.EmployeeCashier;
import entity.Invoice;
import entity.Item;
import entity.Sale;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> dataEmployee = initEmployee();
        ArrayList<Category> dataCategory = initCategory();
        ArrayList<Customer> dataCustomer = initCustomer();
        ArrayList<Item> dataItem = initItem(dataCategory);
        ArrayList<Invoice> dataInvoice = new ArrayList<Invoice>();
        ArrayList<Sale> dataSale = new ArrayList<Sale>();
        while (true){
            String logout = "n";
            Employee employee = LoginEmployee(scanner, dataEmployee);
            while (logout.equalsIgnoreCase("n")){
                runApp(scanner, employee, dataEmployee, dataItem, dataCustomer, dataCategory, dataInvoice, dataSale);
                System.out.print("Logout (y/n) ? = ");
                logout = scanner.next();
                bersihkanLayar();
            }
        }
    }
    public static void runApp(Scanner scanner, Employee employee, ArrayList<Employee> dataEmployee, ArrayList<Item> dataItem, ArrayList<Customer> dataCustomer, ArrayList<Category> dataCategory, ArrayList<Invoice> dataInvoice, ArrayList<Sale> dataSale){
        if(employee.getIsAdmin()){
            bersihkanLayar();
            EmployeeAdmin login = (EmployeeAdmin) employee;
            System.out.println("===============================");
            System.out.println("Menu Employee Admin");
            System.out.println("===============================");
            System.out.println("1. Tambah Data Karyawan");
            System.out.println("2. Tambah Data Item");
            System.out.println("3. Tambah Data Kategori");
            System.out.println("4. Tambah Data Customer");
            System.out.println("5. Cetak Data Invoice");
            System.out.println("6. Cetak Data Karyawan");
            System.out.println("7. Cetak Data Item");
            System.out.println("8. Cetak Data Kategori");
            System.out.println("9. Cetak Data Customer");
            System.out.println("===============================");
            System.out.print("Masukkan Pilihan = ");
            int pilihan;
            try {
                pilihan = scanner.nextInt();
                if(pilihan>10 || pilihan <1){
                    throw new Exception("Masukkan Pilihan Antara 1-10");
                }
                if(pilihan == 1){
                    bersihkanLayar();
                    login.tambahDataKaryawan(scanner, dataEmployee);
                }
                else if(pilihan == 2){
                    bersihkanLayar();
                    login.tambahDataItem(scanner, dataItem, dataCategory);
                }else if(pilihan == 3){
                    bersihkanLayar();
                    login.tambahDataCategory(scanner, dataCategory);
                }else if(pilihan == 4){
                    bersihkanLayar();
                    login.tambahDataCustomer(scanner, dataCustomer);
                }else if(pilihan == 5){
                    bersihkanLayar();
                    login.showInvoiceData(dataInvoice);
                }else if(pilihan == 6){
                    bersihkanLayar();
                    login.showEmployeeData(dataEmployee);
                }else if(pilihan == 7){
                    bersihkanLayar();
                    login.showItemData(dataItem);
                }else if(pilihan == 8){
                    bersihkanLayar();
                    login.showItemCategory(dataCategory);
                }else{
                    bersihkanLayar();
                    login.showCustomerData(dataCustomer);
                }
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println("Error : " + e.getMessage());
            }
        }else{
            bersihkanLayar();
            EmployeeCashier login = (EmployeeCashier) employee;
            System.out.println("===============================");
            System.out.println("Menu Employee Kasir");
            System.out.println("===============================");
            System.out.println("1. Cetak Data Invoice");
            System.out.println("2. Cetak Data Item");
            System.out.println("3. Cetak Data Kategori");
            System.out.println("4. Cetak Data Customer");
            System.out.println("5. Aplikasi Kasir");
            System.out.println("6. Cetak Invoice berdasarkan Invoice ID");
            System.out.println("===============================");
            System.out.print("Masukkan Pilihan = ");
            int pilihan;
            try {
                pilihan = scanner.nextInt();
                if(pilihan>6 || pilihan <1){
                    bersihkanLayar();
                    throw new Exception("Masukkan Pilihan Antara 1-6");
                }
                if (pilihan == 1){
                    bersihkanLayar();
                    login.showInvoiceData(dataInvoice);
                }
                else if(pilihan == 2){
                    bersihkanLayar();
                    login.showItemData(dataItem);
                }
                else if(pilihan == 3){
                    bersihkanLayar();
                    login.showItemCategory(dataCategory);
                }
                else if(pilihan == 4){
                    bersihkanLayar();
                    login.showCustomerData(dataCustomer);
                }
                else if(pilihan == 5){
                    bersihkanLayar();
                    login.cashier(login, scanner, dataCustomer, dataItem, dataSale, dataInvoice);
                }
                else if(pilihan == 6){
                    bersihkanLayar();
                    login.cetakInvoiceID(scanner, dataInvoice, dataSale);
                }
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println("Error : " + e.getMessage());
            }
        }
    }
    
    public static Employee LoginEmployee(Scanner scanner, ArrayList<Employee> dataEmployee){
        String userName;
        String password;
        while(true){
            try {
                System.out.println("=================");
                System.out.println("Login");
                System.out.println("=================");
                System.out.print("Username = ");
                userName = scanner.next();
                System.out.print("Password = ");
                password = scanner.next();
                for(Employee employee : dataEmployee){
                    if(employee.getUserName().equals(userName)){
                        if(employee.getPassword().equals(password)){
                            return employee;
                        }
                    }
                }
                throw new Exception("Masukkan Username dan Password yang benar");
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println("Error = "+ e.getMessage());
            }
        }
    }

    public static ArrayList<Employee> initEmployee(){
        ArrayList<Employee> dataEmployee = new ArrayList<Employee>();
        dataEmployee.add(new EmployeeAdmin("Jovian", "Jovian", "12345abc"));
        dataEmployee.add(new EmployeeAdmin("Vanes", "Vanes", "qwerty12345"));
        dataEmployee.add(new EmployeeCashier("Carlos", "Carlos", "abcdefghij"));
        return dataEmployee;
    }

    public static ArrayList<Customer> initCustomer() {
        ArrayList<Customer> dataCustomer = new ArrayList<Customer>();
        dataCustomer.add(new Customer("Kinaro", "081234567891", "jovin123@gmail.com"));
        dataCustomer.add(new Customer("Khellyn", "081234567892", "khellyn123@gmail.com"));
        dataCustomer.add(new Customer("Vanesia", "081234567893", "vanesia123@gmail.com"));
        dataCustomer.add(new Customer("Callista", "081234567894", "callista123@gmail.com"));
        dataCustomer.add(new Customer("Vellyn", "081234567895", "vellyn123@gmail.com"));
        return dataCustomer;
    }

    public static ArrayList<Item> initItem(ArrayList<Category> dataCategory) {
        ArrayList<Item> dataItem = new ArrayList<Item>();
        dataItem.add(new Item("OBAT001", "Mylanta Cair", 14000, 50, dataCategory.get(0)));
        dataItem.add(new Item("SNK001", "Chitato", 3000, 105, dataCategory.get(1)));
        dataItem.add(new Item("MIN001", "Pocari", 5000, 200, dataCategory.get(2)));
        dataItem.add(new Item("PRT001", "Sapu", 40000, 30, dataCategory.get(3)));
        dataItem.add(new Item("MIN001", "Teh Pucuk Harum", 3500, 300, dataCategory.get(4)));
        return dataItem;
    }

    public static ArrayList<Category> initCategory(){
        ArrayList<Category> dataCategory = new ArrayList<Category>();
        dataCategory.add(new Category("Minuman"));
        dataCategory.add(new Category("Makanan"));
        dataCategory.add(new Category("Obat-obatan"));
        dataCategory.add(new Category("Snack"));
        dataCategory.add(new Category("Peralatan Rumah Tangga"));
        return dataCategory;
    }
    
    public static void bersihkanLayar(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
    // public static void runApp(Scanner scanner, Employee employee, ArrayList<Employee> dataEmployee, ArrayList<Item> dataItem, ArrayList<Customer> dataCustomer, ArrayList<Category> dataCategory, ArrayList<Invoice> dataInvoice, ArrayList<Sale> dataSale){
    //     if(employee.getIsAdmin()){
    //         EmployeeAdmin login = (EmployeeAdmin) employee;
    //         System.out.println("1. Tambah Data Karyawan");
    //         System.out.println("2. Tambah Data Item");
    //         System.out.println("3. Tambah Data Kategori");
    //         System.out.println("4. Tambah Data Customer");
    //         System.out.println("5. Cetak Data Invoice");
    //         System.out.println("6. Cetak Data Karyawan");
    //         System.out.println("7. Cetak Data Item");
    //         System.out.println("8. Cetak Data Kategori");
    //         System.out.println("9. Cetak Data Customer");
    //         System.out.println("10. Logout");
    //         System.out.print("Masukkan Pilihan = ");
    //         int pilihan;
    //         try {
    //             pilihan = scanner.nextInt();
    //             if(pilihan>11){
    //                 throw new Exception("Masukkan Pilihan Antara 1-10");
    //             }
    //             if(pilihan == 1){
    //                 login.tambahDataKaryawan(scanner, dataEmployee);
    //             }
    //             else if(pilihan == 2){
    //                 login.tambahDataItem(scanner, dataItem, dataCategory);
    //             }else if(pilihan == 3){
    //                 login.tambahDataCategory(scanner, dataCategory);
    //             }else if(pilihan == 4){
    //                 login.tambahDataCustomer(scanner, dataCustomer);
    //             }else if(pilihan == 5){
    //                 login.showInvoiceData(dataInvoice);
    //             }else if(pilihan == 6){
    //                 login.showEmployeeData(dataEmployee);
    //             }else if(pilihan == 7){
    //                 login.showItemData(dataItem);
    //             }else if(pilihan == 8){
    //                 login.showItemCategory(dataCategory);
    //             }else if(pilihan == 9){
    //                 login.showCustomerData(dataCustomer);
    //             }else{
                    
    //             }
    //         } catch (Exception e) {
    //             //TODO: handle exception
    //             System.out.println("Error : " + e.getMessage());
    //         }
    //     }else{
    //         EmployeeCashier login = (EmployeeCashier) employee;
    //         System.out.println("1. Cetak Data Invoice");
    //         System.out.println("2. Cetak Data Item");
    //         System.out.println("3. Cetak Data Kategori");
    //         System.out.println("4. Cetak Data Customer");
    //         System.out.println("5. Aplikasi Kasir");
    //         System.out.println("6. Cetak Invoice berdasarkan Invoice ID");
    //         System.out.print("Masukkan Pilihan = ");
    //         int pilihan;
    //         try {
    //             pilihan = scanner.nextInt();
    //             if (pilihan == 1){
    //                 login.showInvoiceData(dataInvoice);
    //             }
    //             else if(pilihan == 2){
    //                 login.showItemData(dataItem);
    //             }
    //             else if(pilihan == 3){
    //                 login.showItemCategory(dataCategory);
    //             }
    //             else if(pilihan == 4){
    //                 login.showCustomerData(dataCustomer);
    //             }
    //             else if(pilihan == 5){
    //                 login.cashier(login, scanner, dataCustomer, dataItem, dataSale);
    //             }
    //         } catch (Exception e) {
    //             //TODO: handle exception
    //             System.out.println("Error : " + e.getMessage());
    //         }
    //     }
    // }
    
    // public static Employee LoginEmployee(Scanner scanner, ArrayList<Employee> dataEmployee){
    //     String userName;
    //     String password;
    //     while(true){
    //         try {
    //             System.out.print("Username = ");
    //             userName = scanner.nextLine();
    //             System.out.print("Password = ");
    //             password = scanner.nextLine();
    //             for(Employee employee : dataEmployee){
    //                 if(employee.getUserName().equals(userName)){
    //                     if(employee.getPassword().equals(password)){
    //                         return employee;
    //                     }
    //                 }
    //             }
    //             throw new Exception("Masukkan Username dan Password yang benar");
    //         } catch (Exception e) {
    //             //TODO: handle exception
    //             System.out.println("Error = "+ e.getMessage());
    //         }
    //     }
    // }

    // public static ArrayList<Employee> initEmployee(){
    //     ArrayList<Employee> dataEmployee = new ArrayList<Employee>();
    //     dataEmployee.add(new EmployeeAdmin("Jovian", "Jovian", "12345abc"));
    //     dataEmployee.add(new EmployeeAdmin("Vanes", "Vanes", "qwerty"));
    //     dataEmployee.add(new EmployeeCashier("Carlos", "Carlos", "abcdefghij"));
    //     return dataEmployee;
    // }

    // public static ArrayList<Customer> initCustomer() {
    //     ArrayList<Customer> dataCustomer = new ArrayList<Customer>();
    //     dataCustomer.add(new Customer("Kinaro", "081234567891", "jovin123@gmail.com"));
    //     dataCustomer.add(new Customer("Khellyn", "081234567892", "khellyn123@gmail.com"));
    //     dataCustomer.add(new Customer("Vanesia", "081234567893", "vanesia123@gmail.com"));
    //     dataCustomer.add(new Customer("Callista", "081234567894", "callista123@gmail.com"));
    //     dataCustomer.add(new Customer("Vellyn", "081234567895", "vellyn123@gmail.com"));
    //     return dataCustomer;
    // }

    // public static ArrayList<Item> initItem(ArrayList<Category> dataCategory) {
    //     ArrayList<Item> dataItem = new ArrayList<Item>();
    //     dataItem.add(new Item("OBAT001", "Mylanta Cair", 14000, 50, dataCategory.get(0)));
    //     dataItem.add(new Item("SNK001", "Chitato", 3000, 105, dataCategory.get(1)));
    //     dataItem.add(new Item("MIN001", "Pocari", 5000, 200, dataCategory.get(2)));
    //     dataItem.add(new Item("PRT001", "Sapu", 40000, 30, dataCategory.get(3)));
    //     dataItem.add(new Item("MIN001", "Teh Pucuk Harum", 3500, 300, dataCategory.get(4)));
    //     return dataItem;
    // }

    // public static ArrayList<Category> initCategory(){
    //     ArrayList<Category> dataCategory = new ArrayList<Category>();
    //     dataCategory.add(new Category("Minuman"));
    //     dataCategory.add(new Category("Makanan"));
    //     dataCategory.add(new Category("Obat-obatan"));
    //     dataCategory.add(new Category("Snack"));
    //     dataCategory.add(new Category("Peralatan Rumah Tangga"));
    //     return dataCategory;
    // }

    // public static ArrayList<Invoice> initInvoice(ArrayList<Employee> dataEmployee, ArrayList<Customer> dataCustomer) {
    //     ArrayList<Invoice> dataInvoice = new ArrayList<Invoice>();
    //     dataInvoice.add(new Invoice(dataEmployee.get(0), dataCustomer.get(0), 2022, 06, 22, 360000, 39600, 18000, 381600, 400000, 18400));
    //     dataInvoice.add(new Invoice(dataEmployee.get(0), dataCustomer.get(1), 2022, 05, 10, 43500, 4785, 2175, 46110, 50000, 3890));
    //     dataInvoice.add(new Invoice(dataEmployee.get(2), dataCustomer.get(2), 2022, 05, 06, 102000, 11220, 10200, 103020, 110000, 6980));
    //     dataInvoice.add(new Invoice(dataEmployee.get(1), dataCustomer.get(3), 2022, 05, 20, 85000, 9350, 8500, 85850, 100000, 14150));
    //     dataInvoice.add(new Invoice(dataEmployee.get(2), dataCustomer.get(4), 2022, 07, 17, 420000, 46200, 63000, 403200, 405000, 1800));
    //     return dataInvoice;
    // }
}

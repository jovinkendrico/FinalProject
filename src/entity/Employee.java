package entity;

import java.util.ArrayList;

public abstract class Employee{
    private static int increment = 0;
    private int employeeId;
    private String employeeName;
    private String userName;
    private String password;
    private boolean isAdmin;

    public Employee( String employeeName, String userName, String password, boolean isAdmin) {
        this.employeeId = ++increment;
        this.employeeName = employeeName;
        this.userName = userName;
        this.password = password;
        this.isAdmin = isAdmin;
    }
    
    abstract void showCustomerData(ArrayList<Customer> dataCustomer);
    abstract void showInvoiceData(ArrayList<Invoice> dataInvoice);
    abstract void showItemData(ArrayList<Item> dataItem);
    abstract void showItemCategory(ArrayList<Category> dataCategory);

    public int getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return this.employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIsAdmin() {
        return this.isAdmin;
    }

    public boolean getIsAdmin() {
        return this.isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

}
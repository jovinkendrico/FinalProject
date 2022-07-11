package entity;

public class Employee{
    private int employeeId;
    private String employeeName;
    private String userName;
    private String password;
    private String phone;
    private String email;
    private String type;

    public Employee(int employeeId, String employeeName, String userName, String password, String phone, String email, String type) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.type = type;
    }

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

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

}

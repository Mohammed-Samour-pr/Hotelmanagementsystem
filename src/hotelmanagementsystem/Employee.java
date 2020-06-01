/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

/**
 *
 * @author USER
 */
public class Employee {

    int id;
    int hours;
    static String Ename;
    String ID;
    int WORKHOURS;//******************************************//**/*/*
    String UserName, phone;
    String Password;
    String birthday;
    String PhoneNumber;
    String Birthdate;

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public static String getEname() {
        return Ename;
    }

    public static void setEname(String Ename) {
        Employee.Ename = Ename;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPhone() {
        return phone;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getBirthdate() {
        return Birthdate;
    }

    public void setBirthdate(String Birthdate) {
        this.Birthdate = Birthdate;
    }

    public int getWORKHOURS() {
        return WORKHOURS;
    }

    public void setWORKHOURS(int WORKHOURS) {
        this.WORKHOURS = WORKHOURS;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", hours=" + hours + ", ID=" + ID + ", WORKHOURS=" + WORKHOURS + ", UserName=" + UserName + ", phone=" + phone + ", Password=" + Password + ", birthday=" + birthday + ", PhoneNumber=" + PhoneNumber + ", Birthdate=" + Birthdate + '}';
    }

}

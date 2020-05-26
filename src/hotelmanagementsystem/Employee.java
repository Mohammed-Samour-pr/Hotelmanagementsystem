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
    String name, phone, password, birthday, empName, middle, last;

    public Employee(String name, int id, String phone, String password, String birthday, int hours, String empName, String middle, String last) {
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.password = password;
        this.birthday = birthday;
        this.hours = hours;
        this.empName = empName;
        this.middle = middle;
        this.last = last;

    }

    @Override
    public String toString() {
        return "Name: " + name + "\n Id: " + id + "\nPhone: " + phone + "\npass: " + password + "\nBbirthday: " + birthday;

    }

}

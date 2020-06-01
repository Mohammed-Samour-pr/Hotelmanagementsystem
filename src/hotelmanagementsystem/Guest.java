/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

/**
 *
 * @author USER
 */
public class Guest {

  
    Bill b = new Bill();
    Integer id;
      String ID;
    String gender;//******************************************//**/*/*
    String name, phone;
    String address;
    String birthday;
    String PhoneNumber;
    String Birthdate;

    public String getBirthdate() {
        return Birthdate;
    }

    public void setBirthdate(String Birthdate) {
        this.Birthdate = Birthdate;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Guest(String name, int id, String phone, String address, String birthday, String gender) {
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.address = address;
        this.birthday = birthday;
        this.gender = gender;

    }

    public Guest() {
    }

    public Bill getB() {
        return b;
    }

    public void setB(Bill b) {
        this.b = b;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Guest{" + "b=" + b + ", id=" + id + ", ID=" + ID + ", gender=" + gender + ", name=" + name + ", phone=" + phone + ", address=" + address + ", birthday=" + birthday + ", PhoneNumber=" + PhoneNumber + ", Birthdate=" + Birthdate + '}';
    }


}

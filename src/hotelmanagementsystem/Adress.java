/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

/**
 *
 * @author USER
 */
public class Adress {

    public int addressId;
    public String address;
    public int guestId;

    public Adress(int Id, String address) {
        this.addressId = Id;
        this.address = address;

    }

    @Override
    public String toString() {
        return "Adress{" + "addressId=" + addressId + ", address=" + address + ", guestId=" + guestId + '}';
    }

}

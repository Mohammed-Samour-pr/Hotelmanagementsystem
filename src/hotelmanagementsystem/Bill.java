/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

/**
 *
 * @author USER
 */
public class Bill {

    int billNumber;
    double totalPrice;
    String date;
    double discount;
    String paymanetMethod;

    public Bill() {
    }

    public Bill(int billNumber, double totalPrice, String date, double discount, String paymanetMethod) {
        this.billNumber = billNumber;
        this.totalPrice = totalPrice;
        this.date = date;
        this.discount = discount;
        this.paymanetMethod = paymanetMethod;
    }

    @Override
    public String toString() {
        return "Bill{" + "billNumber=" + billNumber + ", totalPrice=" + totalPrice + ", date=" + date + ", discount=" + discount + ", paymanetMethod=" + paymanetMethod + '}';
    }

}

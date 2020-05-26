/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

/**
 *
 * @author USER
 */
public class Room {

    int RoomNumber;
    String RoomType;
    double price;
    String description;
    String rate;
    public int reserveId;

    public Room(int RoomNumber, String RoomType, double price, String description, String rate, int reserveId) {
        this.RoomNumber = RoomNumber;
        this.RoomType = RoomType;
        this.price = price;
        this.description = description;
        this.rate = rate;
        this.reserveId = reserveId;
    }

}

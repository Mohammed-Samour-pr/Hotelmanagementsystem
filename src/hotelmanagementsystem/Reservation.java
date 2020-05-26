/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

/**
 *
 * @author USER
 */
public class Reservation {

    int Id;
    int withchildren;
    String branch;
    String checkin;
    String checkout;
    int numberroom;
    int numberguest;
    int numberday;
    int roomnumber;
    int breakfast;
    String activity;
    String roomType;

    public Reservation(
            int Id,
            int withchildren,
            String branch,
            String checkin,
            String checkout,
            int numberroom,
            int numberguest,
            int numberday,
            int roomnumber,
            int breakfast,
            String activity,
            String roomType
    ) {
        this.Id = Id;
        this.withchildren = withchildren;
        this.branch = branch;
        this.checkin = checkin;
        this.checkout = checkout;
        this.numberroom = numberroom;
        this.numberguest = numberguest;
        this.numberday = numberday;
        this.roomnumber = roomnumber;
        this.breakfast = breakfast;
        this.activity = activity;
        this.roomType = roomType;
    }

    public Reservation(String checkin, String checkout, int numberdays) {
        this.checkin = checkin;
        this.checkout = checkout;
        this.numberday = numberdays;
    }

    @Override
    public String toString() {
        return "Id: "
                + Id + "withchildren : " + withchildren + "branch: " + branch + "checkin: " + checkin + "checkout: " + checkout + "\n numberroom: " + numberroom
                + "\nnumberguest: "
                + numberguest + "\numberday: " + numberday + "\roomnumber: " + roomnumber + "\nbreakfast " + breakfast + "activity " + activity;

    }

}

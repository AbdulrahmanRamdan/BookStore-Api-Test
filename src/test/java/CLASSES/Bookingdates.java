package CLASSES;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Date;

@JsonPropertyOrder({"checkin","checkout"})
public class Bookingdates {
    private Date checkin;
    private Date checkout;

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public Bookingdates(){
        checkin=new Date(2018,12,22);
        checkout=new Date(2019,1,22);
    }
}

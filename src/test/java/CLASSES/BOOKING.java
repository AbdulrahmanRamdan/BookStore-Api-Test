package CLASSES;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"firstname","lastname","totalprice","depositpaid","bookingdates","additionalneeds"})
public class BOOKING {
    private String firstname;
    private String lastname;
    private String totalprice;
    private boolean depositpaid;
    private Bookingdates bookingdates;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public Bookingdates getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(Bookingdates bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    private String additionalneeds;
    public BOOKING(String name,String price,String need){
        this.firstname=this.lastname=name;
        this.totalprice=price;
        this.depositpaid=true;
        this.bookingdates=new Bookingdates();
        this.additionalneeds=need;
    }
}

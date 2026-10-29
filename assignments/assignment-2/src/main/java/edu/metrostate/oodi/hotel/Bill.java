package main.java.edu.metrostate.oodi.hotel;

import java.time.LocalDate;

public class Bill {
    public String billNumber;
    public LocalDate issuedOn;
    public int total = 0;

    public Bill(String bn, LocalDate io, int t) {
        this.billNumber = bn;
        this.issuedOn = io;
        this.total = t;
    }

    public String getBillNumber() {return this.billNumber;}
    public LocalDate getIssuedOn() {return this.issuedOn;}
    public int getTotal() {return this.total;}

    public int generateReceipt() {
        return Integer.parseInt(this.billNumber) * (total + 1) * 100; //placeholder
    }
}

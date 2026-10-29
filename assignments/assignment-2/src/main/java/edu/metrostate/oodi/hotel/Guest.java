package main.java.edu.metrostate.oodi.hotel;

public class Guest {
    public String name;
    public String email;
    public String phone;

    public Guest(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getProfile() {
        return this.name + " " + this.email + " " + this.phone;
    }
}

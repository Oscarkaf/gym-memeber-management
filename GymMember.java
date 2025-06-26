package GymCoursework;

public abstract class GymMember {
    protected int id;
    protected String name;
    protected String location;
    protected String phone;
    protected String email;
    protected String gender;
    protected String DOB;
    protected String membershipStartDate;
    protected int attendance;
    protected double loyaltyPoints;
    protected boolean activeStatus;
    
     public GymMember(int id, String name, String location, String phone, String email,
                     String gender, String DOB, String membershipStartDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.DOB = DOB;
        this.membershipStartDate = membershipStartDate;
        this.attendance = 0;
        this.loyaltyPoints = 0.0;
        this.activeStatus = false;
    }
      
    // Accessor methods (getters)
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getDOB() {
        return DOB;
    }

    public String getMembershipStartDate() {
        return membershipStartDate;
    }

    public int getAttendance() {
        return attendance;
    }

    public double getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }
    
    
    //method to activate 
    public void activateMembership() {
        if (!activeStatus) {
            this.activeStatus = true;
            System.out.println(name + "membership activated.");
        } else {
            System.out.println(name + "membership is already active.");
        }
    }

    // Method to deactivate 
    public void deactivateMembership() {
        if (activeStatus) {
            this.activeStatus = false;
            System.out.println(name + "membership deactivated.");
        } else {
            System.out.println(name + "membership is already inactive.");
        }
    }

    // Method to reset member data which can be used in subclass 
    public void resetMember() {
        this.activeStatus = false;   // Resetting active status to false
        this.attendance = 0;          // Resetting attendance count to 0
        this.loyaltyPoints = 0.0;     // Resetting loyalty points to 0
        System.out.println(name + "membership has been reset.");
    }
    
     // display method to print all member details
    public void display() {
        System.out.println("Member Details: ");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Gender: " + gender);
        System.out.println("Date of Birth: " + DOB);
        System.out.println("Membership Start Date: " + membershipStartDate);
        System.out.println("Attendance: " + attendance);
        System.out.println("Loyalty Points: " + loyaltyPoints);
        System.out.println("Active Status: " + (activeStatus ? "Active" : "Inactive"));
    }
    
    //abstract methods 
    public abstract void markAttendance();
    public abstract void displayInfo(); 
}


    
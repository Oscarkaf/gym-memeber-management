package GymCoursework;

public class PremiumMember extends GymMember {
    private final double premiumCharge;  // Cannot be changed after initialization
    private String personalTrainer;
    private boolean isFullPayment;
    private double paidAmount;
    private double discountAmount;

    // Constructor with 9 parameters
    public PremiumMember(int id, String name, String location, String phone, String email,
                         String gender, String DOB, String membershipStartDate,
                         String personalTrainer) {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.personalTrainer = personalTrainer;
        this.premiumCharge = 50000.0;  // Fixed premium charge
        this.paidAmount = 0.0;
        this.isFullPayment = false;
        this.discountAmount = 0.0;
    }

    // Implement abstract method to mark attendance
    @Override
    public void markAttendance() {
        if (!activeStatus) {
            System.out.println(name + "'s membership is not active. Cannot mark attendance.");
            return;
        }

        attendance++;
        loyaltyPoints += 10.0;  // Premium members earn more points
        System.out.println(name + "'s attendance marked. Total visits: " + attendance);
        System.out.println("Loyalty points: " + loyaltyPoints);
    }

    // Implement abstract method to display member info
    @Override
    public void displayInfo() {
        super.display();  // Call GymMember's display method
        System.out.println("Personal Trainer: " + personalTrainer);
        System.out.println("Premium Charge: " + premiumCharge);
        System.out.println("Paid Amount: " + paidAmount);
        System.out.println("Discount Amount: " + discountAmount);
        System.out.println("Full Payment Done: " + (isFullPayment ? "Yes" : "No"));
    }

    // Method to make a payment (with optional discount)
    public void makePayment(double amount, double discount) {
        this.discountAmount = discount;
        this.paidAmount += amount;

        double totalDue = premiumCharge - discountAmount;
        if (paidAmount >= totalDue) {
            isFullPayment = true;
            System.out.println(name + " has completed full payment.");
        } else {
            System.out.println(name + " has made a partial payment. Remaining: " + (totalDue - paidAmount));
        }
    }

    // Accessor methods
    public double getPremiumCharge() {
        return premiumCharge;
    }

    public String getPersonalTrainer() {
        return personalTrainer;
    }

    public boolean isFullPayment() {
        return isFullPayment;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }
    
    // Method to pay due amount
    public String payDueAmount(double paidAmount) {
    if (this.isFullPayment) {
        return "Payment has already been completed. No dues remaining.";
    }

    double totalDue = premiumCharge - discountAmount;

    if ((this.paidAmount + paidAmount) > totalDue) {
        return "Payment exceeds total due. Please enter a valid amount.";
    }

    this.paidAmount += paidAmount;

    double remainingAmount = totalDue - this.paidAmount;

    // Update full payment status
    if (remainingAmount == 0) {
        this.isFullPayment = true;
        return "Payment successful. No remaining dues.";
    } else {
        this.isFullPayment = false;
        return "Payment successful. Remaining amount to be paid: " + remainingAmount;
    }
  }
  
  //calculate discount method 
  public String calculateDiscount() {
    if (isFullPayment) {
        discountAmount = premiumCharge * 0.10;
        return "Discount of 10% applied. Discount amount: " + discountAmount;
    } else {
        discountAmount = 0.0;
        return "No discount applied. Full payment not completed yet";
    }
  }
  
  // Method to revert PremiumMember to initial state
  public void revertPremiumMember() {
        resetMember();
        personalTrainer = "";
        isFullPayment = false;
        paidAmount = 0.0;
        discountAmount = 0.0;
  }

    // Method to display PremiumMember details
    @Override
    public void display() {
        // Call the superclass display method to show common attributes
        super.display();

        // Display PremiumMember-specific details
        System.out.println("Personal Trainer: " + personalTrainer);
        System.out.println("Paid Amount: " + paidAmount);
        System.out.println("Full Payment: " + (isFullPayment ? "Yes" : "No"));

        // Calculate and display remaining amount
        double remainingAmount = premiumCharge - paidAmount;
        System.out.println("Remaining Amount: " + remainingAmount);

        // Display discount amount only if full payment is made
        if (isFullPayment) {
            System.out.println("Discount Amount: " + discountAmount);
        }
  }
}


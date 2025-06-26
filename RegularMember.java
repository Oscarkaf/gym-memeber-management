package GymCoursework;

public class RegularMember extends GymMember {
    private final int attendanceLimit;         // cannot be changed after initialization
    private boolean isEligibleForUpgrade;
    private String removalReason;
    private String referralSource;
    private String plan;
    private double price;

    // Constructor with 9 parameters
    public RegularMember(int id, String name, String location, String phone, String email,
                         String gender, String DOB, String membershipStartDate,
                         String referralSource) {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.attendanceLimit = 30;           // Fixed limit
        this.isEligibleForUpgrade = false;   // Default
        this.removalReason = "";             // Default empty
        this.referralSource = referralSource;
        this.plan = "Basic";                 // Default plan
        this.price = 6500.0;                 // Default price
    }

    // Implement abstract method to mark attendance
    @Override
    public void markAttendance() {
        if (!activeStatus) {
            System.out.println(name + " membership is not active. Cannot mark attendance.");
            return;
        }

        if (attendance < attendanceLimit) {
            attendance++;
            loyaltyPoints += 5.0;  //  5 points per visit
            System.out.println(name + " attendance marked. Total visits: " + attendance);
            System.out.println("Loyalty points: " + loyaltyPoints);

            // Check if eligible for upgrade after reaching limit
            if (attendance == attendanceLimit) {
                isEligibleForUpgrade = true;
                System.out.println(name + " has reached attendance limit is eligible for update");
            }
        } else {
            System.out.println(name + " has reached the attendance limit of " + attendanceLimit + ".");
        }
    }
    
    @Override
    public void displayInfo() {
        super.display();

        // Display RegularMember-specific attributes
        System.out.println("Referral Source: " + referralSource);
        System.out.println("Plan: " + plan);
        System.out.println("Price: " + price);
        System.out.println("Attendance Limit: " + attendanceLimit);
        System.out.println("Eligible for Upgrade: " + (isEligibleForUpgrade ? "Yes" : "No"));

        // Display removalReason if it's not empty
        if (!removalReason.isEmpty()) {
            System.out.println("Removal Reason: " + removalReason);
        }
    }
    //price based on plan name using switch
    public double getPlanPrice(String plan) { 
        switch (plan.toLowerCase()) { 
            //toLowerCase insures switch case is case insensitive 
            case "basic":
                return 6500.0;
            case "standard":
                return 12500.0;
            case "deluxe":
                return 18500.0;
            default:
                return -1.0; // Return -1 for invalid plan
        }
    }
    //Upgrade the plan if eligible
    public String upgradePlan(String newPlan) {
        // Validate if the same plan is selected
        if (newPlan.equalsIgnoreCase(plan)) {
            return "You are already subscribed to the " + newPlan + " plan.";
        }

        // Check eligibility before upgrading
        if (isEligibleForUpgrade) {
            // Get the price of the new plan
            double newPrice = getPlanPrice(newPlan);

            if (newPrice != -1) {
                // Successfully upgrade the plan
                plan = newPlan;
                price = newPrice;
                return "Plan upgraded to " + newPlan + ". New price: " + price;
            } 
            else {
                return "Invalid plan selected for upgrade.";
            }
        } 
        else {
            return "You are not eligible for an upgrade yet.";
        }
    }
    //Revert the RegularMember to initial state
    public void revertRegularMember(String removalReason) {
        // Calling the superclass method to reset the member
        resetMember();

        // Reset other attributes
        isEligibleForUpgrade = false;
        plan = "Basic";
        price = 6500.0;
        this.removalReason = removalReason;
    }

    // Accessor methods (getters)
    public int getAttendanceLimit() {
        return attendanceLimit;
    }

    public boolean isEligibleForUpgrade() {
        return isEligibleForUpgrade;
    }

    public String getRemovalReason() {
        return removalReason;
    }

    public String getReferralSource() {
        return referralSource;
    }

    public String getPlan() {
        return plan;
    }

    public double getPrice() {
        return price;
    }
}

   

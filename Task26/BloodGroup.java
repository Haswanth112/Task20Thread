import java.util.*;
class Donor {
    private String name;
    private String phoneNumber;
    private String bloodGroup;

    public Donor(String name, String phoneNumber, String bloodGroup) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.bloodGroup = bloodGroup;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }
    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "Donor{name='" + name + "', phoneNumber='" + phoneNumber + "', bloodGroup='" + bloodGroup + "'}";
    }
}

class Patient {
    private String name;
    private String priority;
    private String bloodGroup;
    private int unitsNeeded;

    public Patient(String name, String priority, String bloodGroup, int unitsNeeded) {
        this.name = name;
        this.priority = priority;
        this.bloodGroup = bloodGroup;
        this.unitsNeeded = unitsNeeded;
    }

    public String getName() {
        return name;
    }

    public String getPriority() {
        return priority;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public int getUnitsNeeded() {
        return unitsNeeded;
    }

    public void setUnitsNeeded(int unitsNeeded) {
        this.unitsNeeded = unitsNeeded;
    }

    @Override
    public String toString() {
        return "Patient{name='" + name + "', priority='" + priority + "', unitsNeeded=" + unitsNeeded + "}";
    }
}

class BloodBank {
    private Map<String, List<Donor>> donorsByBloodGroup;
    private HashSet<Patient> patients;
    private HashMap<Donor, Patient> donorPatientMap;
    private Map<String, Integer> bloodBankReserve;

    public BloodBank() {
        donorsByBloodGroup = new HashMap<>();
        patients = new HashSet<>();
        donorPatientMap = new HashMap<>();
        bloodBankReserve = new HashMap<>();
        initializeBloodBankReserve();
    }

    private void initializeBloodBankReserve() {
        bloodBankReserve.put("A", 5);
        bloodBankReserve.put("AB", 3);
        bloodBankReserve.put("B", 1);
        bloodBankReserve.put("O", 4);
    }

    public void addDonor(Donor donor) {
        donorsByBloodGroup.computeIfAbsent(donor.getBloodGroup(), k -> new ArrayList<>()).add(donor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void allocateDonorsToPatients() {
        for (Patient patient : patients) {
            String bloodGroup = patient.getBloodGroup();
            int unitsNeeded = patient.getUnitsNeeded();
            String priority = patient.getPriority();

            List<Donor> availableDonors = donorsByBloodGroup.getOrDefault(bloodGroup, new ArrayList<>());
            for (Donor donor : availableDonors) {
                if (unitsNeeded > 0 && bloodBankReserve.get(bloodGroup) > 0) {
                    donorPatientMap.put(donor, patient);
                    unitsNeeded--;
                    bloodBankReserve.put(bloodGroup, bloodBankReserve.get(bloodGroup) - 1);
                    unitsNeeded--;
                    patient.setUnitsNeeded(unitsNeeded);
                    System.out.println("Patient: " + patient.getName() + ", Priority: " + priority + ", Donor: " + donor.getName());
                    break;
                }
            }
        }
    }

    public void displayDetails() {
        System.out.println("Donors by Blood Group: " + donorsByBloodGroup);
        System.out.println("Blood Bank Reserve: " + bloodBankReserve);
        System.out.println("Donor-Patient Allocation: " + donorPatientMap);
    }

    @Override
    public String toString() {
        return "BloodBank{" +
                "donorsByBloodGroup=" + donorsByBloodGroup +
                ", bloodBankReserve=" + bloodBankReserve +
                '}';
    }
}

public class BloodProgram {
    public static void main(String[] args) {
        BloodBank bloodBank = new BloodBank();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Donor\n2. Add Patient\n3. Allocate Donors to Patients\n4. Display Details\n5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline left in the buffer

            switch (choice) {
                case 1: {
                    System.out.println("Enter Donor details: ");
                    System.out.print("Name: ");
                    String donorName = scanner.nextLine();
                    System.out.print("Phone Number: ");
                    String donorNumber = scanner.nextLine();
                    System.out.print("Blood Group: ");
                    String donorBloodGroup = scanner.nextLine();
                    bloodBank.addDonor(new Donor(donorName, donorNumber, donorBloodGroup));
                }
                break;

                case 2: {
                    System.out.println("Enter Patient Details");
                    System.out.print("Name: ");
                    String pName = scanner.nextLine();
                    System.out.print("Priority (P1 to P10): ");
                    String pPriority = scanner.nextLine();
                    System.out.print("Blood Group: ");
                    String pBloodGroup = scanner.nextLine();
                    System.out.print("Units Needed: ");
                    int pUnits = scanner.nextInt();
                    scanner.nextLine();
                    bloodBank.addPatient(new Patient(pName, pPriority, pBloodGroup, pUnits));
                }
                break;

                case 3: {
                    bloodBank.allocateDonorsToPatients();
                }
                break;

                case 4: {
                    bloodBank.displayDetails();
                }
                break;

                case 5: {
                    System.exit(0);
                }
                break;

                default: {
                    System.out.println("Invalid Choice");
                }
                break;
            }
        }
    }
}

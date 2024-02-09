import java.util.ArrayList;
import java.util.List;

class Vehicle {
    private String registrationNumber;
    private String make;
    private String model;
    private double rentPerDay;

    public Vehicle(String registrationNumber, String make, String model, double rentPerDay) {
        this.registrationNumber = registrationNumber;
        this.make = make;
        this.model = model;
        this.rentPerDay = rentPerDay;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public double getRentPerDay() {
        return rentPerDay;
    }
}

class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String registrationNumber, String make, String model, double rentPerDay, int numberOfDoors) {
        super(registrationNumber, make, model, rentPerDay);
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }
}

class Bike extends Vehicle {
    private boolean hasBasket;

    public Bike(String registrationNumber, String make, String model, double rentPerDay, boolean hasBasket) {
        super(registrationNumber, make, model, rentPerDay);
        this.hasBasket = hasBasket;
    }

    public boolean hasBasket() {
        return hasBasket;
    }
}

class Customer {
    private String customerId;
    private String name;
    private String contactNumber;

    public Customer(String customerId, String name, String contactNumber) {
        this.customerId = customerId;
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }
}

class Rental {
    private String rentalId;
    private Vehicle vehicle;
    private Customer customer;
    private int days;

    public Rental(String rentalId, Vehicle vehicle, Customer customer, int days) {
        this.rentalId = rentalId;
        this.vehicle = vehicle;
        this.customer = customer;
        this.days = days;
    }

    public String getRentalId() {
        return rentalId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getDays() {
        return days;
    }

    public double calculateRentalCost() {
        return days * vehicle.getRentPerDay();
    }
}

class RentManagementSystem {
    private List<Vehicle> vehicles;
    private List<Customer> customers;
    private List<Rental> rentals;

    public RentManagementSystem() {
        this.vehicles = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.rentals = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void rentVehicle(String rentalId, Vehicle vehicle, Customer customer, int days) {
        Rental rental = new Rental(rentalId, vehicle, customer, days);
        rentals.add(rental);
    }

    public List<Rental> getAllRentals() {
        return rentals;
    }
}

public class Main {
    public static void main(String[] args) {
        RentManagementSystem rentSystem = new RentManagementSystem();

        Car car = new Car("CAR123", "Toyota", "Camry", 50.0, 4);
        Bike bike = new Bike("BIKE456", "Honda", "CBR600RR", 30.0, true);

        Customer customer = new Customer("CUST001", "John Doe", "123-456-7890");

        rentSystem.addVehicle(car);
        rentSystem.addVehicle(bike);
        rentSystem.addCustomer(customer);

        rentSystem.rentVehicle("RNT001", car, customer, 3);
        rentSystem.rentVehicle("RNT002", bike, customer, 5);

        List<Rental> allRentals = rentSystem.getAllRentals();
        for (Rental rental : allRentals) {
            System.out.println("Rental ID: " + rental.getRentalId());
            System.out.println("Vehicle: " + rental.getVehicle().getMake() + " " + rental.getVehicle().getModel());
            System.out.println("Customer: " + rental.getCustomer().getName());
            System.out.println("Rental Duration: " + rental.getDays() + " days");
            System.out.println("Total Rental Cost: $" + rental.calculateRentalCost());
            System.out.println();
        }
    }
}

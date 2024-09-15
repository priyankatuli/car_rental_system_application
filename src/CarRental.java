import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRental {

    final private List<Car> cars;
    final private List<Customer> customers;
    final private List<Rental> rentals;


    public CarRental(){

        cars = new ArrayList<>();
        customers =new ArrayList<>();
        rentals = new ArrayList<>();

    }

    public void addCar(Car car){
        cars.add(car);
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public void rentCar(Car car,Customer customer,int days){

        if(car.isAvailable()){ // here isAvailable = true;
            car.rent(); //isAvailable = false
            this.rentals.add(new Rental(car,customer,days));
        }else{
            System.out.println("Car isn't available for rent");

        }

    }

    public void returnCar(Car car){

        car.returnCar(); //isAvailable = true;
        Rental rentalToRemove = null;

        for(Rental rental : rentals){
            if(rental.getCar()==car){
                rentalToRemove = rental;
                break;
            }
        }
        if(rentalToRemove !=null){
            rentals.remove(rentalToRemove);
        }
        else{
            System.out.println("Car wasn't rented");
        }

    }

    public void Menu(){

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("------Car Rental System Application------");
            System.out.print("1. Rent a Car\n");
            System.out.print("2. Return a Car\n");
            System.out.print("3. Exit\n");
            System.out.print("4. Enter your choice: ");

            int choice = scanner.nextInt();
            //newline
            scanner.nextLine();

            if(choice ==1){
            System.out.print("\n=== Rent a Car ===\n");
            System.out.print("Enter your name: ");
            String customerName = scanner.nextLine();

            System.out.println("\nAvailable Cars: ");
            for (Car car : cars) {
                if (car.isAvailable()) {
                    System.out.println(car.getCarID() + " - " + car.getCarBrand() + " - " + car.getCarModel());
                }
            }

            System.out.print("\nEnter the car id you want to rent: ");
            String carId = scanner.nextLine();

            System.out.print("Enter the number of days for rental: ");
            int rentalDays = scanner.nextInt();

            scanner.nextLine();

            //for customer

            Customer newCustomer = new Customer("CUS" + (customers.size() + 1), customerName);
            addCustomer(newCustomer);

            Car selectedCar = null;
            for (Car car : cars) {
                if (car.getCarID().equals(carId) && car.isAvailable()) {
                    selectedCar = car;
                    break;
                }
            }

            if (selectedCar != null) {
                double totalPrice = selectedCar.calculatePrice(rentalDays);
                System.out.print("\n== Rental Information ==\n");
                System.out.println("Customer ID: " + newCustomer.getCustomerID());
                System.out.println("Customer Name: " + newCustomer.getCustomerName());
                System.out.println("Car Model: " + selectedCar.getCarModel());
                System.out.println("Car Brand: " + selectedCar.getCarBrand());
                System.out.println("Rental days: " + rentalDays);
                System.out.printf("Total Price: $%.2f%n", totalPrice);

                System.out.print("\nConfirm Rental(Yes/No): ");
                String confirm = scanner.nextLine();

                //equalsIgnoreCase to ignore capital and smaller case
                if (confirm.equalsIgnoreCase("Yes")) {
                    rentCar(selectedCar, newCustomer, rentalDays);
                    System.out.println("\nCar Rented Successfully.");
                } else {
                    System.out.println("\n Rental Cancelled");
                }
            } else {
                System.out.println("\nInvalid car selection or car not available for rent.");
            }
        }
            else if (choice == 2) {

                System.out.println("\n===Return a Car===");
                System.out.println("\nEnter the car id you want to return: ");
                String carId = scanner.nextLine();

                Car carToReturn = null;
                for (Car car : cars) {
                    if (car.getCarID().equals(carId) && !car.isAvailable()) {
                        carToReturn = car;
                        break;
                    }
                }

                if (carToReturn != null) {
                    Customer customer = null;
                    for (Rental rental : rentals) {
                        if (rental.getCar() == carToReturn) {
                            customer = rental.getCustomer();
                            break;
                        }
                    }

                    if (customer != null) {
                        returnCar(carToReturn);
                        System.out.println("Car returned successfully by " + customer.getCustomerName());
                    } else {
                        System.out.println("Car was not rented or rental information is missing.");
                    }
                } else {
                    System.out.println("Invalid car ID or car is not rented.");
                }

            } else if(choice == 3){
                break;
            } else{
                System.out.println("Invalid option!! please enter a valid option");
            }

        }
        System.out.println("\nThank you for using the Car rental system application.");
    }





}

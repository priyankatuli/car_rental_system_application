//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

          CarRental rentalSystem = new CarRental();

         //input for car information
        Car car1 = new Car("C001", "Toyota", "Camry", 600);
        Car car2 = new Car("C002", "Honda", "Accord", 700);
        Car car3 = new Car("C003", "Mahindra", "Thar", 800);

        Car car4=new Car("A001","Tesla","Tesla Model S",1000);
        Car car5=new Car("A002","Tesla","Model Y",2000);
        Car car6=new Car("A003","Tesla","Concept",3000);

        Car car7=new Car("B001","Suzuki","Across",3500);
        Car car8=new Car("B002","Suzuki","Alto",2500);
        Car car9=new Car("B003","BMW","Concept",1500);
        Car car10=new Car("D001","Audi","e-tron",4000);

        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);
        rentalSystem.addCar(car4);
        rentalSystem.addCar(car5);
        rentalSystem.addCar(car6);
        rentalSystem.addCar(car7);
        rentalSystem.addCar(car8);
        rentalSystem.addCar(car9);
        rentalSystem.addCar(car10);

        rentalSystem.Menu();


        }


    }

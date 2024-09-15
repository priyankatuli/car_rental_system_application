public class Rental {

    final private Car car;
    final private Customer customer;
   final private int days;

    Rental(Car car,Customer customer,int days){
        this.car = car;
        this.customer = customer;
        this.days = days;
    }

    public Car getCar(){
        return this.car;
    }
    public Customer getCustomer(){
        return this.customer;
    }

   public int getDays() {
       return this.days;
   }

}

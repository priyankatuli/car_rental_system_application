public class Customer {

    final private String customerID;
    final private String customerName;


    Customer(String CustomerID,String CustomerName){

        this.customerID = CustomerID;
        this.customerName = CustomerName;
    }

    public String getCustomerID() {
        return this.customerID;
    }
    public String getCustomerName(){
        return this.customerName;
    }
}

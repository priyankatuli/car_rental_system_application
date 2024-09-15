public class Car {

    final private String carID;
    final private String model;
    final private String brand;
    final private int basePricePerDay;
    private boolean isAvailable;


    Car(String carID,String model,String brand,int basePricePerDay){
        this.carID = carID;
        this.model = model;
        this.brand = brand;
        this.basePricePerDay = basePricePerDay;
        this.isAvailable = true;
    }
//getter method
    public String getCarID(){
        return this.carID;
    }

    public String getCarModel(){
        return this.model;
    }
    public String getCarBrand(){
        return this.brand;
    }

//method
  public int calculatePrice(int rentalDays){
        return (this.basePricePerDay*rentalDays);
  }

    public boolean isAvailable(){
        return this.isAvailable;
    }

public void rent(){
     this.isAvailable = false;
}

public void returnCar(){
        this.isAvailable = true;
}

}

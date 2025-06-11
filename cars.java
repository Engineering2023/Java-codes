package med;
import java.util.Scanner;

public class cars {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Car Details");
        String input = sc.nextLine();

        CarInfo car = extractDetails(input);

        if (car == null) {
            System.out.println("Invalid Details");
            return;
        }

        System.out.println("Car Id : " + car.getCarId());
        System.out.println("CarName:" + car.getCarName());
        System.out.println("CarType:" + car.getCarType());
        System.out.println("City : " + car.getCity());

        String result = car.checkAvailability();
        if (result.equals("Not Available")) {
            System.out.println("Invalid Details");
        } else {
            System.out.println(result);
        }
    }

    public static CarInfo extractDetails(String carDetails) {
        String[] parts = carDetails.split(":");
        if (parts.length != 4) {
            return null;
        }
        return new CarInfo(parts[0], parts[1], parts[2], parts[3]);
    }
}

class CarInfo {
    private String carId;
    private String carName;
    private String carType;
    private String city;

    public CarInfo(String carId, String carName, String carType, String city) {
        this.carId = carId;
        this.carName = carName;
        this.carType = carType;
        this.city = city;
    }

    public String getCarId() {
        return carId;
    }

    public String getCarName() {
        return carName;
    }

    public String getCarType() {
        return carType;
    }

    public String getCity() {
        return city;
    }

    public String checkAvailability() {
        String carNameLower = carName.toLowerCase();
        String carTypeLower = carType.toLowerCase();
        String cityLower = city.toLowerCase();

        if (!(carNameLower.equals("nissan") || carNameLower.equals("ford"))) {
            return "Not Available";
        }

        if (!(carTypeLower.equals("sedan") || carTypeLower.equals("suv") || carTypeLower.equals("muv"))) {
            return "Not Available";
        }

        if (!(cityLower.equals("new york") || cityLower.equals("denver") || cityLower.equals("losangels"))) {
            return "Not Available";
        }

        String availableCar = "";
        double price = 0;

        if (carNameLower.equals("nissan")) {
            switch (carTypeLower) {
                case "sedan":
                    availableCar = "Kicks";
                    price = 8400.0;
                    break;
                case "suv":
                    availableCar = "Magnite";
                    price = 10800.0;
                    break;
                case "muv":
                    availableCar = "Terrano";
                    price = 14400.0;
                    break;
            }
        } else if (carNameLower.equals("ford")) {
            switch (carTypeLower) {
                case "sedan":
                    availableCar = "Figo";
                    price = 4802.0;
                    break;
                case "suv":
                    availableCar = "Eco Sport";
                    price = 9605.0;
                    break;
                case "muv":
                    availableCar = "Endeavour";
                    price = 21600.0;
                    break;
            }
        }

        return "Availablecarandpriceis:" + availableCar + "and$" + price;
    }
}
package com.example.app.CarServiceApplication.data;
import java.util.ArrayList;

public class Database {
    private ArrayList<Part> partArrayList =  new ArrayList<>();
    private ArrayList<Owner> ownerArrayList =  new ArrayList<>();
    private ArrayList<CarService> carServiceArrayList =  new ArrayList<>();

    public Database() {
        partArrayList.add(new Part(1, "shock absorber", 2021));
        partArrayList.add(new Part(2, "front headlight", 2008));
        partArrayList.add(new Part(3, "fuel filter", 2021));
        partArrayList.add(new Part(4, "oil filter", 2020));
        partArrayList.add(new Part(5, "front bumper", 2021));
        partArrayList.add(new Part(6, "gas tank", 2021));
        partArrayList.add(new Part(7, "hood", 2021));
        partArrayList.add(new Part(8, "front glass", 2020));
        partArrayList.add(new Part(9, "exhaust pipe", 2018));
        partArrayList.add(new Part(10, "accumulator", 2021));

        ownerArrayList.add(new Owner(1, "Ivan", 2));
        ownerArrayList.add(new Owner(2, "Valeriy", 7));
        ownerArrayList.add(new Owner(3, "Volodymyr", 9));
        ownerArrayList.add(new Owner(4, "Petro", 11));
        ownerArrayList.add(new Owner(5, "Anna", 3));
        ownerArrayList.add(new Owner(6, "Maria", 17));
        ownerArrayList.add(new Owner(7, "Marta", 45));
        ownerArrayList.add(new Owner(8, "Olexander", 2));
        ownerArrayList.add(new Owner(9, "Roman", 5));
        ownerArrayList.add(new Owner(10, "Vasyl", 1));

        carServiceArrayList.add(new CarService(1, "Zelena 104", 5));
        carServiceArrayList.add(new CarService(2, "Horodotska 28", 4));
        carServiceArrayList.add(new CarService(3, "Knyahyni Olhy 295", 10));
        carServiceArrayList.add(new CarService(4, "Khmelnytskogo 25", 10));
        carServiceArrayList.add(new CarService(5, "Bandery 118", 8));

    }
    public void setBookArrayList(Part part) {
        partArrayList.add(part);
    }

    public ArrayList<Part> getBookArrayList() {
        return partArrayList;
    }

    public ArrayList<Owner> getOwnerArrayList() {
        return ownerArrayList;
    }

    public ArrayList<CarService> getCarServiceArrayList() {
        return carServiceArrayList;
    }

    public void setownerArrayList(Owner owner) {
        ownerArrayList.add(owner);
    }

    public void setCarServiceArrayList(CarService carService) {
        carServiceArrayList.add(carService);
    }
}

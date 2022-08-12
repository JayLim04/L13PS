package sg.edu.rp.c346.id21033869.l13ps;

public class Carpark {
    int totalLots;
    String lotType;
    String lotsAvailable;
    String carparkNumber;

    public Carpark(int totalLots, String lotType, String lotsAvailable,String carparkNumber) {
        this.totalLots = totalLots;
        this.lotType = lotType;
        this.lotsAvailable=lotsAvailable;
        this.carpark_number = carparkNumber;
    }

    public String getCarparkNumber() {
        return carparkNumber;
    }

    public void setCarparkNumber(String carparkNumber) {
        this.carparkNumber = carparkNumber;
    }

    public int getTotalLots() {
        return totalLots;
    }

    public void setTotalLots(int totalLots) {
        this.totalLots = totalLots;
    }

    public String getLotType() {
        return lotType;
    }

    public void setLotType(String lotType) {
        this.lotType = lotType;
    }

    public String getLotsAvailable() {
        return lotsAvailable;
    }

    public void setLotsAvailable(String lotsAvailable) {
        this.lotsAvailable = lotsAvailable;
    }

    public String getCarpark_number() {
        return carpark_number;
    }

    public void setCarpark_number(String carpark_number) {
        this.carpark_number = carpark_number;
    }

    String carpark_number;

    @Override
    public String toString() {
        return "Carpark{" +
                "totalLots=" + totalLots +
                ", lotType='" + lotType + '\'' +
                ", lotsAvailable='" + lotsAvailable + '\'' +
                ", carpark_number='" + carpark_number + '\'' +
                '}';
    }
}

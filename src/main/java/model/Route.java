package model;

public class Route {
    private City startLocation;
    private City endLocation;
    private double distance;
    private double time;


    public Route(City startLocation, City endLocation) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.distance = calculateDistance();
        this.time = calculateTime();
    }


    public City getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(City startLocation) {
        this.startLocation = startLocation;
    }


    public City getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(City endLocation) {
        this.endLocation = endLocation;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }


    public double getTime() {
        return time;
    }


    public void setTime(double time) {
        this.time = time;
    }


    private double calculateDistance() {
        double dLat = Math.toRadians(endLocation.getLatitude() - startLocation.getLatitude());
        double dLon = Math.toRadians(endLocation.getLength() - startLocation.getLength());
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(startLocation.getLatitude())) * Math.cos(Math.toRadians(endLocation.getLatitude()))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return 6371 * c;
    }


    private double calculateTime() {
        double speed = 57; // km/h
        return distance / speed;
    }
}

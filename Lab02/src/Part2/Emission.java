package Part2;

public class Emission {
    private double co2;
    private double n2o;
    private double ch4;

    public Emission(double co2, double n20, double ch4){
        this.co2 = co2;
        this.n2o = n20;
        this.ch4 = ch4;
    }

    private void setCO2(double co2) {
        this.co2 = co2;
    }

    private void setN2O(double n2o) {
        this.n2o = n2o;
    }

    private void setCH4(double ch4) {
        this.ch4 = ch4;
    }

    public double getCO2() {
        return co2;
    }

    public double getN2O() {
        return n2o;
    }

    public double getCH4() {
        return ch4;
    }
}

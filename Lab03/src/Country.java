import java.util.List;
import java.util.Map;

public class Country implements GreenhouseGasEmitter{
    private String name;
    private Map<Integer, Emission> emissions;

    public Country(String name, Map<Integer, Emission> emissions){
        this.name = name;
        this.emissions = emissions;
    }

    public int getYearWithHighestEmissions(){
        int maxYear = 0;
        double maxEmissions = 0;
        double currentEmissions;
        for(Integer key: this.emissions.keySet()){
            currentEmissions = this.emissions.get(key).getCO2() + this.emissions.get(key).getN2O() + this.emissions.get(key).getCH4();
            if (currentEmissions > maxEmissions){
                maxEmissions = currentEmissions;
                maxYear = key;
            }
        }
        return maxYear;
    }

    public static Country countryWithHighestCH4InYear(List<Country> countries, int year){
        Country maxCountry = null;
        double maxCH4 = 0;
        for (Country countryIndex : countries){
            if (countryIndex.getEmissions().get(year).getCH4() > maxCH4){
                maxCountry = countryIndex;
                maxCH4 = countryIndex.getEmissions().get(year).getCH4();
            }
        }
        return maxCountry;
    }

    public static Country countryWithHighestChangeInEmissions(List<Country> countries, int startYear, int endYear){
        Country maxCountry = null;
        double maxIncrease = 0;

        for (Country countryIndex: countries){
            double startEmissions = countryIndex.getEmissions().get(startYear).getCO2() + countryIndex.getEmissions().get(startYear).getN2O() + countryIndex.getEmissions().get(startYear).getCH4();
            double endEmissions = countryIndex.getEmissions().get(endYear).getCO2() + countryIndex.getEmissions().get(endYear).getN2O() + countryIndex.getEmissions().get(endYear).getCH4();
            double changeInEmissions = endEmissions - startEmissions;
            if (changeInEmissions >= maxIncrease){
                maxIncrease = changeInEmissions;
                maxCountry = countryIndex;
            }
        }
        return maxCountry;
    }

    public String getName() {
        return name;
    }

    @Override
    public double getTotalEmissionsInYear(int year) {
        return this.getEmissions().get(year).getN2O() + this.getEmissions().get(year).getCO2() + this.getEmissions().get(year).getCH4();
    }

    public Map<Integer, Emission> getEmissions() {
        return emissions;
    }

}

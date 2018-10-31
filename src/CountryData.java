import java.util.LinkedHashMap;
import java.util.Map;

class CountryData {
    private String name;
    private Map<String, String> populationByYear = new LinkedHashMap<>();

    CountryData(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    Map<String, String> getPopulationByYear() {
        return new LinkedHashMap<>(populationByYear);
    }

    void setPopulationByYear(String year, String data) {
        populationByYear.put(year, data);
    }
}

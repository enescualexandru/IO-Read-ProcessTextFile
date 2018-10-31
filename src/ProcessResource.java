import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

class ProcessResource {

    private URLConnection source = null;
    private static List<CountryData> countryData = new ArrayList<>();

    void processData(String url) {
        try {
            System.out.println("Connecting to the source...");
            source = new URL(url).openConnection();
            source.connect();
            System.out.println("Connected...");
        } catch (IOException e) {
            System.out.println("ProcessResource.processUrl message: " + e.getMessage());
        }
        try (BufferedReader in = new BufferedReader(new InputStreamReader(source.getInputStream()))) {
            System.out.println("Start fetching data...");
            String line = in.readLine();
            String[] years = line.split(",");
            while ((line = in.readLine()) != null) {
                String[] data = line.split(",");
                CountryData country = new CountryData(data[0]);
                for (int i = 1; i < years.length; i++) {
                    country.setPopulationByYear(years[i], data[i]);
                }
                countryData.add(country);
            }
            System.out.println("Finished processing data...");
        } catch (IOException e) {
            System.out.println("ProcessResource.process() message: " + e.getMessage());
        }
    }

    static List<CountryData> getCountryData() {
        return  new ArrayList<>(countryData);
    }
}

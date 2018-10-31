import java.util.Map;
import java.util.Scanner;


class CountryFinder {

    void init() {
        boolean doSearch = true;
        while (doSearch) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter a country to retrieve data(press 'q' to quit: ");
            String opt = scanner.nextLine();
            if (opt.equals("q") || opt.equals("quit")) {
                doSearch = false;
            } else {
                printCountryData(opt);
            }
        }
    }

    private void printCountryData(String opt) {
        for (CountryData country : ProcessResource.getCountryData()) {
            String name = country.getName();
            if (name.toLowerCase().contains(opt.toLowerCase())) {
                System.out.println("Data for the country: \n\n" + country.getName()+"\n");
                System.out.println("Year\t   Population\n");
                // System.out.println();
                for (Map.Entry<String, String> entry : country.getPopulationByYear().entrySet()) {
                    String year = entry.getKey();
                    String value = entry.getValue();
                    // System.out.print("Year: " + year + "   Population: " + value);
                    //System.out.println(year + "\t\t" + value);
                   // System.out.println("---------------------");
                    System.out.printf("%s\t\t%.9s\n", year, value);
                    System.out.print("---------------------\n");
                }
                System.out.println();
                return;
            }
        }
        System.out.println("No such country exists !");
    }
}

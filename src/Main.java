public class Main {

    public static void main(String[] args) {
        String address = "https://openei.org/doe-opendata/dataset/a7fea769-691d-4536-8ed3-471e993a2445/resource/86c50aa8-e40f-4859-b52e-29bb10166456/download/populationbycountry19802010millions.csv";

        ProcessResource processResource = new ProcessResource();
        //processResource.processUrl(address);
        processResource.processData(address);

        new CountryFinder().init();
    }
}

package prog6112_poe;
import java.util.*;

public class SeriesApp {
    private Scanner sc;
    private ArrayList<Series> seriesList;

    public SeriesApp(Scanner sc) {
        this.sc = sc;
        this.seriesList = new ArrayList<>();
    }

    // Capture a new series
    public void CaptureSeries() {
        System.out.println("CAPTURE A NEW SERIES");
        System.out.print("Enter Series ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Series Name: ");
        String name = sc.nextLine();

        String age;
        while (true) {
            System.out.print("Enter Age Restriction (2 - 18): ");
            age = sc.nextLine();
            try {
                int ageInt = Integer.parseInt(age);
                if (ageInt >= 2 && ageInt <= 18) break;
                else System.out.println("Invalid age restriction. Please enter between 2 and 18.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        System.out.print("Enter Number of Episodes: ");
        String episodes = sc.nextLine();

        Series newSeries = new Series(id, name, age, episodes);
        seriesList.add(newSeries);

        System.out.println("Series details have been successfully saved!");
    }

    // Search for a series
    public void SearchSeries(ArrayList<Series> seriesList) {
        System.out.print("Enter Series ID to search: ");
        String searchSeriesID = sc.nextLine();

        for (Series s : seriesList) {
            if (s.SeriesID.equalsIgnoreCase(searchSeriesID)) {
                System.out.println("Series found:\n" + s);
                
                return;
            }
        }
        System.out.println("No series details could be found.");
    }

    // Update series
    public void UpdateSeries(ArrayList<Series> seriesList) {
        System.out.print("Enter Series ID to update: ");
        String searchSeriesID = sc.nextLine();

        for (Series s : seriesList) {
            if (s.SeriesID.equalsIgnoreCase(searchSeriesID)) {
                String newAge;
                while (true) {
                    System.out.print("Enter new Age Restriction (2 - 18): ");
                    newAge = sc.nextLine();
                    try {
                        int ageInt = Integer.parseInt(newAge);
                        if (ageInt >= 2 && ageInt <= 18) break;
                        else System.out.println("Invalid age restriction. Please enter between 2 and 18.");
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number.");
                    }
                }
                s.SeriesAge = newAge;

                System.out.print("Enter new Number of Episodes: ");
                String newEpisodes = sc.nextLine();
                s.SeriesNumberOfEpisodes = newEpisodes;

                System.out.println("Series updated successfully!");
                return;
            }
        }
        System.out.println("Series not found.");
    }

    // Delete series
    public void DeleteSeries() {
        System.out.print("Enter Series ID to delete: ");
        String deleteSeriesID = sc.nextLine();

        Iterator<Series> iterator = seriesList.iterator();
        while (iterator.hasNext()) {
            Series s = iterator.next();
            if (s.SeriesID.equalsIgnoreCase(deleteSeriesID)) {
                System.out.print("Are you sure you want to delete this series? (yes/no): ");
                String confirm = sc.nextLine();
                if (confirm.equalsIgnoreCase("yes")) {
                    iterator.remove();
                    System.out.println("Series deleted successfully!");
                } else {
                    System.out.println("Delete cancelled.");
                }
                return;
            }
        }
        System.out.println("Series not found.");
    }

    //Print report
    public void SeriesReport() {
        System.out.println("\n--- Series Report ---");
        if (seriesList.isEmpty()) {
            System.out.println("No series captured yet.");
        } else {
            for (Series s : seriesList) {
                System.out.println(s);
            }
        }
    }

    //Exit
    public void ExitSeriesApplication() {
        System.out.println("Exiting application... Goodbye!");
        System.exit(0);
    }

    public void testAddSeries(Series series) {
        throw new UnsupportedOperationException("Not supported yet."); //from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Series testSearchSeries(String friends) {
        throw new UnsupportedOperationException("Not supported yet."); // from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean testUpdateSeries(String friends, String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); // from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean testDeleteSeries(String breaking_Bad) {
        throw new UnsupportedOperationException("Not supported yet."); // from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean testValidateAge(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

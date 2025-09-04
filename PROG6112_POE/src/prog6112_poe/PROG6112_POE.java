
package prog6112_poe;
import java.util.ArrayList;
import java.util.Scanner;

public class PROG6112_POE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Series> seriesList = new ArrayList<>();

        System.out.println("Latest Series - 2025\n****************************");
        System.out.println("Enter(1) to launch menu or any other key to exit");
        String menu = sc.nextLine();

        if (menu.equals("1")) {
            SeriesApp seriesApp = new SeriesApp(sc);

            while (true) {
                System.out.println("\nPlease select one of the following menu items:\n"
                        + "(1) Capture a new series \n"
                        + "(2) Search for a series\n"
                        + "(3) Update series age restriction\n"
                        + "(4) Delete a series\n"
                        + "(5) Print series report - 2025\n"
                        + "(6) Exit application");

                String choice = sc.nextLine();

                switch (choice) {
                    case "1":
                        seriesApp.CaptureSeries();
                        break;
                    case "2":
                        seriesApp.SearchSeries(seriesList);
                        break;
                    case "3":
                        seriesApp.UpdateSeries(seriesList);
                        break;
                    case "4":
                        seriesApp.DeleteSeries();
                        break;
                    case "5":
                        seriesApp.SeriesReport();
                        break;
                    case "6":
                        seriesApp.ExitSeriesApplication();
                        break;
                    default:
                        System.out.println("Invalid option. Try again.\n");
                }
            }
        }
    }
}
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {

        Scanner scanner = new Scanner(System.in);
        String file = "randomlinks.txt"; //File name, can make your own or use my current one.

        boolean valid; // use to check if a valid number was entered.

        String hour;
        // Checks your input for hour. If it is not between 0 - 12 you will be asked to reinput it
        do {
            System.out.println("\nEnter the hour: ");
            hour = scanner.nextLine();
            valid = Integer.valueOf(hour) > 0 && Integer.valueOf(hour) <=12;
            if(!valid) {
                System.out.println("Please enter a number between 00-12");
            }
        }while (!valid);

        String minute;
        // Checks your input for minute. If it is not between 00-59 you will be asked to reinput it.
        do {
            System.out.println("\nEnter the minute: ");
            minute = scanner.nextLine();
            valid = Integer.valueOf(minute) >= 0 && Integer.valueOf(minute) <60;
            if(!valid) {
                System.out.println("Please enter a number between 00-59");
            }
        }while(!valid);

        String a;
        /*
        I live in a country that uses a 12-hour time period, so we use AM or PM to
        tell which period it is in. Here it asks for what period we are in and
        checks to make sure you entering am or pm.
         */
        do {
            System.out.println("\nAM or PM? ");
            a = scanner.nextLine();
            a = a.trim().toUpperCase();
            valid = a.equals("AM")  || a.equals("PM");
            if(!valid) {
                System.out.println("Please make sure you enter AM or PM.");
            }
        }while(!valid);

        String alarm = hour + ":" + minute + " " + a; //Combines the strings
        String currentTime = getCurrentTime(); //Gets the time of the local system

        System.out.println("\nAlarm time: " + alarm);
        System.out.println("Current system time: " + currentTime);

        //While loop runs infinitely until the currentSystemTime equals the Alarm time.
        while(true) {
            String currentSystemTime = getCurrentTime();
            if (alarm.equals(currentSystemTime)) {
                /*
                Once they are equal, java should use your default browser to open
                up a random link that I have in my text file.
                 */
                System.out.println("\nRING RING RING here is your video! :)");
                Desktop.getDesktop().browse(new URI(getLink(file)));
                break;
            }
        }
    }
    // This method grabs a random link from a text file
    public static String getLink (String file) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> links = new ArrayList<>();

        try (Scanner scan = new Scanner(Paths.get(file))){
            while (scan.hasNextLine()) {
                links.add(scan.nextLine());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Random random = new Random();

        return links.get(random.nextInt(links.size()));
    }
    // Returns the current time as a String.
    public static String getCurrentTime() {
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm a"));
        return time;
    }
}

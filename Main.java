import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* This program creates vehicle objects by reading information from
* a text file.
*
* @author Layla Michel
* @version 1.0
* @since 2022-05-16
*/

final class Main {
    /**
    * Index of car number.
    */
    static final int CAR_NUM_INDEX = 0;

    /**
    * Index of license plate.
    */
    static final int LICENSE_INDEX = 1;

    /**
    * Index of car colour.
    */
    static final int COLOUR_INDEX = 2;

    /**
    * Index of car door number.
    */
    static final int DOORS_NUM_INDEX = 3;

    /**
    * Index of car speed.
    */
    static final int SPEED_INDEX = 4;

    /**
    * Index of car max speed.
    */
    static final int MAX_SPEED_INDEX = 5;

    /**
    * String "0".
    */
    static final String STRING_ZERO = "0";

    /**
    * Array of car info.
    */
    private static String[] carInfoArray;

    /**
    * Default constructor.
    */
    private Main() { }

    /**
    * Creating main function.
    *
    * @param args nothing passed in
    * @throws IOException if no file is passed in
    */
    public static void main(String[] args)
            throws IOException {
        // Create list to get the strings
        final List<String> listCarInfo =
            new ArrayList<String>();

        BufferedReader buffer = null;
        try {
            // Check if there are some arguments
            if (null != args[0]
                // Length > 4 because a.txt will be shortest filename
                && args[0].length() > 4
                // Check if arguments have the correct file extension
                && args[0].endsWith(".txt")) {
                buffer = new BufferedReader(new FileReader(args[0]));
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        String line = buffer.readLine();

        // Add file elements to list
        while (line != null) {
            listCarInfo.add(line);
            line = buffer.readLine();
        }

        // Create array of car info of the size of the list
        carInfoArray = listCarInfo.toArray(new String[0]);

        for (int counter = 0; counter < carInfoArray.length; counter++) {
            final List<String> list = new ArrayList<String>(Arrays.asList(
                carInfoArray[counter].split(" ")));

            for (int counter2 = 0; counter2 < list.size(); counter2++) {
                if (counter2 == CAR_NUM_INDEX) {
                    try {
                        // Check if the car number is an integer
                        Integer.parseInt(list.toArray(
                            new String[0])[counter2]);
                    } catch (NumberFormatException exception) {
                        // Set the car number value to null if
                        // the input is invalid
                        list.set(counter2, "null");
                    }
                } else if (counter2 == LICENSE_INDEX) {
                    // Check if a license plate was written
                    if (list.toArray(new String[0])
                        [counter2] == null) {
                        // Set the license plate to XXX XXX
                        // if the field is empty
                        list.set(counter2, "XXX XXX");
                    }
                } else if (counter2 == DOORS_NUM_INDEX) {
                    try {
                        // Check if the number of doors is an integer
                        Integer.parseInt(list.toArray(
                            new String[0])[counter2]);
                    } catch (NumberFormatException exception) {
                        // Set the door number value to "0"
                        // if the input is invalid
                        list.set(counter2, STRING_ZERO);
                    }
                } else if (counter2 == SPEED_INDEX) {
                    try {
                        // Check if the speed is an integer
                        Integer.parseInt(list.toArray(
                            new String[0])[counter2]);
                    } catch (NumberFormatException exception) {
                        // Set the speed value to "0"
                        // if the input is invalid
                        list.set(counter2, STRING_ZERO);
                    }
                } else if (counter2 == MAX_SPEED_INDEX) {
                    try {
                        // Check if the max speed is an integer
                        Integer.parseInt(list.toArray(
                            new String[0])[counter2]);
                    } catch (NumberFormatException exception) {
                        // Set the max speed value to "0"
                        // if the input is invalid
                        list.set(counter2, STRING_ZERO);
                    }
                }
            }

            // Create aVehicle object containing the information of each string
            final Vehicle aVehicle = new Vehicle(
                list.toArray(new String[0])[CAR_NUM_INDEX],
                list.toArray(new String[0])[LICENSE_INDEX],
                list.toArray(new String[0])[COLOUR_INDEX],
                list.toArray(new String[0])[DOORS_NUM_INDEX],
                list.toArray(new String[0])[SPEED_INDEX],
                list.toArray(new String[0])[MAX_SPEED_INDEX]);

            // Get the current speed of the car
            aVehicle.getSpeed();

            // Get the max speed of the car
            aVehicle.getMaxSpeed();

            // Accelerate the car by 10 km/h
            aVehicle.accelerate("10");

            // Deceleration the car by 10 km/h
            aVehicle.brake("5");

            // Get the car's information
            aVehicle.getInfo();
        }
    }
}

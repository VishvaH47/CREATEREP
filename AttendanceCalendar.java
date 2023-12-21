import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AttendanceCalendar {

    public static void main(String[] args) {
        Map<String, Map<String, Boolean>> attendanceData = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter username (type 'exit' to quit): ");
            String username = scanner.nextLine();

            if (username.equalsIgnoreCase("exit")) {
                break;
            }

            // Initialize user's attendance map if not present
            attendanceData.putIfAbsent(username, new HashMap<>());

            System.out.println("Enter date (YYYY-MM-DD): ");
            String date = scanner.nextLine();

            System.out.println("Is " + username + " present on " + date + "? (yes/no): ");
            String attendanceInput = scanner.nextLine().toLowerCase();

            // Mark attendance based on user input
            boolean isPresent = attendanceInput.equals("yes");
            attendanceData.get(username).put(date, isPresent);

            System.out.println("Attendance marked for " + username + " on " + date);
        }

        // Display attendance data
        System.out.println("Attendance Data:");
        for (Map.Entry<String, Map<String, Boolean>> entry : attendanceData.entrySet()) {
            String username = entry.getKey();
            Map<String, Boolean> userAttendance = entry.getValue();

            System.out.println(username + ": " + userAttendance);
        }
    }
}


}
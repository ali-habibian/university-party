import java.util.Scanner;

public class University {
    public static final double UNI_LAT = 35.7036;
    public static final double UNI_LON = 51.3515;
    public static final int EMPLOYEES_SIZE = 10;

    Scanner input = new Scanner(System.in);

    private Employee[] employees;

    public void AddEmployee() {
        employees = new Employee[EMPLOYEES_SIZE];

        for (int i = 0; i < EMPLOYEES_SIZE; i++) {
            Location location = new Location();

            System.out.print("Enter Id: ");
            int id = input.nextInt();

            System.out.print("Enter First Name: ");
            String firstName = input.next();

            System.out.print("Enter Last Name: ");
            String lastName = input.next();

            System.out.print("Enter Gender: ");
            String gender = input.next();

            System.out.print("Location latitude: ");
            location.setLatitude(input.nextDouble());

            System.out.print("Location longitude: ");
            location.setLongitude(input.nextDouble());

            employees[i] = new Employee(id, firstName, lastName, gender, location);
        }
    }

    public void AddPartner() {
        System.out.print("Enter Id: ");
        int id = input.nextInt();
        if (id > employees.length - 1) {
            System.out.print("Id is not in range");
        } else {
            for (Employee employee : employees) {
                if (employee.getId() == id) {
                    System.out.print("Enter Partner Id: ");
                    int partnerID = input.nextInt();
                    for (Employee partner : employees) {
                        if (partner.getId() == partnerID &&
                                !partner.getGender().equals(employee.getGender())) {
                            partner.setPartner(employee);
                            employee.setPartner(partner);
                        }
                    }
                }
            }
        }
    }

    public void IsMarried() {
        System.out.print("Enter Id: ");
        int id = input.nextInt();
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                if (employee.getPartner() != null) {
                    System.out.print("Yes His/Her Partner is: ");
                    System.out.println(employee.getPartner().toString());
                } else {
                    System.out.println("No");
                }
            }
        }
    }

    public void checkInvited() {
        System.out.print("Enter Id: ");
        int id = input.nextInt();
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                double lat = employee.getLocation().getLatitude();
                double lon = employee.getLocation().getLongitude();
                if (employee.getPartner() != null &&
                        distance(lat, UNI_LAT, lon, UNI_LON) < 30000) {
                    System.out.println("Invited");
                } else {
                    System.out.println("Not Invited");
                }
            }
        }
    }

    public void invitedEmployees() {
        for (Employee employee : employees) {
            double lat = employee.getLocation().getLatitude();
            double lon = employee.getLocation().getLongitude();
            if (employee.getPartner() != null &&
                    distance(lat, UNI_LAT, lon, UNI_LON) < 30000) {
                System.out.println(employee);
            }
        }
    }

    /**
     * Calculate distance between two points in latitude and longitude taking
     * into account height difference. If you are not interested in height
     * difference pass 0.0. Uses Haversine method as its base.
     * <p>
     * lat1, lon1 Start point lat2, lon2 End point el1 Start altitude in meters
     * el2 End altitude in meters
     *
     * @return Distance in Meters
     */
    public static double distance(double lat1, double lat2, double lon1,
                                  double lon2) {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c * 1000;
    }
}

public class Employee {
    private int id;
    private String firsName;
    private String lastName;
    private String gender;
    private Location location;
    private Employee partner;

    public Employee(int id, String firsName, String lastName, String gender, Location location) {
        this.id = id;
        this.firsName = firsName;
        this.lastName = lastName;
        this.gender = gender;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public String getFirsName() {
        return firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Employee getPartner() {
        return partner;
    }

    public void setPartner(Employee partner) {
        this.partner = partner;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", firsName='" + firsName + '\'' +
                ", lastName='" + lastName + '\'' +
                '\n';
    }
}

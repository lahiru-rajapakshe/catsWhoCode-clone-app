package online.lahiru.sprinngbotrestapi.bean;

public class Student {
    private String  id;
    private String fullName;
    private String  lastName;

    public Student(String id, String fullName, String lastName) {
        this.id = id;
        this.fullName = fullName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

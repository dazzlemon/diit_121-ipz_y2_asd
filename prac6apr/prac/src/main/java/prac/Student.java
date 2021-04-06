package prac;

import java.util.Objects;

public class Student {
    private String firstName;
    private String lastName;
    private int    groupId;


    public Student(String firstName, String lastName, int groupId) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.groupId   = groupId;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Student)) {
            return false;
        }
        var sOther = (Student) other;
        return Objects.equals(firstName, sOther.firstName) &&
               Objects.equals(lastName,  sOther.lastName) &&
               Objects.equals(groupId,   sOther.groupId);
    }


    @Override
    public int hashCode() {
        return firstName.hashCode();
    }


    @Override
    public String toString() {
        return String.format(
            "Student: { firstName: %s, lastName: %s, groupId: %s }",
            firstName, lastName, groupId
        );
    }
}

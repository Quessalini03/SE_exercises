import java.util.Scanner;

class Person {
    private String name;
    private String address;

    Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return "Persion[name=" + this.name + ",address=" + this.address + "]";
    }
}

class Student extends Person {
    private String program;
    private int year;
    private double fee;

    Student(String name, String address, String program, int year, double fee) {
        super(name, address);
        this.program = program;
        this.year = year;
        this.fee = fee;
    }

    public String getProgram() {
        return this.program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getFee() {
        return this.fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String toString() {
        return "Student[" + super.toString() + ",program=" + this.program + ",year=" + this.year + ",fee=" + this.fee + "]";
    }
}

class Staff extends Person {
    private String school;
    private double pay;

    Staff(String name, String address, String school, double pay) {
        super(name, address);
        this.school = school;
        this.pay = pay;
    }

    public String getSchool() {
        return this.school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public double getPay() {
        return this.pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public String toString() {
        return "Staff[" + super.toString() + ",school=" + this.school + ",pay=" + this.pay + "]";
    }
}

public class Exercise2 {
    public static void main(String args[]) {
        // Scanner scanner = new Scanner(System.in);

        Student [] students = new Student[5];

        for (int i = 0; i < 5; i++) {
            students[i] = new Student("Student " + (i + 1), "Address " + (i + 1), "Computer Science", 2069, 40.0);
        }

        for (int i = 0; i < 5; i++) {
            students[i].setYear(2023);
        }

        for (int i = 0; i < 5; i++) {
            System.out.print(students[i].toString() + '\n');
        }

        Staff staff = new Staff("Staff" , "Home", "BK", 69.0);

        staff.setAddress("KHTN");
    }
}

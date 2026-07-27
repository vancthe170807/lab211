package model;

/**
 * Represent a Student entity with properties and boundaries validations.
 */
public class Student {

    private String id;
    private String name;
    private int age;
    private double math;
    private double physics;
    private double chemistry;

    /**
     * Default constructor
     */
    public Student() {
    }

    /**
     * Constructor for Student
     * 
     * @param id Student ID
     * @param name Student name
     * @param age Student age
     * @param math Math score
     * @param physics Physics score
     * @param chemistry Chemistry score
     */
    public Student(String id, String name, int age, double math, double physics, double chemistry) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.math = math;
        this.physics = physics;
        this.chemistry = chemistry;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Student ID cannot be empty.");
        }
        this.id = id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be empty.");
        }
        this.name = name.trim();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or older.");
        }
        this.age = age;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        if (math < 0 || math > 10) {
            throw new IllegalArgumentException("Math grade must be between 0 and 10.");
        }
        this.math = math;
    }

    public double getPhysics() {
        return physics;
    }

    public void setPhysics(double physics) {
        if (physics < 0 || physics > 10) {
            throw new IllegalArgumentException("Physics grade must be between 0 and 10.");
        }
        this.physics = physics;
    }

    public double getChemistry() {
        return chemistry;
    }

    public void setChemistry(double chemistry) {
        if (chemistry < 0 || chemistry > 10) {
            throw new IllegalArgumentException("Chemistry grade must be between 0 and 10.");
        }
        this.chemistry = chemistry;
    }

    public double getSum() {
        return math + physics + chemistry;
    }

    @Override
    public String toString() {
        return String.format("%-10s | %-20s | %-5d | %-6.1f | %-6.1f | %-6.1f | %-6.1f", 
                id, name, age, math, physics, chemistry, getSum());
    }
}

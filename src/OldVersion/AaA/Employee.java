package Learn.AaA;

public abstract class Employee {
    private String name;
    private int id;
    private double salary;

    public Employee() {

    }
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    public abstract void work();

    public static void main(String[] args) {
        Employee manager = new Manager(1);
        manager.work();
    }
}

class Manager extends Employee {
    private double bonus;

    public Manager(double bonus) {
        super();
        this.bonus = bonus;
    }

    public Manager(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }
    @Override
    public void work() {
        System.out.println("Manager is working.");
    }
}

class CommonEmployee extends Employee {

    @Override
    public void work() {
        System.out.println("CommonEmployee is working.");
    }
}
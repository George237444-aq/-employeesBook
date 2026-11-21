public class Employee {
       public String fullName;
       public String department;
       public int salary;
       public static int id;

public Employee (String fullName, String department, int salary){
    this.fullName = fullName;
    this.department = department;
    this.salary = salary;
    this.id = id;
}

    public Employee(String name, int dept, double salary) {
    }

    public String getFullName(){
        return this.fullName;
    }
    public String getDepartment(){
        return this.department;
    }
    public int getSalary(){
        return this.salary;
    }
    public int getId(){
        return this.id;
    }
    public void setDepartment(String department){
         this.department = department;
    }
    public void setSalary(int salary){
        this.salary = salary;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return salary == employee.salary;
    }
    @Override
    public String toString(){
        return "Employee{id=" + id +
                ", fullName='" + fullName + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }


    public void printShortInfo() {
        System.out.println("Сотрудник: " + this.fullName + ", Зарплата: " + this.salary + " руб.");
    }


    public int getDepartmentid() {
        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        EmployeeBook book = new EmployeeBook();

        System.out.println("=== Попытка добавить 11 сотрудников ===");

        for (int i = 1; i <= 11; i++) {
            String name = "Сотрудник_" + i;
            int dept = (i % 3) + 1;              // отделы 1, 2, 3 по кругу
            double salary = 50000 + (i * 10000); // зарплата растёт

            Employee newEmp = new Employee(name, dept, salary);
            boolean result = book.addEmployee(newEmp);

            System.out.printf("Попытка №%d: %s%n", i, result ? "Успешно добавлен" : "ОТКАЗ (нет свободного места)");
        }
    }
}

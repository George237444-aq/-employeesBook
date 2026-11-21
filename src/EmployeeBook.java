public class EmployeeBook {
    private Employee[] employees;
    private int count;

    public EmployeeBook() {
        this.employees = new Employee[10];
        this.count = 0;
    }

    public boolean addEmployee(Employee emp) {
        if (emp == null) {
            System.out.println("Ошибка: нельзя добавить null-сотрудника.");
            return false;
        }
        if (count >= employees.length) {
            System.out.println("Ошибка: хранилище заполнено (максимум 10 сотрудников).");
            return false;
        }

        employees[count] = emp;
        count++;
        return true;
    }

    public Employee findById(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getId() == id) {
                return employees[i];
            }
        }
        return null;
    }

    public void printAll() {
        if (count == 0) {
            System.out.println("В книге нет сотрудников.");
            return;
        }

        System.out.println("--- Список сотрудников ---");
        for (int i = 0; i < count; i++) {
            // Здесь сработает переопределённый toString() класса Employee
            System.out.println(employees[i]);
        }
        System.out.println("------------------------");
    }


    public void printShortList() {
        if (count == 0) {
            System.out.println("В книге нет сотрудников.");
            return;
        }

        System.out.println("--- Краткая сводка ---");
        for (int i = 0; i < count; i++) {
            employees[i].printShortInfo();
        }
        System.out.println("---------------------");
    }

    public int getSize() {
        return count;
    }

    public void printEmployees() {
        System.out.println("---- вывод всех сотрудников ----");
        for (Employee emp : employees){
            if (emp != null){
                System.out.println(emp.toString());
            } else  {
                System.out.println("[Пустая ячейка]");
            }

        }
        System.out.println("------------------------------");
    }

    public double calculateAverageSalary() {
        double sum = 0;
        int count = 0;

        for (Employee emp : employees) {
            if (emp == null) break; // "до первого null"
            sum += emp.getSalary();
            count++;
        }

        if (count == 0) return 0.0;
        return sum / count;
    }
    public void printTaxes(String scheme) {
        System.out.println("Расчет налогов по схеме: " + scheme);

        for (Employee emp : employees) {
            if (emp == null) continue;

            double taxRate = 0.0;
            double salary = emp.getSalary();

            switch (scheme) {
                case "PROPORTIONAL":
                    taxRate = 0.13;
                    break;
                case "PROGRESSIVE":
                    if (salary < 150000) {
                        taxRate = 0.13;
                    } else if (salary < 350000) {
                        taxRate = 0.17;
                    } else {
                        taxRate = 0.21;
                    }
                    break;
                default:
                    System.out.println("Неизвестная схема расчета налогов");
                    return;
            }

            double taxAmount = salary * taxRate;
            System.out.printf("Сотрудник %s (ID %d): Зарплата %.2f, Ставка %.0f%%, Налог: %.2f%n",
                    emp.getFullName(), emp.getId(), salary, (taxRate*100), taxAmount);
        }
    }


    public void indexSalaryByDepartment(int dept, double percent) {
        System.out.println("Индексация зарплат отдела " + dept + " на " + percent + "%");

        for (Employee emp : employees) {
            if (emp == null) continue;

            if (emp.getDepartmentid() != dept) {
                continue;
            }

            double oldSalary = emp.getSalary();
            double newSalary = oldSalary * (1 + percent / 100.0);
            emp.setSalary((int) newSalary);

            System.out.printf("Изменена зарплата для %s: %.2f -> %.2f%n", emp.getFullName(), oldSalary, newSalary);
        }
    }


    public void printFirstNLowEarners(double wage, int employeeNumber) {
        System.out.println("Первые " + employeeNumber + " сотрудников с зарплатой < " + wage);

        int foundCount = 0;
        int index = 0;

        while (index < employees.length) {
            Employee emp = employees[index];
            index++; // Двигаем индекс

            if (emp == null) break;

            if (emp.getSalary() < wage) {
                emp.printShortInfo();
                foundCount++;

                // break, если набрали нужное количество
                if (foundCount >= employeeNumber) {
                    break;
                }
            }
        }

        if (foundCount == 0) {
            System.out.println("Подходящих сотрудников не найдено.");
        }
    }


    public boolean containsEmployeeBySalary(Employee target) {
        for (Employee emp : employees) {
            if (emp == null) break;
            // Сравнение через equals (в классе Employee переопределен для сравнения зарплат)
            if (emp.equals(target)) {
                return true;
            }
        }
        return false;
    }


    public Employee getEmployeeById(int id) {
        for (Employee emp : employees) {
            if (emp != null && emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    public boolean addEmployee1(Employee emp) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = emp;
                return true;
            }
        }
        return false;
    }


    public Employee getEmployeeById1(int id) {
        for (Employee emp : employees) {
            if (emp != null && emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }
}

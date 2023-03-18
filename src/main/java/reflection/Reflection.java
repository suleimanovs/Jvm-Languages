package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Reflection - это механизм исследования данных о программе во время ее выполнения. Рефлексия позволят исследовать
 * информацию о полях, методах, конструкторах и других составляющих класса.
 */
public class Reflection {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {

        Class employeeClass = Class.forName("reflection.Employee");
//      Class employeeClass2 = Employee.class;
//      Class employeeClass3 = new Employee().getClass();


        Field fieldId = employeeClass.getField("id");
        System.out.println("type of fieldId: " + fieldId.getType());
        System.out.println("name of fieldId: " + fieldId.getName());
        System.out.println("modifiers of fieldId: " + fieldId.getModifiers());
        System.out.println();

        for (Field field : employeeClass.getFields()) {
            System.out.println("type of field: " + field.getType());
            System.out.println("name of field: " + field.getName());
            System.out.println("modifiers of field: " + field.getModifiers());
            System.out.println();
        }

        /**
         * доступ ко всем переменным даже приватным, можно через getDeclaredFields получить
         */
        for (Field field : employeeClass.getDeclaredFields()) {
            System.out.println("type of field: " + field.getType());
            System.out.println("name of field: " + field.getName());
            System.out.println("modifiers of field: " + field.getModifiers());
            System.out.println();
        }


        /**
         * Что бы получить информацию о методе нужно указать имя метода, а так же его параметры, что бы было JVM
         * знал какой именно метод, так как могут быть такие же overload(перезагруженные) методы.
         */
        Method someMethod = employeeClass.getMethod("setSalary", double.class);
        System.out.println("return type of method: " + someMethod.getReturnType());
        System.out.println("parametr type of method: " + Arrays.toString(someMethod.getParameterTypes()));

        for (Method method : employeeClass.getMethods()) {
            System.out.println("name of method: " + method.getName() + " return type: " + method.getReturnType() +
                    " parametr type : " + Arrays.toString(method.getParameterTypes()));
        }


        Constructor constructor = employeeClass.getConstructor();
        System.out.println(constructor.getParameterCount());
        System.out.println(Arrays.toString(constructor.getParameterTypes()));
        System.out.println(Arrays.toString(constructor.getExceptionTypes()));
        System.out.println();

        for (Constructor c:employeeClass.getConstructors()){
            System.out.println(c.getParameterCount());
            System.out.println(Arrays.toString(c.getParameterTypes()));
            System.out.println(Arrays.toString(c.getExceptionTypes()));
        }

    }

}

class Employee {

    public int id;
    private String name;
    public String department;
    private double salary;

    public Employee() {
    }

    public Employee(int id, String name, String department) throws Exception {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    private void changeDepartment(String newDepartment) {
        this.department = newDepartment;
        System.out.println("new department is: " + newDepartment);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}

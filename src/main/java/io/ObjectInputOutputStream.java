package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectInputOutputStream {


    public static void main(String[] args) {

        /**
         * Сериализация - это процесс преобразования объекта в последовательность байт.
         * Десериализация - это процесс восстановления объекта, из этих байт
         */

        var employees = new ArrayList<Employee>(); // Employee должен быть serializable
        employees.add(new Employee("Osman",20));
        employees.add(new Employee("Misha",22));
        employees.add(new Employee("Oleg",22));

        var dest = "file/employees.bin";
        try (var objectOutputStream = new ObjectOutputStream(new FileOutputStream(dest));
             var objectInputStream = new ObjectInputStream(new FileInputStream(dest))) {

            objectOutputStream.writeObject(employees);

            var readEmployees = (List<Employee>) objectInputStream.readObject();
            System.out.println(readEmployees);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}

/**
 * Для того, чтобы объект класса можно было сериализировать, класс должен имплементировать
 * интерфейс Serializable. Поля класса, помеченные ключевым словом transient, не записываются в файл при сериализации.
 * В сериализируемом классе необходимо использовать
 * serialVersionUID для обозначения версии класса
 */
class Employee implements Serializable {
    String name;
    int salary;


    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

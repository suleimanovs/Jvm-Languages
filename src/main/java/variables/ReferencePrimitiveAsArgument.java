package variables;


class Employee {

    String name;
    double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    double enlarger(double num) {
        return num *= 2;
    }
}

class Student {
    String name;
    int course;

    public Student(String name, int course) {
        this.name = name;
        this.course = course;
    }

    static void swap(Student s1, Student s2) {
        Student temp = s1;
        s1 = s2;
        s2 = temp;
    }

    static void changeName(Student student) {
        student.name = "Alex";
    }
}

/**
 * Использование ссылочных и примитивных типов в качестве аргумента
 */
public class ReferencePrimitiveAsArgument {

    public static void main(String[] args) {

        Employee employee = new Employee("Osman", 600.0);
        /**
         * в данном случае в метод enlarger() мы передаем не сам employee.salary, а только значение который он в себе
         * хранит, так как перменная salary примитив. По этому в качестве аргумента передается лишь 600.0.
         * В результате переменная salary ни как не изменится
         */
        double result = employee.enlarger(employee.salary);
        System.out.println(result);
        System.out.println(employee.salary);


        Student student1 = new Student("Ivan", 2);
        Student student2 = new Student("Samir", 4);
        /**
         * при передаче reference(ссылочных) аргументов в параметр, мы передаем ссылочную копию,
         * то есть мы передаем s1,s2 которые ссылаются на те же обьекты в heap
         * и когда мы меняем ссылки местами в методе swap()?, мы меняем их для его параметров тоесть для
         * s1 и s2, а для student1 и student2 нечего не менятеся
         */
        Student.swap(student1, student2);
        System.out.println(student1.name);
        System.out.println(student2.name);

        /**
         * тут по скольку мы передаем ссылку на обьект, в метоле мы можем  изменить значения, так как имеем сслыку
         * на объект в heap
         */
        Student.changeName(student1);
        System.out.println(student1.name); //Alex


    }
}

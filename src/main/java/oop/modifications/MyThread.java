package oop.modifications;

/**
 * Created by Osman on 20:59
 */
public class MyThread {


    /**
     * @modificaton private - переменные и методы класса доступны только в самом классе.
     * То есть в пределах этого класса, эти поля(переменные экземпляра) не доступны.Никому.
     * Для обращения к таким методам обычно исользуются геттеры и сеттеры.
     * Реализацию геттеры см {@link MyThread#getAge()} и сеттеры см  {@link MyThread#setAge(int)}
     */
    private String name;
    private int age;
    private int phoneNumber;
    /**
     * Если спецификатор доступа не указан, то он считается как доступ по умолчанию,доступ
     * по умолчанию не имеет ключевого слово. Его также называют - доступом в пределах пакета Это значит
     * что член доступен для всех классов текущего пакета, но не для классов за пределами пакета,
     * для них он будет как private.
     */
    String address;

    public MyThread(String name, int age, int phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber=phoneNumber;
    }

    public void showInfo() {
        System.out.println("Name is " + name);
        System.out.println("Age is " + age);
    }

    public String getName() { return name; }

    /**
     * @modificaton public - доступен из любого места в программе. То есть он доступен
     * для других классов и методов
     */
    public void setAge(int age) {
        if (age > 0) this.age = age;
        else System.out.println("Incorrect Age");

    }

    /**
     * @modificaton protected делает член класса доступным только для класса,
     * и произвольных классов(наследников) а так же доступны для классов того же пакета.
     */
    protected int getPhoneNumber() {
        return phoneNumber;
    }

    public int getAge() { return age; }

    public void setName(String name) { this.name = name; }
}

package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionContinue {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<Employee> clazz = Employee.class;
        Constructor<Employee> constructor = clazz.getConstructor();
        Employee employee =  constructor.newInstance();


        Constructor<Employee> constructor2 = clazz.getConstructor(int.class,String.class,String.class);
        Employee employee2 =  constructor2.newInstance(12,"Osman","Interior");

        System.out.println(employee2);

        Method setSalary = clazz.getMethod("setSalary", double.class);
        setSalary.invoke(employee2,12.3);

        System.out.println(employee2);

    }

}

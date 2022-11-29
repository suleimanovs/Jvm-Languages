package generics;

import java.util.ArrayList;

public class ParametrizedMethod {

    public static void main(String[] args) {

        var list = new ArrayList<Integer>();
        list.add(12);
        list.add(55);
        list.add(24);
        list.add(65);

        Method.getLastElement(list);

    }

}

class Method {

    public static <T> T getLastElement(ArrayList<T> list){
        return list.get(list.size()-1);
    }

}

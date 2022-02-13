package otherUsefulThing;

/**
 * Created by Osman on 3:59 PM
 */
public class ToString {
    int paramOne;
    int paramTwo;
    int paramThree;

    public ToString(int paramOne, int paramTwo, int paramThree) {
        this.paramOne = paramOne;
        this.paramTwo = paramTwo;
        this.paramThree = paramThree;
    }

    @Override
    public String toString() {

        return String.format("paramOne=%02d\nparamTwo=%s\nparamThree=%s", paramOne, paramTwo, paramThree);

//      "ToString{" + "paramOne=" + paramOne + ", paramTwo=" + paramTwo + ", paramThree=" + paramThree + '}';
    }



    public static void main(String[] args) {
        ToString toString = new ToString(1, 2, 3);
        /**
         * По умолчанию метод toString() вернул бы что-то вроде otherUsefulThing.ToString@5b480cf9
         * Но поскольку мы переопределили это метод в классе, оно вернет соответствующее значение
         */
        System.out.println(toString.toString());
    }
}

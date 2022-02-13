package otherUsefulThing;

/**
 * Created by Osman on 1:49 PM
 */
public class StaticInitialzation {

    public static void main(String[] args) {
        System.out.print("Создание нового объекта Cupboard в main()");
        new CupBord();
        System.out.print("Создание нового объекта Cupboard в main()");
        new CupBord();
        table.f2(1);
        cupBord.f3(1);

    }

    static Table table = new Table();
    static CupBord cupBord = new CupBord();
}

 class Table {

    static Bowl bowl1 = new Bowl(1);

    public Table(){
        System.out.println("Table");
        bowl2.f1(1);
    }
    void f2(int marker){
        System.out.println("f2 "+marker);
    }

    static Bowl bowl2 = new Bowl(2);
}
class Bowl {

    public Bowl(int marker){
        System.out.println("Bowl "+marker);
    }

    void f1(int marker){
        System.out.println("f1 "+marker);
    }
}

 class CupBord {

    Bowl bowl3 = new Bowl(3);
    static Bowl bowl4 = new Bowl(4);

    public CupBord(){
        System.out.println("CupBord()");
        bowl4.f1(2);
    }

    void f3(int marker){
        System.out.println("f3 "+marker);
    }

    static Bowl bowl5 = new Bowl(5);
}

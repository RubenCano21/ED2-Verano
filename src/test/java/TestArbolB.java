import java.util.ArrayList;
import java.util.List;

public class TestArbolB {

    public static void main(String[] args) {
        ArbolB A = new ArbolB();

        A.insertar(2);
        A.insertar(5);
        A.insertar(3);
        A.insertar(7);
        A.insertar(9);

        List<String> list = new ArrayList<>();
        //System.out.println(A.mostrarArbol());
        //A.recorridoEnInOrden();
        //list.add(String.valueOf(A.recorridoEnInOrden()));
        //System.out.println("InOrden: " + A.recorridoEnInOrden());
        System.out.println("InOrden: " + A.inOrden());
        System.out.println("PreOrden: " + A.preOrden());
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ArbolB {

    private Nodo raiz;

    public ArbolB(){
        this.raiz = null;
    }

    public boolean esHoja(Nodo p){
        return (p.getHI() == null && p.getHD() == null);
    }

    public void insertar(int x){
        Nodo q = new Nodo(x);
        if (raiz == null){
            raiz = q;
            return;
        }else {
            Nodo p = raiz;
            Nodo ap = null;
            while (p != null){
                ap =p;
                if (x < p.getElem()){
                    p = p.getHI();
                } else if (x > p.getElem()) {
                    p = p.getHD();
                }else
                    return;
            }
            if (x < ap.getElem()) {
                ap.setHI(q);
            } else
                ap.setHD(q);
        }
    }

    public String mostrar(){
        String s = "";
        Nodo p = raiz;
        Nodo ap = null;
        while(p != null){
            ap = p;
            s = s + p.getElem();
        }
        return s;
    }

    public List<String> preOrden(){
        List<String> recorrido =  new ArrayList<>();
        preOrden(raiz, recorrido);
        return recorrido;
    }

    private void preOrden(Nodo p,  List<String> list) {
        if (p != null){
            list.add(String.valueOf(p.getElem()));
            preOrden(p.getHI(), list);
            preOrden(p.getHD(), list);
        }
    }

    public List<String> inOrden(){
        List<String> recorrido= new ArrayList<>();
        inOrden(raiz, recorrido);
        return recorrido;
    }

    private void inOrden(Nodo p,  List<String> list) {
        if (p != null){
            p = p.getHI();
            list.add(String.valueOf(p.getElem()));
            p = p.getHD();
        }
    }

    public List<String> recorridoEnInOrden() {
        List<String> recorrido = new ArrayList<>();
        if (this.esArbolVacio()){
            return recorrido;
        }

        Stack<Nodo> pilaDeNodos = new Stack<>();
        Nodo  nodoActual = this.raiz;
        meterPilaInOrden(nodoActual, pilaDeNodos);

        while (!pilaDeNodos.isEmpty()){
            nodoActual = pilaDeNodos.pop();
            recorrido.add(String.valueOf(nodoActual.getElem()));

            if (nodoActual.getHD() != null){
                nodoActual = nodoActual.getHD();
                meterPilaInOrden(nodoActual, pilaDeNodos);
            }
        }
        return recorrido;
    }

    private void meterPilaInOrden(Nodo nodoActual, Stack pilaDeNodos) {
        while(!Nodo.esNodoVacio(nodoActual)){
            pilaDeNodos.push(nodoActual);
            nodoActual = nodoActual.getHI();
        }
    }

    private boolean esArbolVacio() {
        return Nodo.esNodoVacio(this.raiz);
    }


    public String mostrarArbol() {
        return this.generarCadenaDeArbol(this.raiz, "", true);
    }

    private String generarCadenaDeArbol(Nodo nodoActual, String prefijo, boolean ponerCodo) {
        StringBuilder cadena = new StringBuilder();
        cadena.append(prefijo);

        if (prefijo.isEmpty()){
            cadena.append(ponerCodo ? "|--(R)" : "|--(R)");
        }else{
            cadena.append(ponerCodo ? "|--(D)" : "|--(I)");
        }

        if (Nodo.esNodoVacio(nodoActual)){
            cadena.append("-|\n");
            return cadena.toString();
        }
        cadena.append(nodoActual.getElem());
        cadena.append("\n");

        Nodo nodoIzq = nodoActual.getHI();
        String prefijoAux = prefijo + (ponerCodo ? " " : "| ");
        cadena.append(generarCadenaDeArbol(nodoIzq, prefijoAux, false));

        Nodo nodoDer = nodoActual.getHD();
        cadena.append(generarCadenaDeArbol(nodoDer, prefijoAux, true));
        return cadena.toString();
    }
}

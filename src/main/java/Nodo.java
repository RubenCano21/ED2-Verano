public class Nodo {

    private Nodo HI;
    private Nodo HD;
    private int elem;

    public Nodo(){
        this.HI = null;
        this.HD = null;
        this.elem = 0;
    }

    public Nodo(int elem){
        this.HI = null;
        this.HD = null;
        this.elem = elem;
    }

    public static boolean esNodoVacio(Nodo nodo) {
        return nodo == Nodo.nodoVacio();
    }

    private static Nodo nodoVacio() {
        return null;
    }

    public Nodo getHI() {
        return HI;
    }

    public void setHI(Nodo HI) {
        this.HI = HI;
    }

    public Nodo getHD() {
        return HD;
    }

    public void setHD(Nodo HD) {
        this.HD = HD;
    }

    public int getElem() {
        return elem;
    }

    public void setElem(int elem) {
        this.elem = elem;
    }
}

package adaits.cursoJava.mathematic;

//Clase Fracción
public class Fraccion {

    private int num;
    private int den;

    public Fraccion() {
        this.num = 0;
        this.den = 1;
    }

    public Fraccion(int num, int den) {
        this.num = num;
        if(den==0){
            den = 1;
        }
        this.den = den;
        simplificar();
    }

    public Fraccion(int num) {
        this.num = num;
        this.den = 1;
    }

    public int getDen() {
        return den;
    }

    public void setDen(int den) {
        this.den = den;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    //sumar fracciones
    public Fraccion sumar(Fraccion f) {
        Fraccion aux = new Fraccion();
        aux.num = this.num * f.den + this.den * f.num;
        aux.den = this.den * f.den;
        aux.simplificar();  //se simplifica antes de devolverla
        return aux;
    }

    //restar fracciones
    public Fraccion restar(Fraccion f) {
//        org.adaits.mathematics.Fraccion aux = new org.adaits.mathematics.Fraccion();
//        aux.num = this.num * f.den - this.den * f.num;
//        aux.den = this.den * f.den;
//        aux.simplificar();  //se simplifica antes de devolverla
//        return aux;
        return this.sumar(f.opuesto());
    }

    private Fraccion opuesto(){
        Fraccion aux = new Fraccion();
        aux.num = -this.num;
        aux.den = this.den;
        return aux;
    }

    //multiplicar fracciones
    public Fraccion multiplicar(Fraccion f) {
        Fraccion aux = new Fraccion();
        aux.num = this.num * f.num;
        aux.den = this.den * f.den;
        aux.simplificar();  //se simplifica antes de devolverla
        return aux;
    }

    //dividir fracciones
    public Fraccion dividir(Fraccion f) {
        Fraccion aux = new Fraccion();
        aux.num = this.num * f.den;
        aux.den = this.den * f.num;
        aux.simplificar();  //se simplifica antes de devolverla
        return aux;
    }

    //Cálculo del máximo común divisor por el algoritmo de Euclides
    private int mcd() {
        int u = Math.abs(num); //valor absoluto del numerador
        int v = Math.abs(den); //valor absoluto del denominador
        if (v == 0) {
            return u;
        }
        int r;
        while (v != 0) {
            r = u % v;
            u = v;
            v = r;
        }
        return u;
    }

    //método para simplificar fracciones
    private void simplificar() {
        int n = mcd(); //se calcula el mcd de la fracción
        if (den < 0 ){
            num = -num;
            den = -den;
        }


        num = num / n;
        den = den / n;
    }

    public boolean esCero(){
        return num==0;
    }

    public boolean positiva(){
        return num > 0;
    }

    @Override
    public String toString() {
        simplificar();
        String denToStr = "";
        if (den != 1){
            denToStr += "/" +  den;
        }
        return num + denToStr;
    }
} //Fin de la clase org.adaits.mathematics.Fraccion

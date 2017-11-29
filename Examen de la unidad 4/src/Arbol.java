public class Arbol {
    private static Integer nodos;
    private static Intenger dato;

    public static  void  main(String[]args) {
        //Funciones
        class NodoArbol{
            
            NodoArbol li,ld;
            int dato;
            public NodoArbol(int d){
                dato=d;
                li=ld=null;
            }
            public synchronized void insertar(int d){
                if(d<dato){
                    if(li==null){
                        li=new NodoArbol(d);
                    }
                    else{
                        li.insertar(d);
                    }
                }
                if(d>dato){
                    if(ld==null){
                        ld=new NodoArbol(d);
                    }
                    else{
                        ld.insertar(d);
                    }
                }
            }//fin insertar
            public int retornadato(){
                return(dato);
            }//end retornadato
        }
        class Arbol2 {
            private NodoArbol raiz;
            private int d;


            public Arbol2() {
                raiz=null;
            }
            public NodoArbol retornaraiz(){
                return(raiz);
            }
            public synchronized void insertarNodo(Integer nodos){
                if(raiz==null){
                    raiz=new NodoArbol(d);
                    //primero=raiz;
                }
                else{
                    raiz.insertar(d);
                }
            }//fin insertarNodo
            public synchronized String preorden(){
                String pre=ayudantepreorden(raiz);
                return(pre);
            }
            private String ayudantepreorden(NodoArbol nodo){
                String cadena=new String();
                if(nodo!=null){
                    //return;
                    //System.out.print(nodo.dato+" ");
                    cadena=cadena+String.valueOf(nodo.dato+" ");
                    cadena=cadena+ayudantepreorden(nodo.li);
                    cadena=cadena+ayudantepreorden(nodo.ld);
                }
                else{
                    cadena="";
                }
                return(cadena);
            }
            public synchronized String inorden(){
                String inor=ayudanteinorden(raiz);
                return(inor);
            }
            private String ayudanteinorden(NodoArbol nodo){
                String cadena=new String();
                if(nodo!=null){
                    // return;
                    cadena=cadena+ayudanteinorden(nodo.li);
                    cadena=cadena+nodo.dato+" ";
                    cadena=cadena+ayudanteinorden(nodo.ld);
                }
                else{cadena="";}
                return(cadena);
            }
            public synchronized String posorden(){
                String pos=ayudanteposorden(raiz);
                return(pos);
            }
            private String ayudanteposorden(NodoArbol nodo){
                String cadena=new String();
                if(nodo!=null){
                    cadena=cadena+ayudanteposorden(nodo.li);
                    cadena=cadena+ayudanteposorden(nodo.ld);
                    cadena=cadena+nodo.dato+" ";
                }
                else{cadena="";}
                return(cadena);
            }
            public synchronized int altura(NodoArbol R){
                NodoArbol p=R;
                int altizq=p.li==null ? 1:1+altura(p.li);
                int altder=p.ld==null ? 1:1+altura(p.ld);
                return(Math.max(altizq,altder));
            }//end altura
            public synchronized int hojas(NodoArbol R){
                NodoArbol p=R;
                int hojas=0;
                if(p.li==null & p.ld==null){
                    hojas=1;
                }
                else{
                    if(p.li!=null){
                        hojas=hojas+hojas(p.li);
                    }
                    if(p.ld!=null){
                        hojas=hojas+hojas(p.ld);
                    }
                }
                return(hojas);
            }//end hojas
            public synchronized String ancestros(NodoArbol R,int d){
                NodoArbol p=R;
                String h=new String();
                if (p.dato==d){
                    return(String.valueOf(" --> "+d));
                }//end if
                if (d>p.dato){
                    h=h+" --> "+p.dato+ancestros(p.ld,d);
                }
                else{
                    h=h+" --> "+p.dato+ancestros(p.li,d);
                }
                return(h);
            }
        }
        //Ejemplo
        //Crear arbol
        Arbol2 arbol2=new Arbol2();
        int valor=0;
        nodos= new Integer(10);//Nodos
        for (int i=1;i<=nodos;i++){
            dato= new Intenger(i);//Nodo
            arbol2.insertarNodo(nodos);
        }
        //Preorden
        System.out.println("Preorden : "+arbol2.preorden());
        //Inorden
        System.out.println("Inorden : "+arbol2.inorden());
        //Postorden
        System.out.println("Postorden : "+arbol2.posorden());
    }

    private static class Intenger {
        public Intenger(int i) {
        }
    }
}
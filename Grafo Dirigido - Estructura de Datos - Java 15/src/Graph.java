import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

public class Graph {

    //nodes es una lista de tipo nodo donde se almacenaran todos los nodos del grafo
    private final List<Node> nodes = new ArrayList<>();
    //edges es una lista de tipo Edge donde se almacenaran todas las aristas del grafo
    private final List<Edge> edges = new ArrayList<>();

    //La lista de adjacencia contiene todos los nodos adyacentes al nodo que los contiene
    private final Hashtable<Node, List<Node>> adjacencyList = new Hashtable<>();
    //La matriz de adjacencia representa en una matriz la relacion entre la lista de adyacencia y los nodos
    private final Hashtable<Node,Hashtable<Node,Integer>> adjacencyMatrix = new Hashtable<>();


    //Añadimos el Vertice (Nodo) a la lista de Nodos que contiene el Grafo
    void insertVertex(Node node){
        nodes.add(node);
    }

    //Añadimos la Arista (Edge) a la lista de Aristas que contiene el Grafo
    void insertEdge (Node origin, Node destination) {
        edges.add(new Edge(origin,destination));
    }

    //Eliminamos el vertice del Grafo asi como las aristas unidas al vertice
    void deleteVertex (Node node) {
        nodes.removeIf(aux -> aux == node);
        edges.removeIf(edge -> edge.origin == node || edge.destination == node);
    }

    //Eliminamos las aristas del Grafo
    void deleteEdge (Node origin, Node destination) {
        edges.removeIf(edge -> edge.origin == origin && edge.destination == destination);
    }

    boolean isEmpty() {
        return nodes.isEmpty();
    }

    //Creamos la matriz de Ayacencia (Inicializamos la matriz en ceros)
    void createMatrix () {
        Hashtable<Node,Integer> fila = new Hashtable<>();
        /*
        llenamos de ceros las filas de la matriz (suponemos que incialmente la matriz debe de iniciar en ceros)
        j representa el vertice (node), put añade la llave j a la tabla Hash con un Value 0
         */
        nodes.forEach(j -> fila.put(j,0));
        //insertamos las filas inicializadas en cero a la matriz
        nodes.forEach(i -> adjacencyMatrix.put(i,new Hashtable<>(fila)));
    }

    void matrixAdjacent () {
        /*
       Para observar los nodos que son adyacentes nos debemos fijar en que nodos estan conectados
       se reccorre la list de edges para averiguar los nodos que estan adyacentes
       si una arista (edge) esta unida a un nodo de origen a destino entonces filter la manda a un forEach
       Filter devuelve una lista con las aristas (edge) que tenian un nodo de origen que contenia la llave de destino
       Despues se utiliza un forEach donde, obtenemos el nodo origen con get y despues introducimos el nodo destino
        el nodo destino tendra como valor 1 porque quiere decir que el nodo origen y destino son adjacentes
        */

        createMatrix();
        edges.stream().filter( edge -> adjacencyMatrix.get(edge.origin).containsKey(edge.destination) )
                .forEach( edge -> adjacencyMatrix.get(edge.origin).put(edge.destination, 1) );
    }

    //Lista todos los vertices (nodos) origem que estan unidos con otros nodos destino
    void listAdjacent () {
        //Se recorre la lista de aristas y con cada arista existente en el grafo se llama al metodo adding
        edges.forEach(edge -> adding(edge.origin, edge.destination));

        //Esta linea agrega a los nodos que no son origen por lo tanto solo les añade un ArrayList vacio
        //Asi ya estarioan todos los nodos (sean origen o destino) tendrian un representante como llave en la tablaHash
        edges.stream().filter(e -> !adjacencyList.containsKey(e.destination)).
                forEach(e -> adjacencyList.put(e.destination, new ArrayList<>()));
    }

    //metodo para añadir nodos a la lista de adyacencia
    void adding (Node a, Node b) {
        //si la lista de adyacencia ya contenia al nodo de origen (a)
        if (adjacencyList.containsKey(a))
            //Entonces añade este nodo de destino (b) al representante nodo origen (a) en la tabla Hash
            adjacencyList.get(a).add(b);
        //si el nodo origen (a) no tiene representante en la tabla Hash (aun no esta añadida)
        else
            /*
            Entonces introduce una nueva llave con el valor de a (key a)
            como value tendra un arrayList con un valor incial b

            esta parte de codigo -> new ArrayList<>() {{ add(b); }}  sirve para crear un nuevo array y asignarle
            un valor inicial al mismo tiempo de que se crea
             */
            adjacencyList.put( a, new ArrayList<>() {{ add(b); }} );
    }

    void printAdjacencyList (){
        //Con un forEach y una funcion lambda mostramos el contenido de la tablaHash llamada adjacencyList
        //k representa la llave y v el valor de esa llave
        adjacencyList.forEach((k,v) -> System.out.println( k + " -> " +v.toString()));
    }

    void printAdjacencyMatrix (){
        //Con un forEach y una funcion lambda mostramos el contenido de la tablaHash llamada adjacencyMatrix
        //k representa la llave y v el valor de esa llave
        adjacencyMatrix.forEach((k,v) -> System.out.println( k + " -> " +v.toString()));
    }

    //Imprime el contenido de la lista de adyacencia con un formato mas entendible y organizado
    void printList (){
        adjacencyList.forEach((k,v) -> {
            System.out.print(k + " -> ");
            v.forEach(node -> System.out.print(node + "  "));
            System.out.println();
        });
    }

    //Imprime el contenido de la matriz de adyacencia con un formato mas entendible y organizado
    void printMatrix(){
        adjacencyMatrix.forEach((k,v) -> {
            v.forEach((i,j) -> System.out.print(j + "  "));
            System.out.println();
        });
    }

    //toString lo utilizamos para retornar el contenido de una clase (Atributos o Variables) como un String
    @Override
    public String toString() {
        return "Graph {\n nodes = " + nodes + "\n\n edges = " + edges + "\n} ";
    }
}

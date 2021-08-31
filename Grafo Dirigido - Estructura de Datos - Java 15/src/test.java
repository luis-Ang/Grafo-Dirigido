import java.util.Scanner;

public class test {
    public static void main (String []args) {

        //Creamos una instancia de la clase Graph
        Graph grafo = new Graph();

        //Creamos los Nodos y les asignamos un nombre (Value)
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node AUX = new Node("AUX");

        //Añadimos los vertices (Nodos) al grafo
        grafo.insertVertex(A);
        grafo.insertVertex(B);
        grafo.insertVertex(C);
        grafo.insertVertex(D);
        grafo.insertVertex(E);
        grafo.insertVertex(AUX);

        //Creamos las aristas (edge) al momento de insertar el nodo de origen y el nodo de destino y se agregan al Grafo
        grafo.insertEdge(A,B);
        grafo.insertEdge(B,C);
        grafo.insertEdge(C,D);
        grafo.insertEdge(D,E);
        grafo.insertEdge(A,D);
        grafo.insertEdge(C,A);
        grafo.insertEdge(A,AUX);
        grafo.insertEdge(E,AUX);
        grafo.insertEdge(E,C);

        //Mostramos el contenido del Grafo
        System.out.println("\nContenido del Grafo\n");
        System.out.println( grafo.toString() );

        //Mostramos el contenido de la lista de Adyacencia
        System.out.println("\n\nLista de Adyacencia\n");
        grafo.listAdjacent();
        grafo.printList();

        //Mostramos el contenido de la Matriz de Adyacencia
        System.out.println("\n\nMatriz de Adyacencia\n");
        grafo.matrixAdjacent();
        grafo.printMatrix();


        /*
        Los metodos de printAdjacencyList() y printAdjacencyMatrix() funcionan para lo mismo que
        listAdjacent() y matrixAdjacent() respectivamente , solo que el resultado se imprime con un formato
        y organizacion diferente.
         */


        //Mostramos el contenido de la lista de Adyacencia con otro formato
        System.out.println("\n\nLista de Adyacencia con otro formato\n");
        grafo.listAdjacent();
        grafo.printAdjacencyList();

        //Mostramos el contenido de la Matriz de Adyacencia donde se ve el representante (Llave) de cada fila y columna
        System.out.println("\n\nMatriz de Adyacencia mostrando al representante de cada fila y columna\n");
        grafo.matrixAdjacent();
        grafo.printAdjacencyMatrix();
        
    }
}

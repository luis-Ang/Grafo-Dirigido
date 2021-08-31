public class Edge {

    //Como es un grafo dirigido se tiene un nodo de origen y un nodo de destino
    //La arista (edge) va desde el nodo de origen al nodo de destino
    Node origin;
    Node destination;

    //Constructos de la clase Edge
    public Edge(Node origin, Node destination) {
        this.origin = origin;
        this.destination = destination;
    }

    //toString lo utilizamos para retornar el contenido de una clase (Atributos o Variables) como un String
    @Override
    public String toString() {
        return "\n\t\t Edge{ origin = " + origin + ", destination=" + destination + " }";
    }
}

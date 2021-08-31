import java.util.ArrayList;
import java.util.List;

public class Node {

    //Valor del Vertice (node)
    String value;

    //Constructor de la clase Node
    public Node(String value) {
        this.value = value;
    }

    //toString lo utilizamos para retornar el contenido de una clase (Atributos o Variables) como un String
    @Override
    public String toString() {
        return "Node { " + value +" }";
    }
}

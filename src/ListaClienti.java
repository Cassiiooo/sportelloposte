import java.util.ArrayList;

public class ListaClienti {

    private ArrayList<Integer> lista;
    private static final int MAX_ATTESA = 3;

    public ListaClienti() {
        lista = new ArrayList<>();
    }

    public synchronized boolean aggiungiCliente(int id) {
        if (lista.size() >= MAX_ATTESA) {
            return false; // coda piena
        }
        lista.add(id);
        notifyAll();
        return true;
    }

    public synchronized Integer prossimoCliente() throws InterruptedException {
        while (lista.isEmpty()) {
            wait();
        }
        return lista.remove(0);
    }

    public synchronized int size() {
        return lista.size();
    }
}
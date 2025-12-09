public class Sportello extends Thread {

    private ListaClienti lista;
    private boolean aperto = true;

    public Sportello(ListaClienti lista) {
        this.lista = lista;
    }


    public void chiudi() {
        aperto = false;
    }
    @Override
    public void run() {
        while (aperto) {
            try {
                Integer cliente = lista.prossimoCliente();
                System.out.println("Servito cliente " + cliente);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Sportello Chiuso");
    }
}
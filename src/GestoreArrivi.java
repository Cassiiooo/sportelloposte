public class GestoreArrivi extends Thread {

    private ListaClienti lista;
    private int clienteID = 1;
    private boolean aperto = true;
    private int clientiRifiutati = 0;

    public GestoreArrivi(ListaClienti lista) {
        this.lista = lista;
    }

    public void chiudi() {
        aperto = false;
    }

    public int getClientiRifiutati() {
        return clientiRifiutati;
    }

    @Override
    public void run() {
        while (aperto) {
            try {
                Thread.sleep(1000);

                boolean inserito = lista.aggiungiCliente(clienteID);
                if (inserito) {
                    System.out.println("Cliente " + clienteID + " entrato in poste");
                    clienteID++;
                } else {
                    clientiRifiutati++;
                    System.out.println("Cliente rifiutato: coda piena");
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Posta Chiusa");
    }
}
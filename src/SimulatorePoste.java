import java.time.Duration;
import java.time.LocalTime;

public class SimulatorePoste {


    public static void main(String[] args) throws InterruptedException {

        LocalTime time1 = LocalTime.now();
        System.out.println("Apertura poste: " + time1);

        ListaClienti lista = new ListaClienti();
        GestoreArrivi gestore = new GestoreArrivi(lista);
        Sportello sportello = new Sportello(lista);

        gestore.start();
        sportello.start();

        Thread.sleep(15000); // ufficio aperto 15 secondi

        gestore.chiudi();
        sportello.chiudi();

        LocalTime endTime = LocalTime.now(); // chiusura
        Duration durata = Duration.between(time1, endTime);

        long ore = durata.toHours();
        long minuti = durata.toMinutes() % 60;
        long secondi = durata.getSeconds() % 60;

        System.out.println("\nTEMPO APERTURA POSTE:");
        System.out.println(ore + " ore " + minuti + " minuti " + secondi + " secondi");

        System.out.println("Clienti rifiutati: " + gestore.getClientiRifiutati());
    }
}
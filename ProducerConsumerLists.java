import javax.swing.*;
import java.util.ArrayList;

class ProducerConsumerLists {

    static int workerID = 0;

    private ArrayList<Consumer> consumers = new ArrayList<>();
    private ArrayList<Producer> producers = new ArrayList<>();

    JTextArea console;
    Buffer buffer = new Buffer();

    ProducerConsumerLists(JTextArea console) {
        this.console = console;

        for (int i = 0; i < 2; i++) { // i -> startowa ilosc producentow i konsumentow
            addConsumer();
            addProducer();
        }
    }

    private Consumer createRandomConsumer() {
        StringBuilder name = new StringBuilder();
        name.append("consumer_");
        name.append(workerID);
        workerID++;
        return new Consumer(name.toString(), buffer, console);
    }

    private void addConsumer() {
        Consumer consumer = createRandomConsumer();
        consumers.add(consumer);
    }

    private Producer createRandomProducer() {
        StringBuilder name = new StringBuilder();
        name.append("producer_");
        name.append(workerID);
        workerID++;
        return new Producer(name.toString(), buffer, console);
    }

    private void addProducer() {
        Producer producer = createRandomProducer();
        producers.add(producer);
    }

    public void setProducers(int x) {
        removeAllProducers();
        for (int i = 0; i < x; i++) {
            addProducer();
        }
    }

    public void setConsumers(int x) {
        removeAllConsumers();
        for (int i = 0; i < x; i++) {
            addConsumer();
        }
    }

    private void removeAllProducers() {
        producers.clear();
    }

    private void removeAllConsumers() {
        consumers.clear();
    }

    void startAll() {
        System.out.println("TEST");
        try {
            for (Producer producer : producers) {
                producer.start();
                System.out.println(producer.toString() + " started!");
            }
        } catch (NullPointerException e) {
            System.err.println("BRAK PRODUCENTOW!");
        }

        try {
            for (Consumer consumer : consumers) {
                consumer.start();
                System.out.println(consumer.toString() + " started!");
            }
        } catch (NullPointerException e) {
            System.err.println("BRAK KONSUMENTOW!");
        }
    }

    void stopAll() {
        try {
            for (Producer producer : producers) {
                producer.stop();
                System.out.println(producer.toString() + " stopped!");
            }
        } catch (NullPointerException e) {
            System.err.println("BRAK PRODUCENTOW!");
        }

        try {
            for (Consumer consumer : consumers) {
                consumer.stop();
                System.out.println(consumer.toString() + " stopped!");
            }
        } catch (NullPointerException e) {
            System.err.println("BRAK KONSUMENTOW!");
        }
        workerID = 0;
    }

    void unpauseAll() {
        System.out.println("TEST");
        try {
            for (Producer producer : producers) {
                producer.unpause();
                System.out.println(producer.toString() + " started!");
            }
        } catch (NullPointerException e) {
            System.err.println("BRAK PRODUCENTOW!");
        }

        try {
            for (Consumer consumer : consumers) {
                consumer.unpause();
                System.out.println(consumer.toString() + " started!");
            }
        } catch (NullPointerException e) {
            System.err.println("BRAK KONSUMENTOW!");
        }
    }

    void pauseAll() {
        try {
            for (Producer producer : producers) {
                producer.pause();
            }
        } catch (NullPointerException e) {
            System.err.println("BRAK PRODUCENTOW!");
        }

        try {
            for (Consumer consumer : consumers) {
                consumer.pause();
            }
        } catch (NullPointerException e) {
            System.err.println("BRAK KONSUMENTOW!");
        }
    }
}

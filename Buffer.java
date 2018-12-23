import javax.swing.*;

class Buffer {

    private int contents;
    private boolean available = false;

//    public synchronized int get(Consumer consumer) {
//        System.out.println("Konsument <" + consumer.name + "> chce zabrac");
//
//        while (available == false) {
//            try {
//                System.out.println("Konsument <" + consumer.name + ">   bufor pusty - czekam");
//                wait();
//            } catch (InterruptedException e) {
//
//            }
//        }
//        int item = contents;
//        available = false;
//        System.out.println("Konsument <" + consumer.name + ">      zabral: " + contents);
//        notifyAll();
//        return item;
//    }

    public synchronized int get_ta(Consumer consumer, JTextArea textArea) {
        textArea.append("Konsument <" + consumer.name + "> chce zabrac\n");

        while (available == false) {
            try {
                textArea.append("Konsument <" + consumer.name + ">   bufor pusty - czekam\n");
                wait();
            } catch (InterruptedException e) {

            }
        }
        int item = contents;
        available = false;
        textArea.append("Konsument <" + consumer.name + ">      zabral: " + contents + '\n');
        notifyAll();
        return item;
    }

//    public synchronized void put(Producer producer, int item){
//        System.out.println("Producent <" + producer.name + ">  chce oddac: " + item);
//        while (available == true){
//            try {
//                System.out.println("Producent <" + producer.name + ">   bufor zajety - czekam");
//                wait();
//            } catch (InterruptedException e) { }
//        }
//        contents = item;
//        available = true;
//        System.out.println("Producent <" + producer.name + ">       oddal: " + item);
//        notifyAll();
//    }

    public synchronized void put_ta(Producer producer, int item, JTextArea textArea){
        textArea.append("Producent <" + producer.name + ">  chce oddac: " + item + '\n');
        while (available == true){
            try {
                textArea.append("Producent <" + producer.name + ">   bufor zajety - czekam\n");
                wait();
            } catch (InterruptedException e) { }
        }
        contents = item;
        available = true;
        textArea.append("Producent <" + producer.name + ">       oddal: " + item + '\n');
        notifyAll();
    }

}

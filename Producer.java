import javax.swing.*;

class Producer extends Worker {

    public Producer(String name , Buffer buffer, JTextArea textArea){
        this.name = name;
        this.buffer = buffer;
        this.textArea = textArea;
    }

    @Override
    public void run() {
        int item;

        while(true) {
            item = itemID++;
            textArea.append("Producent <" + name + ">   produkuje: " + item + '\n');
            sleep(MIN_PRODUCER_TIME, MAX_PRODUCER_TIME);

            buffer.put_ta(this, item, textArea);
        }
    }

    public void pause() {
        textArea.append("Producent <" + name + "> czeka na wznowienie programu.\n");
        suspend();
    }

    public void unpause() {
        textArea.append("Producent <" + name + "> wznawia prace.\n");
        resume();
    }
}
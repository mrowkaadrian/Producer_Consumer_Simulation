import javax.swing.*;

class Consumer extends Worker {

    public Consumer(String name , Buffer buffer, JTextArea textArea){
        this.name = name;
        this.buffer = buffer;
        this.textArea = textArea;
    }

    @Override
    public void run() {
        int item;
        while(true) {
            item = buffer.get_ta(this, textArea);

            sleep(MIN_CONSUMER_TIME, MAX_CONSUMER_TIME);
            textArea.append("Konsument <" + name + ">       zuzyl: " + item + '\n');
        }
    }

    public void pause() {
        textArea.append("Konsument <" + name + "> czeka na wznowienie programu.\n");
        suspend();

    }

    public void unpause() {
        textArea.append("Konsument <" + name + "> wznawia prace.\n");
        resume();
    }

} 
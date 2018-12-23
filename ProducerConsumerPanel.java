import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProducerConsumerPanel extends JPanel implements ActionListener {

    JTextArea console = new JTextArea(30,30);
    ProducerConsumerLists lists = new ProducerConsumerLists(console);

    JButton applyButton = new JButton("Apply");
    JButton startButton = new JButton("Unpause");
    JButton stopButton = new JButton("Pause");

    Integer[] producerItems = {0,1,2,3,4,5};
    JComboBox<Integer> producersCombo = new JComboBox<Integer>(producerItems);
    Integer[] consumerItems = {0,1,2,3,4,5};
    JComboBox<Integer> consumersCombo = new JComboBox<Integer>(consumerItems);

    JLabel producersLabel = new JLabel("Number of Producers: ");
    JLabel consumberLabel = new JLabel("Number of Consumers: ");

    ProducerConsumerPanel() {

        this.add(producersLabel);
        this.add(producersCombo);
        this.add(consumberLabel);
        this.add(consumersCombo);
        this.add(applyButton);

        this.add(startButton);
        this.add(stopButton);
        this.add(console);

        producersCombo.setSelectedIndex(2);
        consumersCombo.setSelectedIndex(2);

        JScrollPane scrollPane = new JScrollPane(console);
        this.add(scrollPane);

        console.setLineWrap(true);
        console.setWrapStyleWord(true);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(400,300));

        startButton.addActionListener(this);
        stopButton.addActionListener(this);
        consumersCombo.addActionListener(this);
        producersCombo.addActionListener(this);
        applyButton.addActionListener(this);

        console.setEditable(false);

        lists.startAll();
    }

    public void start() {
        System.out.println("Started");
    }

    public void stop() {
        System.out.println("Stopped");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();

        if (source == startButton) {
            start();
            lists.unpauseAll();
        }
        if (source == stopButton) {
            stop();
            lists.pauseAll();
        }
        if (source == applyButton) {
            console.setText("");
            lists.stopAll();
            lists.setConsumers(consumersCombo.getSelectedIndex());
            lists.setProducers(producersCombo.getSelectedIndex());
            lists.startAll();
        }
    }
}

//TODO: STOP THREADS NORMALLY
//TODO: EXPAND "BUFFER" SIZE

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProducerConsumerWindow extends JFrame implements ActionListener {

    ProducerConsumerPanel panel = new ProducerConsumerPanel();

    ProducerConsumerWindow() {
        super("Producer/Consumer App");
        setContentPane(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 430);

        setFocusable(true);
        setVisible(true);
    }

    public ProducerConsumerPanel getPanel() {
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

    public static void main(String [] args) {
        ProducerConsumerWindow window = new ProducerConsumerWindow();

        Buffer buffer = new Buffer();

    }
}

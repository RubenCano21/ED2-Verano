import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FromArbol extends JFrame implements ActionListener, ActiveEvent {

    private JTextArea ta;
    private JButton boton1;
    ArbolB A;

    public FromArbol(){
        setLayout(null);
        A = new ArbolB();

        ta = new JTextArea();
        ta.setBounds(10, 25, 200, 150);
        ta.setFont(new Font("Roboto",Font.ITALIC,16));
        add(ta);

        boton1 = new JButton("In Orden");
        boton1.setBounds(250, 25, 100, 30);
        add(boton1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1){
            int x = Integer.parseInt(JOptionPane.showInputDialog("Eleem: "));

            A.insertar(x);
        }
    }



    public static void main(String[] args) {
        FromArbol form = new FromArbol();
        form.setBounds(0, 0, 700, 600);
        form.setVisible(true);
        form.setResizable(false);
        form.setLocationRelativeTo(null);
    }

    @Override
    public void dispatch() {

    }
}

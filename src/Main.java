import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        JFrame frame1=new JFrame("Programa busqueda");
        frame1.setContentPane((new Estudiante()).Estudiante);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(800, 600);
        frame1.pack();
        frame1.setVisible(true);
    }
}
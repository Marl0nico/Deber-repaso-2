import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.Scanner;
public class Estudiante {
    public JPanel Estudiante;
    private JTextArea Nombre;
    private JTextArea Cedula;
    private JTextArea B1;
    private JTextArea B2;
    private JTextField entradaNombre;
    private JTextField entradaCedula;
    private JTextField entradaB1;
    private JTextField entradaB2;
    private JButton Ingreso;
    private JLabel salidaTexto;
    String nombre, cedula;
    Double b1, b2;
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public Double getB1() {
        return b1;
    }
    public void setB1(Double b1) {
        this.b1 = b1;
    }
    public Double getB2() {
        return b2;
    }
    public void setB2(Double b2) {
        this.b2 = b2;
    }
    public Estudiante() {
        Ingreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/estudiantes2024a";
                String usuario = "root";
                String contraseña = "";
                Estudiante estudiantes=new Estudiante();
                nombre=entradaNombre.getText();
                cedula=entradaCedula.getText();
                b1=Double.valueOf(entradaB1.getText());
                b2=Double.valueOf(entradaB2.getText());
                estudiantes.setNombre(nombre);
                estudiantes.setCedula(cedula);
                estudiantes.setB1(b1);
                estudiantes.setB2(b2);
                String consulta="INSERT INTO estudiantes (cedula, nombre, b1, b2) VALUES (?, ?, ?, ?)";
                try (Connection connection=DriverManager.getConnection(url, usuario, contraseña)){
                    System.out.println("Conexión exitosa");
                    PreparedStatement cadenaPreparada=connection.prepareStatement(consulta);
                    cadenaPreparada.setString(1, cedula);
                    cadenaPreparada.setString(2, nombre);
                    cadenaPreparada.setDouble(3, b1);
                    cadenaPreparada.setDouble(4, b2);
                    cadenaPreparada.executeUpdate();
                    salidaTexto.setText("Datos ingresados correctamente");
                } catch (SQLException e1){
                    System.out.println(e1.getMessage());
                }
            }
        });
    }
}

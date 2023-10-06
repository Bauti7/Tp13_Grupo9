
package tp13_grupo9;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class Tp13_Grupo9 {
    
    public static void main(String[] args) {
        
        try {
            
            //Cargo Driver de conexión
            Class.forName("org.mariadb.jdbc.Driver");
            
            // establecer la conexión
            
            String URL = "jdbc:mariadb://localhost:3306/universidadejemplo";
            String usuario = "root";
            String password = "";
            
            Connection con = DriverManager.getConnection(URL,usuario,password);
            
            // -------- Dar de alta un alumno. ------------ 
            
//            String sql = "INSERT INTO alumno (dni,apellido,nombre, fechaDeNacimiento, estado)"
//                    
//                    + "VALUES (4412381, 'Gómez', 'Gastón', '1999-02-21', true)";
//           
            
            // -------- Dar de alta una materia. --------------

//            String sql2 = "INSERT INTO materia (nombre, año, estado)"
//                    
//                    + "VALUES ('Programación 2', 2, true)";
//            
//            PreparedStatement ps = con.prepareStatement(sql2);
//           
//            int filas = ps.executeUpdate();
//            
//            if(filas > 0){
//            
//                JOptionPane.showMessageDialog(null, "Materia agregada");
//                
//            }

            /// -------- Obtener los datos de los alumnos activos. ------------
            
//            String sql = "SELECT * FROM alumno WHERE estado = true";
//            
//            PreparedStatement ps = con.prepareStatement(sql);
//            
//            ResultSet rs = ps.executeQuery();
//            
//            while(rs.next()){
//            
//                int id = rs.getInt("idAlumno");
//                int dni = rs.getInt("dni");
//                String apellido = rs.getString("apellido");
//                String nombre = rs.getString("nombre");
//                LocalDate fechaN = rs.getDate("fechaDeNacimiento").toLocalDate();
//                boolean estado = rs.getBoolean("estado");
//                
//                System.out.println("-------------------");
//            
//                System.out.println("Dni " + dni);
//                System.out.println("Apellido " + apellido);
//                System.out.println("Nombre " + nombre);
//                System.out.println("Fecha de Nacimiento " + fechaN.toString());
//                System.out.println("Estado " + estado);
//            
//            }
//            
//            con.close();

            /// --------- Inscribir alumno -----------
            
//               String sql3 = "INSERT INTO inscripcion(nota, idAlumno, idMateria)"
//                       
//                       + "VALUES (7,7,4)";
//                       
//               PreparedStatement ps = con.prepareStatement(sql3);
//               
//               int filas = ps.executeUpdate();
//               
//               if(filas > 0){
//               
//                   JOptionPane.showMessageDialog(null, "Alumno Inscripto");
//               
//               }

            /// -------- Mostrar Notas mayores a 8 --------
            
                //Distinct para que no se repita filas con el mismo alumno en este caso

//                 String sql4 = "SELECT DISTINCT alumno.*, materia.* FROM alumno "
//                         + "JOIN inscripcion ON(alumno.idAlumno = inscripcion.idAlumno) "
//                         + "JOIN materia ON (materia.idMateria = inscripcion.idMateria)"
//                         + "WHERE inscripcion.nota > 8";
//                 
//                 PreparedStatement ps = con.prepareStatement(sql4);
//                 
//                 ResultSet rs = ps.executeQuery();
//                 
//                 while(rs.next()){
//                     
//                     int id=rs.getInt("idAlumno");
//                     int dni = rs.getInt("dni");
//                     String apellido  = rs.getString("apellido");
//                     String nombre = rs.getString("nombre");
//                     LocalDate fechN = rs.getDate("fechaDeNacimiento").toLocalDate();
//                     String materia = rs.getString("materia.nombre");
//                     
//                     System.out.println("");
//                         
//                         System.out.println("-----------DATOS DE ALUMNOS CON NOTA MAYOR A 8-----------");
//                     
//                         System.out.println("Id: " + id);
//                         System.out.println("Alumno : " + nombre);
//                         System.out.println("Apellido : " + apellido);
//                         System.out.println("DNI : " + dni);
//                         System.out.println("Fecha de nacimiento " + fechN.toString());
//                         System.out.println("Nombre de la materia " + materia);
//                     
//                     
//                 }
//                 
//                 con.close();

                    /// --------- Desinscribir un alumno de una de las materias ------
                    
//                    String sql5 = "DELETE FROM inscripcion WHERE idAlumno = 7 AND idMateria = 3";
//                    
//                    PreparedStatement ps = con.prepareStatement(sql5);
//                    
//                    int desinscribir = ps.executeUpdate();
//                    
//                    if(desinscribir > 0){
//                    
//                        JOptionPane.showMessageDialog(null, "Alumno borrado");
//                    
//                    }else{
//                    
//                        JOptionPane.showMessageDialog(null, "No existe el alumno");
//                        
//                    }            
                                     
            
        } catch (ClassNotFoundException ex) {
            
            JOptionPane.showMessageDialog(null, "Error al cargar Driver");
            
        } catch (SQLException ex) {
            
            int error = ex.getErrorCode();
            
            if( error == 1146){
                
                JOptionPane.showMessageDialog(null, "Tabla inexistente");
            
            }else if(error == 1062){
            
                JOptionPane.showMessageDialog(null, "DNI duplicado");
            
            }else if(error == 1049){
            
                JOptionPane.showMessageDialog(null, "BD inexistente");
            
            }else{
            
                JOptionPane.showMessageDialog(null, "Algún tipo de error");
            
            }
            
            JOptionPane.showMessageDialog(null, "Error de conexión");
            
            //Prueba 
            
            ex.printStackTrace();
            
            System.out.println("Codigo de error " + ex.getErrorCode());
            
        }
        
    }
    
}

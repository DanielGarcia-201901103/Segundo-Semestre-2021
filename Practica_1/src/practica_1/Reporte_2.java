package practica_1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Reporte_2 {

    public Reporte_2()  {
       
    }
    public void recibirTablero(){
        
    }
    public void bitacora() throws FileNotFoundException {
        FileOutputStream rep2 = new FileOutputStream("Bitacora.html");
        PrintStream t1 = new PrintStream(rep2);
        t1.println(
                " <HTML>"
                + "\t<HEAD>\n"
                + "\t <meta charset=\"utf-8\">\n"
                + "\t<TITLE> Reporte 2 </TITLE>\n"
                + "\n"
                + "\t</HEAD>\n"
                + "\t<BODY bgcolor =\"DDCCC8\">"
                + "\t<CENTER>\n"
                + "\t<h1> <b> Escaleras Matematicas </b></h1>\n"
                + "\t<p><h2> Bitácora </h2></p>"
                + "\t</CENTER>\n"
        );
        t1.println("\t<CENTER>\n"
                        + "\t<p>Se obtiene el resultado de sumar la matriz A y la matriz B.</p>"
                        + "\t<table border=\"1\">"
                        + "\t<tr>"
                        + "\t<th>Menu Principal</th>"
                        + "\t<th>Continuar o pausar</th>"
                        + "\t<th>Valor del dado</th>"
                        + "\t<th>Jugador</th>"
                        + "\t<th>No. Casilla </th>"
                        + "\t<th>Penalización </th>"
                        + "\t<th>Operación realizada</th>"
                        + "\t</tr>"
                        + "\t<tr>"   //datos para la fila 1
                        + "\t<td></td>"
                        + "\t<td></td>"
                        + "\t<td></td>"
                        + "\t<td></td>"
                        + "\t<td></td>"
                        + "\t</tr>"
                        + "\t<tr>"
                        + "\t<td></td>" //datos para la fila 2
                        + "\t<td></td>"
                        + "\t<td></td>"
                        + "\t<td></td>"
                        + "\t<td></td>"
                        + "\t</tr>"
                        + "\t<tr>"
                        + "\t<td></td>"  //datos para la fila 3
                        + "\t<td></td>"
                        + "\t<td></td>"
                        + "\t<td></td>"
                        + "\t<td>      </td>"
                        + "\t</tr>"
                        + "\t<tr>"
                        + "\t<td>        </td>"    //datos para la fila 4
                        + "\t<td>            </td>"
                        + "\t<td>           </td>"
                        + "\t<td>          </td>"
                        + "\t<td>             </td>"
                        + "\t</tr>"
                        + "\t</table>"
                        + "\t</CENTER>\n"
                );
        t1.println("<BODY>"
                + "</HTML>");
        t1.close();
    }
}

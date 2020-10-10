package plp;

import Objetos.Variavel;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorDeLua {

    private static List<Variavel> ListaOV = new ArrayList<Variavel>();
    private static List<String> w = new ArrayList<String>();

    public static void main(String[] args) throws FileNotFoundException, IOException {

        ManipuladorVariavel mv = new ManipuladorVariavel();
        ManipuladorRepeticao mr = new ManipuladorRepeticao();
        ManipuladorSaida ms = new ManipuladorSaida();
        //ManipuladorComando mc = new ManipuladorComando();
        ManipuladorLua h = null;

        try ( BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\PICHAU\\Documents\\lua-workspace\\blabla.lua"))) {

            for (String line; (line = br.readLine()) != null;) {

                if (line.startsWith("else")) {
                    //token
                    continue;
                } else if (line.startsWith("elseif")) {
                    //token
                    continue;

                } else if (line.startsWith("print")) {
                    h = ms;
                } else if (line.startsWith("for")) {
                    continue;
                } else if (line.startsWith("function")) {
                    continue;
                } else if (line.startsWith("if")) {
                    //token
                    continue;
                } else if (line.startsWith("in")) {
                    continue;
                } else if (line.startsWith("local")) {
                    continue;
                } else if (line.startsWith("nil")) {
                    //token
                    continue;
                } else if (line.startsWith("or")) {
                    //token
                    continue;
                } else if (line.startsWith("repeat")) {
                    continue;
                } else if (line.startsWith("return")) {
                    continue;
                } else if (line.startsWith("while")) {

                    do {
                        w.add(line);
                        line = br.readLine();
                    } while (!(line.startsWith("end")));
                    mr.loadBloco(w);
                    h = mr;
                    //continue;
                } else {
                    h = mv;
                    //varaivel                    
                }
                h.addline(line);
            }
        }
    }

    public static List<Variavel> getListaOV() {
        return ListaOV;
    }

    public static void setListaOV(List<Variavel> listaOV) {
        ListaOV = listaOV;
    }

}

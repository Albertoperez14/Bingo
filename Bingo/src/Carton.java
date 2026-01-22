import java.util.Random;

public class Carton {
    private int [][] carton= {{ 4,  0, 21,  0, 45,  0, 63, 74,  0 },
            { 8,  0,  0, 32,  0, 58, 0,  79, 83 },
            { 0,  14, 26,  0, 49, 0,  67, 0, 90 }};

    private boolean[][] comprobacion;

    public Carton() {
        comprobacion = new boolean[3][9];
        for (int i = 0; i < this.carton.length; i++) {
            for (int j = 0; j < this.carton[i].length; j++) {
                if(this.carton[i][j]==0){
                    comprobacion[i][j]=true;
                }
            }


        }
    }



    private void generarCartonAleatorio(int[][] carton2) {

    }

    public String toString() {
        String cadena = "";
        for (int i = 0; i < carton.length; i++) {
            cadena+="\n";
            for (int j = 0; j < carton[i].length; j++) {
                cadena += "\t" + carton[i][j];
            }
        }
        String cadena2 = "";
        for (int i = 0; i < comprobacion.length; i++) {
            cadena2+="\n";
            for (int j = 0; j < comprobacion[i].length; j++) {
                cadena2 += "\t" + comprobacion[i][j];
            }
        }
        return cadena + cadena2;
    }

    public String generarNumero(){
        Random aleatorio = new Random();
        for (int ind = 0; ind < 100; ind++) {
            int numero = aleatorio.nextInt(0,99);
            for (int i = 0; i < this.carton.length; i++) {
                for (int j = 0; j < this.carton[i].length; j++) {
                    if(this.carton[i][j]==numero){
                        this.comprobacion[i][j]=true;
                    }
                }


            }
        }
        String cadena = "";
        for (int i = 0; i < carton.length; i++) {
            cadena+="\n";
            for (int j = 0; j < carton[i].length; j++) {
                cadena += "\t" + carton[i][j];
            }
        }
        String cadena2 = "";
        for (int i = 0; i < comprobacion.length; i++) {
            cadena2+="\n";
            for (int j = 0; j < comprobacion[i].length; j++) {
                cadena2 += "\t" + comprobacion[i][j];
            }
        }
        return cadena + cadena2;

    }
    public boolean comprobarLinea() {
        boolean aux = true;
        boolean linea=false;
        for(int row = 0; row<comprobacion.length && linea==false; row++){
            aux=true;
            for(int col=0; col<comprobacion[row].length && aux==true;col++){
                if(comprobacion[row][col]==false){
                    aux=false;
                }
            }
            linea=aux;
        }
        return linea;
    }


    public boolean comprobarBingo() {
        boolean bingo = false;
        int contador = 0;
        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[i].length; j++) {
                if (comprobacion[i][j]) {
                    contador++;
                }

            }


        }
        if (contador == 27) {
            bingo = true;
        }
        return bingo;


    }

    public boolean marcarNumero(int bola){
        boolean marcado=false;
        for(int row = 0; row<carton.length; row++){
            for(int col = 0; col<carton[row].length; col++){
                if(carton[row][col]==bola){
                    comprobacion[row][col]=true;
                    marcado=true;
                }
            }
        }
        return marcado;
    }

    public boolean comprobarLineaNumero() {
        boolean aux = true;
        boolean linea=false;
        int contador = 0;
        for(int row = 0; row<comprobacion.length && linea==false; row++){
            aux=true;
            contador=0;

            for(int col=0; col<comprobacion[row].length && aux==true;col++) {
                if(comprobacion[row][col]==true){
                    contador++;
                }
                if (contador == 9) {
                    linea = true;
                }
            }
        }
        return linea;
    }
}
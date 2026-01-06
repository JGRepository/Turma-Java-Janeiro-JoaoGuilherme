import java.util.Date;

public class DataAtual{
    public static void main (String [] args){
        System.out.println("Imprimi data Atual: ");

        Date data = new Date();
        int tempo = (int)data.getTime();

        System.out.println("Imprimi data Atual: " + tempo);
    }
}
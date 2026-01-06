import java.util.Date;

public class MesAno{
    public static void main (String [] args){
        System.out.println("Abaixo segue mes e ano atual: ");

        Date data = new Date();
        int month = data.getMonth() + 1;
        int year = data.getYear() + 1900;

        System.out.println("Mes atual = " + month);
        System.out.println("Ano atual = " + year);
    }
}

public class Teste {


    public static void main(String [] args){

	double dia=400;
	double mes=0,ano=0; 
	System.out.println("Dia: "+(int)Math.ceil(Math.abs((dia%365)%30))+
			   " Meses: "+(int) Math.round(Math.abs((dia%365)/30))+
			   " Anos: " + (int)(dia/365));
    }
}

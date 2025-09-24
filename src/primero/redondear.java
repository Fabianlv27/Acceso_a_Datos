package primero;

import java.util.Iterator;

public class redondear {
	
	public static double red(double n,int digitos) {
		int exponente=(int)Math.pow(10,digitos);
		return (double)Math.round(exponente*100)/exponente;
	}
	
	public static double truncar(double n,int digitos) {
		int exponente=(int)Math.pow(10,digitos);
		System.out.println(exponente + n);
		int truncado1=(int)(n*exponente);
		System.out.println(truncado1);
		double truncado2=(double)truncado1/exponente;
		return truncado2;
	}
	public static void main(String[] args) {
		System.out.println(truncar(18.246,2));
	}
}

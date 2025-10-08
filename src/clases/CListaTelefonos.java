package clases;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CListaTelefonos {
	private RandomAccessFile fes;
	private int nregs;
	private int tamañoReg=140;
	public CListaTelefonos(File fichero) throws IOException {
		if (fichero.exists()&&!fichero.isFile()) {
			throw new IOException(fichero.getName()+"no es un fichero");
		}
		fes=new RandomAccessFile(fichero, "rw");
		nregs=(int) Math.ceil(fichero.length()/this.tamañoReg);
	}
	
	
	
	public RandomAccessFile getFes() {
		return fes;
	}



	public void setFes(RandomAccessFile fes) {
		this.fes = fes;
	}



	public int getNregs() {
		return nregs;
	}



	public void setNregs(int nregs) {
		this.nregs = nregs;
	}



	public int getTamañoReg() {
		return tamañoReg;
	}



	public void setTamañoReg(int tamañoReg) {
		this.tamañoReg = tamañoReg;
	}



	/**
	 * @throws IOException ************************/
	
	public boolean ponerValorEn(int i,CPersona p) throws IOException {
		
		if(i>=0 && i<=nregs) {
			if (p.tamaño()+4<getTamañoReg()) {
				System.out.println("tamaño del registro excedido");
			}else {
		fes.seek(i*tamañoReg);
		fes.writeUTF(p.getNombre());
		fes.writeUTF(p.getDireccion());
		fes.writeLong(p.getTelefono());
		return true;
			}
			
		}else {
			System.out.println("numero de registro fuera de limites");
		}
		return false;

	}
	
	public CPersona valorEn(int i) {
		if(i>0 && i<nregs) {
			fes.seek(i*tamañoReg);
			return new CPersona(fes.readUTF(),fes.readUTF(),fes.readLong())
		}
	}
	
}

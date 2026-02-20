package customexceptions;

public class LibroNuevoException extends Exception {

	private String msg;

	public LibroNuevoException(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return msg;
	}



}

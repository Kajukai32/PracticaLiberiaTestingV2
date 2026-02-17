package customexceptions;

public class BorrarLibroException extends Exception {

	private String msg;

	public BorrarLibroException(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return msg;
	}



}

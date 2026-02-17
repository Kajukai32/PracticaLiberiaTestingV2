package customexceptions;

public class RegistroLibroException extends Exception {

	private String msg;

	public RegistroLibroException(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return msg;
	}


}

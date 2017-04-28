package com.cupones.excepciones;

public class InternalServicesException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3042143152842059538L;
	
	private static final Integer CODIGO = 99;
	private static final String MENSAJE = "Error interno del servicio";
	
	private final Exception exception;
	
	public InternalServicesException(Exception exception) {
		this.exception = exception;
	}

	public Exception getException() {
		return exception;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exception == null) ? 0 : exception.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InternalServicesException other = (InternalServicesException) obj;
		if (exception == null) {
			if (other.exception != null)
				return false;
		} else if (!exception.equals(other.exception))
			return false;
		return true;
	}
	public static Integer getCodigo() {
		return CODIGO;
	}
	public static String getMensaje() {
		return MENSAJE;
	}
	@Override
	public String toString() {
		return "InternalServicesException [exception=" + exception + "]";
	}
	
	
	
}

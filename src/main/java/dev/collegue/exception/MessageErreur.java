package dev.collegue.exception;

public class MessageErreur {
	
	private CodeErreur code;
	
	private String message;
	public MessageErreur(CodeErreur code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public CodeErreur getCode() {
		return code;
	}

	public void setCode(CodeErreur code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

}

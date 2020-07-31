package dev.collegue.exception;

public class CollegueException extends RuntimeException {
	private MessageErreur messageErreur;

	public CollegueException(MessageErreur messageErreur) {
		super(messageErreur.getMessage());
		this.messageErreur = messageErreur;
	}

	public MessageErreur getMessageErreur() {
		return messageErreur;
	}
	
}

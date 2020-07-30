package dev.collegue.exception;

public class CollegueNonTrouveException extends RuntimeException {
	private MessageErreur messageErreur;

	public CollegueNonTrouveException(MessageErreur messageErreur) {
		super(messageErreur.getMessage());
		this.messageErreur = messageErreur;
	}

	public MessageErreur getMessageErreur() {
		return messageErreur;
	}
	
}

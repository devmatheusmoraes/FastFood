package br.edu.infnet.fastFood.exceptions;

public class ComidaException extends RuntimeException {

           public ComidaException(String message) {
            super(message);
        }

        public ComidaException(String message, Throwable cause) {
            super(message, cause);
        }

}

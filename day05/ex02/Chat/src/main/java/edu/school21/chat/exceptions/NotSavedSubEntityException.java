package edu.school21.chat.exceptions;

public class NotSavedSubEntityException extends Exception{
	// @Override
    public NotSavedSubEntityException(Exception e) {
        System.out.println("Не удалось сохранить((");
		// System.out.println(e);
    }
}

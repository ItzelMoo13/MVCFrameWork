package core;

import exceptions.NonExistentModelException;
import exceptions.NonExistentTransaction;

public interface Model 
{
	public void attach(View view) throws NonExistentModelException;
	public void detach(View view) throws NonExistentModelException;
	public void notifyViews() throws NonExistentModelException, NonExistentTransaction;
}

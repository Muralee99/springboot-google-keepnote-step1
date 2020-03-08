package com.stackroute.keepnote.repository;

import com.stackroute.keepnote.model.Note;

import java.util.ArrayList;
import java.util.List;

/*
 * This class contains the code for data storage interactions and methods 
 * of this class will be used by other parts of the applications such
 * as Controllers and Test Cases
 * */

public class NoteRepository {

	/* Declare a variable called "list" to store all the notes. */

	private List<Note> noteCollection;

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	private Note note;

	public NoteRepository() {

		/* Initialize the variable using proper data type */

		this.noteCollection = new ArrayList<>();
		//this.note = new Note();
	}

	/* This method should return all the notes in the list */

	public List<Note> getList() {
		return noteCollection;
	}

	/* This method should set the list variable with new list of notes */

	public void setList(List<Note> list) {
		this.noteCollection = list;
	}

	/*
	 * This method should Note object as argument and add the new note object into
	 * list
	 */

	public void addNote(Note note) {
		this.note = note;
		this.noteCollection.add(note);
	}

	/* This method should deleted a specified note from the list */

	public boolean deleteNote(int noteId) {
		/* Use list iterator to find matching note id and remove it from the list */
		boolean noteExists = false;
		for(Note note: noteCollection)
		{
			if(note.getNoteId() == noteId)
			{
				noteCollection.remove(note);
				noteExists = true;
				break;
			}
		}

		return noteExists;
	}

	/* This method should return the list of notes */

	public List<Note> getAllNotes() {
		return noteCollection;
	}

	/*
	 * This method should check if the matching note id present in the list or not.
	 * Return true if note id exists in the list or return false if note id does not
	 * exists in the list
	 */

	public boolean exists(int noteId)
	{
		boolean noteExists = false;

		for(Note note: noteCollection)
		{
			if(note.getNoteId() == noteId)
			{
				noteExists = true;
			}
		}

		return noteExists;
	}
}
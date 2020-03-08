package com.stackroute.keepnote.model;

import java.time.LocalDateTime;
import java.util.Objects;

/*
 * The class "Note" will be acting as the data model for the Note data in the ArrayList.
 */
public class Note implements Comparable<Note>{

	/*
	 * This class should have five fields (noteId, noteTitle, noteContent,
	 * noteStatus and createdAt). This class should also contain the getters and
	 * setters for the fields. The value of createdAt should not be accepted from
	 * the user but should be always initialized with the system date
	 */

	private int noteId;

	private String noteTitle;

	private String noteContent;

	private String noteStatus;

	private LocalDateTime createdAt;


	public Note(int noteId, String noteTitle, String noteContent, String noteStatus, LocalDateTime createdAt)
	{
		this.noteId = noteId;
		this.noteTitle = noteTitle;
		this.noteContent = noteContent;
		this.noteStatus = noteStatus;
		this.createdAt = createdAt;
	}

	public Note()
	{

	}

	/* All the getters/setters definition should be implemented here */

	public int getNoteId() {
		return noteId;

	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	public String getNoteTitle() {
		return noteTitle;
	}

	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}

	public String getNoteContent() {
		return noteContent;
	}

	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}

	public String getNoteStatus() {
		return noteStatus;
	}

	public void setNoteStatus(String noteStatus) {
		this.noteStatus = noteStatus;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime localdatetime) {
		this.createdAt = LocalDateTime.now();
	}

	@Override
	public int compareTo(Note note) {

		if(createdAt.compareTo(note.createdAt) == 0) {
			return 0;
		}
		else if(createdAt.compareTo(createdAt) > 0) {
			return 1;
		}
		else {
			return -1;
		}
	}

	@Override
	public boolean equals(Object object)
	{
		if(this == object)
		{
			return  true;
		}
		if(object == null || getClass() != object.getClass()) {
			return false;
		}
		Note note = (Note)object;
		return noteId == note.noteId;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(noteId);
	}

	/* Override the toString() method */

	@Override
	public String toString() {
		return noteId +" " +noteTitle +" "+noteStatus+" "+ noteContent +" "+ createdAt;
	}

}
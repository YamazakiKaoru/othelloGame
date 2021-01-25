package model.Field;

import model.Board.Board;
import model.Rogin.User;

public class Field {
	private Board board;
	private User user1;
	private User user2;

	private String fieldTitle;
	private String pass;

	//人数
	private int number;

	//
	public Field(String title,String pass){
		this.fieldTitle = title;
		this.pass = pass;
		number = 0;
	}

	public void setUser(User user) {
		if(user1 == null)user1 = user;
		else if(user2 == null) user2= user;
		number++;
		}

	public boolean checkPass() {
		if(pass == null)return false;
		else return true;
	}

	public Board getBoard() {return board;}
	public String getFieldTitle() {return fieldTitle;}
	public int getNumber() {return number;}

	public void setBoard(Board board) { this.board = board;}
	public void setNumber(int number) { this.number = number;}


	public boolean checkCanIn() {
		if(number >= 0 && number < 2)return true;
		else return false;
	}

	public void print() {
		if(user1 != null)System.out.println("user1 "+user1.getName());
		 if(user2 != null)System.out.println("User2 "+user2.getName());
	}
}

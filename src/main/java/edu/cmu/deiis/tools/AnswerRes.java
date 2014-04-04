package edu.cmu.deiis.tools;

/*
 * Object representation of the Answer annotation
 */
public class AnswerRes {
	String		Text;		//Text extracted from document
	double		Score;		//Score given to evaluation
	boolean		IsCorrect;	//Original classification
	
	public AnswerRes(String text, double score, boolean isCorrect) {
		Text = text;
		Score = score;
		IsCorrect = isCorrect;
	}
	
	public void setText(String text) {
		Text = text;
	}
	
	public void setScore(double score) {
		Score = score;
	}
	
	public void setIsCorrect(boolean isCorrect) {
		IsCorrect = isCorrect;
	}
	
	public String getText() {
		return Text;
	}
	
	public double getScore() {
		return Score;
	}
	
	public boolean IsCorrect() {
		return IsCorrect;
	}
}

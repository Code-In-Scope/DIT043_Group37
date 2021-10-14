package bussinessLogic;

import util.Calculate;

import java.util.ArrayList;
import java.util.List;

public class Review {

    private String comment;
    private int grade;

    public Review(int grade, String comment)
    {
        this.grade = grade;
        this.comment = comment;
    }

    public String printReview()
    {
        return "Grade: " + this.grade + " . " + this.comment;
    }
    public int getGrade()
    {
        return this.grade;
    }
    public String getComment() { return this.comment; }
}

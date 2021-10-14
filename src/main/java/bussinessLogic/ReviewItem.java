package bussinessLogic;

import util.Calculate;

import java.util.ArrayList;
import java.util.List;

public class ReviewItem {
    boolean isReviewed;
    private StringBuilder reviewComment;
    private ArrayList<Integer> reviewGrade;
    private List<String> writtenComments;

    public ReviewItem(String itemID, String name, double unitPrice)
    {
        this.reviewComment = new StringBuilder();
        this.reviewGrade = new ArrayList<>();
        this.writtenComments = new ArrayList<>();
        this.reviewComment.append("Review(s) for ").append(itemID).append(":").append(name).append(unitPrice).append("\n");
        this.isReviewed = false;
    }

    public String addReviewComment(int reviewGrade, String reviewComment)
    {
        this.reviewGrade.add(reviewGrade);
        this.writtenComments.add(reviewComment);
        this.reviewComment.append(reviewGrade).append(".").append(reviewComment).append("\n");
        this.isReviewed = true;
        return "Your item review was registered successfully";
    }

    public  boolean isItemReviewed(){
        return this.isReviewed;
    }

    public String printAllReviews()
    {
        return this.reviewComment.toString();
    }

    public double meanGrade()
    {
        if(isItemReviewed())
        {
            int totalGradeValue = 0;
            for (int grade:this.reviewGrade)
            {
                   totalGradeValue += grade;
            }
            int average= totalGradeValue/this.reviewGrade.size();
            return Calculate.truncateDouble(average,1);
        }
        return -1.0;
    }

    public List<String> getWrittenComments()
    {
        return this.writtenComments;
    }

    public int getNumberOfReviews()
    {
        return this.reviewGrade.size();
    }


}

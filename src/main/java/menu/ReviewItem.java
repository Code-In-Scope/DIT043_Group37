package menu;

public class ReviewItem {
    private String reviewComment;
    private int reviewGrade;

    public ReviewItem(String reviewComment, int reviewGrade){
        this.reviewComment = reviewComment;
        this.reviewGrade = reviewGrade;
    }

    public String getReviewComment(){
        return this.reviewComment;
    }
    public int getReviewGrade(){
        return this.reviewGrade;
    }
    public String ToString(){
        return "Grade: " + this.reviewGrade + ". " + reviewComment;
    }

}

package bussinessLogic.Item;

public final class Review {

  private String comment;
  private int grade;
  private boolean noReviewComment;

  public Review(int grade, String comment) {
    this.grade = grade;
      this.comment = comment;
      noReviewComment = (comment == "");
  }
  @Override
  public String toString() {
    String output;
    if(noReviewComment)
    {
      output = "Grade: " + this.grade + ".";
    }
    else
    {
      output = "Grade: " + this.grade + "." + this.comment;
    }
    return output;
  }
  public int getGrade() { return grade; }

  public boolean hasComment() { return !noReviewComment; }

  public String getComment()
  {
    return comment;
  }
}

package bussinessLogic;

public final class Review {

  private String comment;
  private int grade;

  public Review(int grade, String comment) {
    this.grade = grade;
    this.comment = comment;
  }
  @Override
  public String toString() {
    return "Grade: " + this.grade + "." + this.comment;
  }
  public int getGrade() { return this.grade; }
  public String getComment() { return this.comment; }
}

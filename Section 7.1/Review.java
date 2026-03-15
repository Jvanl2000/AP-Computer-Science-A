public class Review {

    private int rating;
    private String comment;

    /** Precondition: r >= 0
    * c is not null. */
    public Review(int r, String c) {
        rating = r;
        comment = c;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }
}
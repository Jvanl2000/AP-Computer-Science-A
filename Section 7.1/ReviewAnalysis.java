import java.util.ArrayList;

public class ReviewAnalysis {

    /** All user reviews to be included in this analysis */
    private Review[] allReviews;

    /** Initializes allReviews to contain all the Review objects to be analyzed */
    public ReviewAnalysis(Review[] reviews) { 
        allReviews = reviews;
    }

    /** Returns a double representing the average rating of all the Review objects to be
    * analyzed, as described in part (a)
    * Precondition: allReviews contains at least one Review.
    * No element of allReviews is null. */
    public double getAverageRating() { 
        double total = 0;
        for (Review review : allReviews) total += review.getRating();
        return total / allReviews.length;
    }

    /** Returns an ArrayList of String objects containing formatted versions of
    * selected user comments, as described in part (b)
    * Precondition: allReviews contains at least one Review.
    * No element of allReviews is null.
    * Postcondition: allReviews is unchanged. */
    public ArrayList<String> collectComments() { 
        ArrayList<String> returnList = new ArrayList<String>();
        for (int i = 0; i < allReviews.length; i++) {
            if (allReviews[i].getComment().contains("!")) {
                String addString = i + "-" + allReviews[i].getComment();
                if (allReviews[i].getComment().endsWith(".") || allReviews[i].getComment().endsWith("!"))
                    returnList.add(addString);
                else
                    returnList.add(addString + ".");
            }
        }

        return returnList;
    }

    public static void main(String[] args) {
        Review[] reviews = new Review[5];
        reviews[0] = new Review(4, "Good! Thx");
        reviews[1] = new Review(3, "OK site");
        reviews[2] = new Review(5, "Great!");
        reviews[3] = new Review(2, "Poor! Bad.");
        reviews[4] = new Review(3, "");
        ReviewAnalysis raObject = new ReviewAnalysis(reviews);
        System.out.println(raObject.getAverageRating());
        System.out.println(raObject.collectComments());
    }
}
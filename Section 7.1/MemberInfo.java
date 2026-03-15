public class MemberInfo {

    private final String name;
    private final int graduationYear;
    private boolean inGoodStanding;

    /** Constructs a MemberInfo object for the club member with name name,
    * graduation year gradYear, and standing hasGoodStanding. */
    public MemberInfo(String name, int gradYear, boolean hasGoodStanding) { 
        this.name = name;
        graduationYear = gradYear;
        inGoodStanding = hasGoodStanding;
    }

    /** Return the name of the club member. */
    public String getName() {
        return name;
    }

    /** Returns the graduation year of the club member. */
    public int getGradYear() { 
        return graduationYear;
    }

    /** Returns true if the member is in good standing and false otherwise. */
    public boolean inGoodStanding() {
        return inGoodStanding;
    }

    @Override
    public String toString() {
        return name;
    }
}
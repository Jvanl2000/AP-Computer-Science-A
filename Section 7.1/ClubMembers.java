import java.util.ArrayList;

public class ClubMembers {

    private ArrayList<MemberInfo> memberList;

    public ClubMembers(ArrayList<MemberInfo> members) {
        memberList = members;
    }

    /** Adds new club members to memberList, as described in part (a).
    * Precondition: names is a non-empty array. */
    public void addMembers(String[] names, int gradYear) { 
        for (String name : names)
            memberList.add(new MemberInfo(name, gradYear, true));
    }

    /** Removes members who have graduated and returns a list of members who have graduated
    * and are in good standing, as described in part (b). */
    public ArrayList<MemberInfo> removeMembers(int year) { 
        ArrayList<MemberInfo> returnList = new ArrayList<MemberInfo>();
        
        int index = 0;
        while (index < memberList.size()) {
            MemberInfo currentMember = memberList.get(index);
            if (currentMember.getGradYear() <= year) {
                if (currentMember.inGoodStanding()) returnList.add(currentMember);
                memberList.remove(currentMember);
                continue;
            }

            index++;
        }

        return returnList;
    }

    @Override
    public String toString() {
        return memberList.toString();
    }

    public static void main(String[] args) {
        ArrayList<MemberInfo> members = new ArrayList<MemberInfo>();
        members.add(new MemberInfo("SMITH, JANE", 2019, false));
        members.add(new MemberInfo("FOX, STEVE", 2018, true));
        members.add(new MemberInfo("XIN, MICHAEL", 2017, false));
        members.add(new MemberInfo("GARCIA, MARIA", 2020, true));
        ClubMembers cmObject = new ClubMembers(members);

        System.out.println(cmObject);
        System.out.println(cmObject.removeMembers(2018));
        System.out.println(cmObject);
    }

}
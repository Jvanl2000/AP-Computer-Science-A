public class MyDate {
    
    private int month;
    private int day;
    private int year;

    public MyDate(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public boolean before(MyDate d) {
        if (this.year < d.year) return true;
        if (this.year > d.year) return false;
        if (this.month < d.month) return true;
        if (this.month > d.month) return false;
        if (this.day < d.day) return true;
        if (this.day > d.day) return false;
        return false;
    }

    public boolean after(MyDate d) {
        if (this.year > d.year) return true;
        if (this.year < d.year) return false;
        if (this.month > d.month) return true;
        if (this.month < d.month) return false;
        if (this.day > d.day) return true;
        if (this.day < d.day) return false;
        return false;
    }

    public boolean equals(MyDate d) {
        return this.year == d.year && this.month == d.month && this.day == d.day;
    }

    private boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        if (year % 4 == 0) return true;
        return false;
    }

    private int daysInMonth(int month, int year) {
        if (month == 2) {
            if (isLeapYear(year)) return 29;
            else return 28;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) return 30;
        return 31;
    }

    private MyDate previousDay() {
        this.day--;
        if (this.day < 1) {
            this.month--;
            if (this.month < 1) {
                this.month = 12;
                this.year--;
            }
            this.day = daysInMonth(this.month, this.year);
        }

        return new MyDate(this.month, this.day, this.year);
    }

    private MyDate nextDay() {
        this.day++;
        if (this.day > daysInMonth(this.month, this.year)) {
            this.day = 1;
            this.month++;
            if (this.month > 12) {
                this.month = 1;
                this.year++;
            }
        }

        return new MyDate(this.month, this.day, this.year);
    }

    public int daysTo(MyDate d) {
        int count = 0;
        MyDate current = new MyDate(this.month, this.day, this.year);
        while (!current.equals(d)) {
            if (current.before(d)) {
                current.nextDay();
                count++;
            } else {
                current.previousDay();
                count--;
            }
        }
        
        return count;
    }

    // Zeller’s Congruence
    public String dayOfWeek() {
        int m = this.month;
        int y = this.year;
        if (m < 3) {
            m += 12;
            y -= 1;
        }

        int k = y % 100;
        int j = y / 100;
        int f = this.day + (13 * (m + 1)) / 5 + k + k / 4 + j / 4 - 2 * j;
        int dayOfWeek = ((f % 7) + 7) % 7;
        String[] days = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        return days[dayOfWeek];
    }

    public boolean inLeapYear() {
        return isLeapYear(this.year);
    }

    // format at Month Day(st,nd,rd,th), Year
    @Override
    public String toString() {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String suffix = "th";
        if (this.day == 1 || this.day == 21 || this.day == 31) {
            suffix = "st";
        } else if (this.day == 2 || this.day == 22) {
            suffix = "nd";
        } else if (this.day == 3 || this.day == 23) {
            suffix = "rd";
        }
        return months[this.month - 1] + " " + this.day + suffix + ", " + this.year;
    }

    public static void main(String[] args) {
        MyDate dateOne = new MyDate(4, 5, 1937);
        MyDate dateTwo = new MyDate(9, 8, 1968);
        MyDate dateThree = new MyDate(4, 16, 1999);
        MyDate dateFour = new MyDate(8, 30, 2001);
        MyDate dateFive = new MyDate(1, 1, 1900);
        MyDate dateSix = new MyDate(1, 1, 2000);
        StdOut.println(dateOne);
        StdOut.println(dateTwo);
        StdOut.println(dateThree);
        StdOut.println(dateFour);
        StdOut.println(dateFive.inLeapYear());
        StdOut.println(dateSix.inLeapYear());
        StdOut.println(dateOne.before(dateTwo));
        StdOut.println(dateThree.after(dateFour));
        StdOut.println(dateOne.equals(dateOne));
        StdOut.println(dateOne.daysTo(dateTwo));
        StdOut.println(dateFour.daysTo(dateThree));
        StdOut.println(dateOne.dayOfWeek());
        StdOut.println(dateTwo.dayOfWeek());
        StdOut.println(dateThree.dayOfWeek());
        StdOut.println(dateFour.dayOfWeek());
    }
}

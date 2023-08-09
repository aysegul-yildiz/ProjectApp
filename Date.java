import java.util.ArrayList;

public class Date 
{
    // Ayşegül Yıldız 
    // declare variables
    private int day;
    private int month;
    private int year;
    private static ArrayList<Integer> numOfDays;

    // create constructor
    public Date ( int day, int month, int year )
    {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // create overloaded copy constructor
    public Date ( Date projcetedStartDate )
    {
        this.day = projcetedStartDate.day;
        this.month = projcetedStartDate.month;
        this.year = projcetedStartDate.year;
    }
    
    // getters and setters for all private attributes
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        if (month<= 12 && month >0 ){
            this.month = month;
        }
    }
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        if ( day > 0 && day <= 31 ){
            this.day = day;
        }
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    // creates a string date formatted as YYYY-MM-DD
    public String toString ( )
    {
        String date = this.year + "-" + this.month + "-" + this.day;
        return date;
    }

    // control if the year is a leap year by checking if it divides to four evenly
    public boolean isLeapYear ( int year )
    {
        if ( year % 4 == 0 )
        {
            return true;
        }
        else 
        {
            return false;
        }
    }

    // get the days between a given date and the date
    public int daysBetween ( Date projectedStartDate )
    {
        int daysBet = 0;
        // if the years are not equal first add 365 days and then check month and day
        if ( projectedStartDate.year != this.year )
        {
            daysBet += (this.year - projectedStartDate.year * 365);

            if ( projectedStartDate.month == this.month )
            {
                daysBet += this.day - projectedStartDate.day;
            }
            else 
            {
                for ( int i = 0; projectedStartDate.month + i <this.month; i++)
                {
                    daysBet += initDaysInMonth(projectedStartDate.month + i - 1);
                }
                daysBet += this.day;
            }
            return daysBet;
        }
        // if the years are equal compare the months and days
        else if ( projectedStartDate.year == this.year )
        {
            if ( projectedStartDate.month == this.month )
            {
                daysBet += this.day - projectedStartDate.day;
            }
            else 
            {
                for ( int i = 0; projectedStartDate.month + i < this.month; i++)
                {
                    daysBet += initDaysInMonth(projectedStartDate.month + i - 1) - projectedStartDate.day ;
                }
                daysBet += this.day;
            }
        }
        return daysBet;
    }

    // add days to the date
    public void addDays ( int days )
    {
        // if the days are smaller than the rest of the days left in the mont then just add the days variable to the day
        if ( days < (initDaysInMonth(this.month - 1 ) -this.day) )
        {
            this.day += days;
        }
        // if days are bigger than the rest of the days left in the month then increment and decrease the days variable until it is smaller than the days left 
        else if ( days >= (initDaysInMonth(this.month - 1 ) -this.day) )
        {
            for (int i = this.month; days >= (initDaysInMonth( i - 1 ) - this.day) ; i++ )
            {
                days -= (initDaysInMonth( i -1 ) - this.day);
                this.month ++ ;
                this.day = 0;
            }
            this.day += days;
        }
    }

    // check if the given date is before the date and return false if it is 
    public boolean isBefore ( Date projectedStartDate )
    {
        if ( this.year > projectedStartDate.year )
        {
            return true;
        }
        else if ( this.year == projectedStartDate.year )
        {
            if ( this.month > projectedStartDate.month )
            {
                return true;
            }
            else if ( this.month == projectedStartDate.month )
            {
                if ( this.day > projectedStartDate.day )
                {
                    return true;
                }
                else 
                {
                    return false;
                }
            }
            else 
            {
                return false;
            }
        }
        else 
        {
            return false;
        }
    } 

    // create an array list containing the day number for all the months considering if it is a leap year index 1 should be replaced with 29
    public int initDaysInMonth( int num )
    {
        numOfDays = new ArrayList<>(12);
        numOfDays.add(31);
        numOfDays.add(28);
        numOfDays.add(31);
        numOfDays.add(30);
        numOfDays.add(31);
        numOfDays.add(30);
        numOfDays.add(31);
        numOfDays.add(31);
        numOfDays.add(30);
        numOfDays.add(31);
        numOfDays.add(30);
        numOfDays.add(31);
        if ( isLeapYear( year ) )
        {
            numOfDays.remove(1);
            numOfDays.set(1,29);
        }
        int i = numOfDays.get(num);
        return i;
    }

}
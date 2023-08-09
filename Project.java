public class Project 
{
    // Ayşegül Yıldız

    // declare variables
    private String projectName; 
    private String projectDescription; 
    private Date projectedStartDate; 
    private Date projectedEndDate;
    private String projectId;
    private String projectType;
    private String actualEndDate;
    private boolean isActive;
    private int projectCounter = 1000 ;

    // constructor for the Project class
    public Project (String projectName, String projectDescription, Date projectedStartDate, Date projectedEndDate )
    {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.projectedStartDate = projectedStartDate;
        this.projectedEndDate = projectedEndDate;
    }

    // getters and setters for all private attributes
    public int getProjectCounter() {
        return projectCounter;
    }
    public void setProjectCounter(int projectCounter) {
        this.projectCounter = projectCounter;
    }
    public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public String getProjectDescription() {
        return projectDescription;
    }
    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }
    public Date getProjectedStartDate() {
        return projectedStartDate;
    }
    public void setProjectedStartDate( Date projectedStartDate) {
        this.projectedStartDate = projectedStartDate ;
    }
    public Date getProjectedEndDate() {
        return projectedEndDate;
    }
    public void setProjectedEndDate( Date projectedEndDate) {
        this.projectedEndDate = projectedEndDate;
    }
    public String getProjectId() {
        setProjectId(projectId);
        return projectId;
    }
    // set the project id depending on the project type
    public void setProjectId(String projectId) {
        String id = " ";
        getProjectType();
        if ( projectType.equals("SHORT TERM"))
        {
            id = "ST-" + projectCounter;
        }
        else if (projectType.equals("INTERMEDIATE"))
        {
            id = "IM-" + projectCounter;
        }
        else if ( projectType.equals("LONG TERM"))
        {
            id = "LT-" + projectCounter;
        }
        this.projectId = id;
    }
    public String getProjectType() {
        setProjectType();
        return projectType;
    }
    // set the project type by calculating the days between two dates and deciding the type accordingly
    public void setProjectType()
    {
        int projectDuration = projectedEndDate.daysBetween( projectedStartDate );
        String type = " ";
        if ( projectDuration <= 366 )
        {
            type = "SHORT TERM";
        }
        else if ( projectDuration > 366 && projectDuration <= 1096 )
        {
            type = "INTERMEDIATE";
        }
        else if ( projectDuration > 1096 )
        {
            type = "LONG TERM";
        }
        this.projectType = type;
    }
    public String getActualEndDate() {
        return actualEndDate;
    }
    public void setActualEndDate(String actualEndDate) {
        this.actualEndDate = actualEndDate;
    }
    public boolean getIsActive() {
        isActive = true;
        return isActive;
    }
    public void setActive(boolean isActive) {
        isActive = true;
        this.isActive = isActive;
    }
    // decativates the project and updates the actual end date
    public void deactivateProject( String newDate )
    {
        this.actualEndDate = newDate;
        this.isActive = false;
    }
    // activates the project and sets actual end date to null
    public void activateProject ( )
    {
        this.actualEndDate = null;
        this.isActive = true;
    }
    // calculate estimated days to completion by using date class and days between method
    public int estimatedDaysToCompletion()
    {
        int estDays = projectedEndDate.daysBetween(projectedStartDate);
        return estDays;
    }
    // determine the new end date for the project by using date class add days method
    public void pushProject ( int days )
    {
        projectedEndDate.addDays(days);
        setProjectType();
    }
    // return true if the two project names are the same do the projects are the same
    public boolean equals ( String project1, String project2 )
    {
        if (project1.equals(project2))
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
    // create the string version of the required information of the project object
    public String toString ( )
    {
        String printProject;
        if (isActive != true )
        {
            printProject =  "ID: ( " + getProjectId() + " ) \n" + projectName + "\n" + projectDescription + "\n" + "COMPLETED: " + actualEndDate;
        }
        else
        {
            printProject =  "ID: ( " + getProjectId() + " ) \n" + projectName + "\n" + projectDescription + "\n" + "Start: " + projectedStartDate.toString() + "  End: " + projectedEndDate.toString(); 
        }
        return printProject;
    }
}

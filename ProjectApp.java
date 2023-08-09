public class ProjectApp 
{
    public static void main(String[] args) 
    {
        // Ayşegül Yıldız
       
        // create the needed objects and pass the data needed to use the objects
        Date start1 = new Date (22, 5, 2022);
        Date end1 = new Date(21, 6, 2022 );
        Date start2 = new Date (22, 5, 2023);
        Date end2 = new Date(30, 9, 2023 );
        Project project1 = new Project( "Sys-Renew", "Upgrade payroll system and hardware", start1, end1 );
        Project project2 = new Project( "LAB-IMPLEMENT", "Update Lab Results Reports", start2, end2 );
       
        // test all of the functions 
        project1.activateProject();
        System.out.println( "Project 1: \n" + project1.toString());
        System.out.println();
        project2.activateProject();
        project2.setProjectCounter(1001);
        System.out.println( "Project 2: \n" + project2.toString());
        System.out.println(); 
        System.out.println("****PROJECT 1****");
        System.out.println("Estimated days to completion:" + project1.estimatedDaysToCompletion());
        System.out.println();
        project1.pushProject(5);
        System.out.println("5 days late:" + "\n" + project1.toString());
        project1.pushProject(0);
        System.out.println();
        project1.pushProject(50);
        System.out.println("50 days late:" + "\n" + project1.toString());
        System.out.println();
        project1.deactivateProject( "2023-10-15");
        System.out.println("Deactivated: " + "\n" + project1.toString());
        System.out.println();
        project1.activateProject();
        System.out.println("Activated: " + "\n" + project1.toString());
        System.out.println();
        System.out.println("Does the second project end before the first one? \n" + end1.isBefore(end2));
        
    }
}

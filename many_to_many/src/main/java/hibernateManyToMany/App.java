package hibernateManyToMany;

public class App {
    public static void main(String[] args) {
        // Create Courses
        Course c1 = new Course();
        c1.setCname("Java");

        Course c2 = new Course();
        c2.setCname("Python");

        Course c3 = new Course();
        c3.setCname("Database Management");

        // Create Students
        Student s1 = new Student();
        s1.setSname("Hema");

        Student s2 = new Student();
        s2.setSname("Mahitha");

        // Establish relationships
        s1.getCourses().add(c1);
        s1.getCourses().add(c2);

        s2.getCourses().add(c2);
        s2.getCourses().add(c3);

        // (optional) set reverse side
        c1.getStudents().add(s1);
        c2.getStudents().add(s1);
        c2.getStudents().add(s2);
        c3.getStudents().add(s2);

        // Hibernate logic
        HibernateManager hbm = new HibernateManager();
        hbm.insertStudent(s1);
        hbm.insertStudent(s2);
        hbm.close();
    }
}

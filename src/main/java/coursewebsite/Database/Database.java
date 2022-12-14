package coursewebsite.Database;

import coursewebsite.models.Student;
import coursewebsite.models.Course;
import coursewebsite.models.Teacher;

import java.util.ArrayList;

public class Database {
    
    private static Database instance = null ;
    private static ArrayList<Course> courses = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Teacher> teachers = new ArrayList<>();
    
    private Database(){
        //students = new ArrayList<Student>();
        students.add(new Student("s1", "mohamed","student d1", "s1@", "123"));
        students.add(new Student("s2", "Ismael","student 2", "s2@", "123"));

        //teachers = new ArrayList<Teacher>();
        teachers.add(new Teacher("t1", "Vlachos","teacher 1", "t1@", "123"));
        Teacher t2 = new Teacher("t2", "Estier","teacher 2", "t2@", "123");
        teachers.add(t2);
        Teacher t3 = new Teacher("t3", "DaBoss", "teacher 3", "t3@", "123");
        teachers.add(t3);

        //courses = new ArrayList<Course>();
        courses.add(new Course("Python",t3, 50));
        courses.add(new Course("Java", t2, 100));

    }

    public static Database getInstance(){
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public void addCourseInApp(Course course){
        courses.add(course);}

    public void addAStudent(Student student){
        students.add(student);
    }
    public void addATeacher(Teacher teacher){
        teachers.add(teacher);
    }

    public void removeStudent(Student s) {
        for(Course c : s.getUserCourses()){
            c.getEnrolledStudents().remove(s);
        }
        students.remove(s);
    }
    
    public void removeTeacher(Teacher t) {
        for(Course c : t.getUserCourses()){
            for(Student s : c.getEnrolledStudents()){
                s.getUserCourses().remove(c);
            }
        teachers.remove(t);
        }
    }
        
    public void deleteCourse(Course c){
        this.courses.remove(c);
    }
    public void removeCourseFromApp (Course course){
        courses.remove(course);
    }

    public ArrayList<Course> getCourses() {return courses;}

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public ArrayList<String> getAllTeachers(){
        ArrayList<String> teachersList = new ArrayList<>();
        for (Teacher teacher:teachers) {
            teachersList.add(teacher.getFirstName() + ' ' + teacher.getLastName());
        }
        return teachersList;
    }

}


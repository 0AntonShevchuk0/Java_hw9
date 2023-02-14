import java.util.ArrayList;

/**
 * This class allows to make group of students
 */
public class Group {
    // Параметри групи
    private final String groupName;

    private final ArrayList<Student> members;

    /**
     * Constructor of group of students
     * @param groupName name or code of group
     */
    public Group(String groupName) {
        this.groupName = groupName;

        members = new ArrayList<>();
    }

    /**
     * This method adds a new student to the group
     * @param student Student to be added
     */
    public void addMember(Student student) {
        members.add(student);
        student.setGroup(groupName);
    }

    /**
     * This method takes exam for all students in the group
     * @param subject subject of exam
     * @throws Exception if students dont need to learn this subject
     */
    public void exam(Subject subject) throws Exception {
        for (Student member : members) {
            member.exam(subject);
        }
    }

    /**
     * This method checks marks for all students in the group and remove them, if they didnt passed
     */
    public void checkMarks() {
        members.removeIf(member -> !member.checkMarks());
    }

    /**
     * This method teaches a lesson for
     * @param subject subject of lesson
     * @param teacher teacher for lesson
     * @throws Exception if students dont need to learn this subject
     */
    public void study(Subject subject, Teacher teacher) throws Exception {
        for (Student member : members) {
            member.study(subject, teacher);
        }
    }

    /**
     * This method adds subject for each student
     * @param subject subject to be added
     */
    public void addSubject(Subject subject) {
        for (Student member : members) {
            member.addSubject(subject);
        }
    }

    /**
     * This method shows each student`s information
     */
    public void showStudents() {
        for (Student member : members) {
            System.out.println(member.toString());;
        }
    }
}

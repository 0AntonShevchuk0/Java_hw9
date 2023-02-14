import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * This class allows to make student with some data and behaviour
 */
public class Student {
    // Кількість студентів
    private static int studentsCount = 0;

    public static int getStudentsCount() {
        return studentsCount;
    }

    // Дані студента
    private final String name;
    private String group;
    private int semester;

    // Оцінки та знання про предметам
    private final HashMap<Subject, Integer> marks;
    private final HashMap<Subject, Integer> knowledge;

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getSemester() {
        return semester;
    }

    /**
     * Constructor of student
     * @param name name of student
     * @param semester semester from which the student starts studying
     */
    public Student(String name, int semester) {
        studentsCount++;

        this.name = name;
        this.semester = semester;

        marks = new HashMap<>();
        knowledge = new HashMap<>();
    }

    /**
     * This method makes string from object`s data
     * @return string which contains object state
     */
    @Override
    public String toString() {
        // Будуємо рядок по шматкам
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\nName: ").append(name)
                .append("\nGroup: ").append(group)
                .append("\nCourse: ").append(semester)
                .append("\nMarks: ");

        marks.forEach((key, value) -> {
            stringBuilder.append("\n").append(key).append(": ").append(value);
        });

        return stringBuilder.toString();
    }

    /**
     * This method increases student`s knowledge of subject
     * @param subject lesson subject
     * @param teacher lesson teacher
     * @throws Exception when student doesnt need to learn this subject
     */
    public void study(Subject subject, Teacher teacher) throws Exception {
        if (!knowledge.containsKey(subject)) {
            throw new Exception("Wrong subject.");
        }

        // Додаємо знання з предмета, але не більше ніж 100
        int newKnowledge = knowledge.get(subject) + teacher.Lesson(subject);
        if (newKnowledge > 100) {
            newKnowledge = 100;
        }
        knowledge.put(subject, newKnowledge);
    }

    /**
     * This method takes an exam for student and rate him
     * @param subject subject of exam
     * @throws Exception if student doesnt need to learn this subject
     */
    public void exam(Subject subject) throws Exception {
        if (!marks.containsKey(subject)) {
            throw new Exception("Wrong subject.");
        }

        // З певною випадковістю визначаємо оцінку
        Random random = new Random();

        marks.put(subject, (random.nextInt(101 - knowledge.get(subject)) + knowledge.get(subject)));
    }

    /**
     * This method adds subject which student need to learn
     * @param subject subject which student need to learn
     */
    public void addSubject(Subject subject) {
        // Заповнюємо словники пустими значеннями
        marks.put(subject, 0);
        knowledge.put(subject, 0);
    }

    /**
     * This method compare all student`s marks with 60
     * @return are all marks > 60 or not
     */
    public boolean checkMarks() {
        // Проходимо по елементам словника
        for (Map.Entry<Subject, Integer> mark : marks.entrySet()) {
            if (mark.getValue() < 60) {
                System.out.println("Student " + name + " didnt pass " + mark.getKey() + " with mark:" + mark.getValue());
                kickOut();
                return false;
            }
        }
        System.out.println("Student " + name + " passed all exams");
        newSemester();
        return true;
    }

    /**
     * This method transfers the student to a new semester
     */
    public void newSemester() {
        marks.clear();
        semester++;
    }

    /**
     * This method kicks out the student
     */
    private void kickOut() {
        studentsCount--;
    }
}

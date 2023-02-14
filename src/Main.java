import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

/**
 * The program to model KPI students and teachers
 * @author TI-92 Anton Shevchuk
 * @version 1.0
 */
public class Main {
    // Кількість занять
    private static final int NUMBER_OF_LESSONS = 4;

    // Початок програми
    public static void main(String[] args) throws IOException {
        System.out.println("KPI\n");

        // Створення об'єктів студентів
        Student student1 = new Student("S1", 1);
        Student student2 = new Student("S2", 1);
        Student student3 = new Student("S3", 1);
        Student student4 = new Student("S4", 1);
        Student student5 = new Student("S5", 1);
        Student student6 = new Student("S6", 1);
        Student student7 = new Student("S7", 1);
        Student student8 = new Student("S8", 1);

        // Створення об'єктів груп
        Group group1 = new Group("G1");
        group1.addMember(student1);
        group1.addMember(student2);
        group1.addMember(student3);
        group1.addMember(student4);
        group1.addSubject(Subject.English);
        group1.addSubject(Subject.Programming);
        group1.addSubject(Subject.Databases);
        group1.addSubject(Subject.WEB);

        Group group2 = new Group("G2");
        group2.addMember(student5);
        group2.addMember(student6);
        group2.addMember(student7);
        group2.addMember(student8);
        group2.addSubject(Subject.English);
        group2.addSubject(Subject.Programming);
        group2.addSubject(Subject.Algorithms);
        group2.addSubject(Subject.Math);

        // Створення об'єктів викладачів
        HashMap<Subject, Integer> knowledgePerLesson1 = new HashMap<>();
        knowledgePerLesson1.put(Subject.Programming, 16);
        knowledgePerLesson1.put(Subject.English, 18);
        knowledgePerLesson1.put(Subject.Algorithms, 16);
        Teacher teacher1 = new Teacher("T1", knowledgePerLesson1);

        HashMap<Subject, Integer> knowledgePerLesson2 = new HashMap<>();
        knowledgePerLesson2.put(Subject.Math, 10);
        knowledgePerLesson2.put(Subject.Databases, 14);
        knowledgePerLesson2.put(Subject.Programming, 14);
        Teacher teacher2 = new Teacher("T2", knowledgePerLesson2);

        HashMap<Subject, Integer> knowledgePerLesson3 = new HashMap<>();
        knowledgePerLesson3.put(Subject.WEB, 18);
        knowledgePerLesson3.put(Subject.English, 16);
        knowledgePerLesson3.put(Subject.Algorithms, 20);
        Teacher teacher3 = new Teacher("T3", knowledgePerLesson3);

        // Показ студентів
        System.out.println("Students count: " + Student.getStudentsCount() + "\n");
        group1.showStudents();
        group2.showStudents();

        // Блок, де може статись помилка
        try {
            // Навчання студентів
            for (int i = 0; i < NUMBER_OF_LESSONS; i++) {
                group1.study(Subject.English, teacher1);
                group1.study(Subject.Programming, teacher1);
                group1.study(Subject.Databases, teacher2);
                group1.study(Subject.WEB, teacher3);

                group2.study(Subject.English, teacher3);
                group2.study(Subject.Programming, teacher2);
                group2.study(Subject.Algorithms, teacher1);
                group2.study(Subject.Math, teacher2);
            }

            // Екзамени
            group1.exam(Subject.English);
            group1.exam(Subject.Programming);
            group1.exam(Subject.Databases);
            group1.exam(Subject.WEB);

            group2.exam(Subject.English);
            group2.exam(Subject.Programming);
            group2.exam(Subject.Algorithms);
            group2.exam(Subject.Math);

            group1.showStudents();
            group2.showStudents();

            // Перевірка результатів екзаменів
            group1.checkMarks();
            group2.checkMarks();
        }
        // Блок обробки помилок
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

        // Студенти, що залишились
        System.out.println("Students count: " + Student.getStudentsCount() + "\n");
        group1.showStudents();
        group2.showStudents();
    }
}


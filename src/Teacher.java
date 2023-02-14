import java.util.HashMap;

/**
 * This class allows to make teachers with their data and behaviour
 */
public class Teacher {
    // Дані викладача
    private final String name;

    private final HashMap<Subject, Integer> knowledgePerLesson;

    /**
     * Constructor of teacher
     * @param name name of teacher
     * @param knowledgePerLesson how much knowledge this teacher can give during 1 lesson
     */
    public Teacher(String name, HashMap<Subject, Integer> knowledgePerLesson) {
        this.name = name;
        this.knowledgePerLesson = knowledgePerLesson;
    }

    /**
     * This method makes string from object`s data
     * @return string which contains object state
     */
    @Override
    public String toString() {
        return "\nName: " + name;
    }

    /**
     * This method retrieves teacher performance data for one lesson in a given subject
     * @param subject Subject of lesson
     * @return number of knowledge
     * @throws Exception if teacher doesnt know the subject
     */
    public int Lesson(Subject subject) throws Exception {
        // Перевіряємо, чи є у словнику ключ
        if (!knowledgePerLesson.containsKey(subject)) {
            throw new Exception("Wrong subject.");
        }

        return knowledgePerLesson.get(subject);
    }
}

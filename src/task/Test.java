package task;// Please, do not use internet or any other sources of information during the test
// tast shouldn’t take more than 30 minutes
// There are 3 classes: Student, Subject and Mark
// - Fill the data according to the following conditions (use lists)
// 1. It is known that there are such students in the group: Valery Popov, Semyon Korzhev, Peter Ivanov, Maria Semenova and Kolya Nesterenko
// 2. Mathematics, Physics, Astronomy, History and Ethics are learned by this group and all subjects are mandatory excluding Ethics. It is optional.
// 3. Fill the data about marks if it is known that students have mark 3 for mandatory subjects and Maria has mark 5 for History and Ethics.
// 4. Please print results in a such way:
//   Popova Valeria Mathematics-1 Physics-2 Astronomy-0 History-1 Ethics-3 (do not display the subject info if there is no data about it)

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        // 1
        //Valery Popov, Semyon Korzhev, Peter Ivanov, Maria Semenova and Kolya Nesterenko

        ArrayList<Student> students = new ArrayList<Student>();
        students.add(new Student("Valery","Popov"));
        students.add(new Student("Semyon","Korzhev"));
        students.add(new Student("Peter","Ivanov"));
        students.add(new Student("Maria","Semenova"));
        students.add(new Student("Kolya","Nesterenko"));

        // 2
        //Mathematics, Physics, Astronomy, History and Ethics
        ArrayList<Subject> subjects = new ArrayList<Subject>();
        subjects.add(new Subject("Mathematics",true));
        subjects.add(new Subject("Physics",true));
        subjects.add(new Subject("Astronomy",true));
        subjects.add(new Subject("History",true));
        subjects.add(new Subject("Ethics",false));

        // 3
        //history - 5, ethics - 5
        ArrayList<Mark> marks = new ArrayList<Mark>();
        for (int i = 0; i < students.size(); i++){
            for (int j = 0; j < subjects.size()-1; j++){
                if ((i == 3 && j == 3)) {
                    marks.add(new Mark(students.get(i), subjects.get(j), 5));
                    marks.add(new Mark(students.get(i), subjects.get(j+1), 5));
                }

                else {
                    marks.add(new Mark(students.get(i), subjects.get(j), 3));
                }
            }
        }

        // 4
        //pront results
        //Popova Valeria Mathematics-1 Physics-2 Astronomy-0 History-1 Ethics-3
        // do not display the subject info if there is no data about it)

        //for test - remove several marks from marks(list)
        /*
        marks.remove(0);
        marks.remove(1);
        marks.remove(1);
        marks.remove(marks.size()-1);
        marks.remove(marks.size()-1);
        */

        for (int i = 0; i < students.size(); i++){
            System.out.print(students.get(i).getFirstName() + " " + students.get(i).getLastName() + " ");

            for (int j = 0; j < marks.size(); j++){
                if (students.get(i).getFirstName() == marks.get(j).getStudent().getFirstName()){
                    System.out.print(marks.get(j).getSubject().getName() + "-");
                    System.out.print(marks.get(j).getRank() + " ");
                }
            }
            System.out.println();
        }
    }

}

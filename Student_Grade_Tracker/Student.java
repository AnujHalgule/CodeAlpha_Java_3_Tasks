package grade_tracker;

public class Student {

    int id;
    String name;
    double[] marks;

    Student(int id, String name, double[] marks) {
        this.id = id;                                                  
        this.name = name;
        this.marks = marks;
    }

    double getAverage() {
        double total = 0;                                                 

        for (int i = 0; i < marks.length; i++) {
            total = total + marks[i];
        }

        return total / marks.length;
    }

    double getHighest() {
        double highest = marks[0];

        for (int i = 1; i < marks.length; i++) {
            if (marks[i] > highest) {
                highest = marks[i];
            }
        }

        return highest;
    }

    double getLowest() {
        double lowest = marks[0];

        for (int i = 1; i < marks.length; i++) {
            if (marks[i] < lowest) {
                lowest = marks[i];
            }
        }

        return lowest;
    }

    String getGrade() {
        double average = getAverage();

        if (average >= 90) {
            return "A+";
        } else if (average >= 80) {
            return "A";
        } else if (average >= 70) {
            return "B";
        } else if (average >= 60) {
            return "C";
        } else if (average >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}
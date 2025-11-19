import java.io.*;
import java.util.*;

public class StudentRecordSystemmmm {
    static class Student {
        private int rollNo;
        private String name;
        private String email;
        private String course;
        private double marks;

        public Student(int rollNo, String name, String email, String course, double marks) {
            this.rollNo = rollNo;
            this.name = name;
            this.email = email;
            this.course = course;
            this.marks = marks;
        }

        public int getRollNo() { return rollNo; }
        public String getName() { return name; }
        public String getEmail() { return email; }
        public String getCourse() { return course; }
        public double getMarks() { return marks; }

        @Override
        public String toString() {
            return "Roll No: " + rollNo + "\nName: " + name + "\nEmail: " + email +
                    "\nCourse: " + course + "\nMarks: " + marks + "\n";
        }
    }
    static class FileUtil {
        public static List<Student> readFromFile(String filename) {
            List<Student> students = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data.length == 5) {
                        int roll = Integer.parseInt(data[0]);
                        String name = data[1];
                        String email = data[2];
                        String course = data[3];
                        double marks = Double.parseDouble(data[4]);
                        students.add(new Student(roll, name, email, course, marks));
                    }
                }
            } catch (IOException e) {
                System.out.println("File not found or unable to read.");
            }
            return students;
        }
        public static void writeToFile(String filename, List<Student> students) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
                for (Student s : students) {
                    bw.write(s.getRollNo() + "," + s.getName() + "," + s.getEmail() + "," +
                            s.getCourse() + "," + s.getMarks());
                    bw.newLine();
                }
            } catch (IOException e) {
                System.out.println("Error writing to file.");
            }
        }
        public static void randomAccessRead(String filename) {
            try (RandomAccessFile raf = new RandomAccessFile(filename, "r")) {
                System.out.println("\n--- RandomAccessFile Demo ---");
                raf.seek(0);
                String firstLine = raf.readLine();
                System.out.println("First Record (Random Read): " + firstLine);
            } catch (IOException e) {
                System.out.println("Error using RandomAccessFile.");
            }
        }
        public static void showFileAttributes(String filename) {
            File file = new File(filename);
            if (file.exists()) {
                System.out.println("\n=== File Attributes ===");
                System.out.println("File Name: " + file.getName());
                System.out.println("Path: " + file.getAbsolutePath());
                System.out.println("Readable: " + file.canRead());
                System.out.println("Writable: " + file.canWrite());
                System.out.println("File Size: " + file.length() + " bytes");
            }
        }
    }
    static class StudentManager {
        private List<Student> students;

        public StudentManager(List<Student> students) {
            this.students = students;
        }

        public void addStudent(Student s) {
            students.add(s);
        }

        public void viewAll() {
            System.out.println("\n--- All Students ---");
            Iterator<Student> it = students.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        }

        public void searchByName(String name) {
            for (Student s : students) {
                if (s.getName().equalsIgnoreCase(name)) {
                    System.out.println("\nStudent Found:\n" + s);
                    return;
                }
            }
            System.out.println("No student found with name: " + name);
        }

        public void deleteByName(String name) {
            Iterator<Student> it = students.iterator();
            while (it.hasNext()) {
                if (it.next().getName().equalsIgnoreCase(name)) {
                    it.remove();
                    System.out.println("Student deleted successfully!");
                    return;
                }
            }
            System.out.println("No student found to delete with name: " + name);
        }

        public void sortByMarks() {
            students.sort(Comparator.comparingDouble(Student::getMarks).reversed());
            System.out.println("\n--- Students Sorted by Marks ---");
            viewAll();
        }

        public void sortByName() {
            students.sort(Comparator.comparing(Student::getName));
            System.out.println("\n--- Students Sorted by Name ---");
            viewAll();
        }

        public List<Student> getStudents() {
            return students;
        }
    }
    public static void main(String[] args) {
        String filename = "students.txt";
        List<Student> list = FileUtil.readFromFile(filename);
        System.out.println("Loaded students from file:");
        for (Student s : list) {
            System.out.println(s);
        }

        FileUtil.showFileAttributes(filename);
        FileUtil.randomAccessRead(filename);

        StudentManager manager = new StudentManager(list);
        Scanner sc = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\n===== Capstone Student Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search by Name");
            System.out.println("4. Delete by Name");
            System.out.println("5. Sort by Marks");
            System.out.println("6. Sort by Name");
            System.out.println("7. Save and Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    manager.addStudent(new Student(roll, name, email, course, marks));
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    manager.viewAll();
                    break;

                case 3:
                    System.out.print("Enter Name to Search: ");
                    String sname = sc.nextLine();
                    manager.searchByName(sname);
                    break;

                case 4:
                    System.out.print("Enter Name to Delete: ");
                    String dname = sc.nextLine();
                    manager.deleteByName(dname);
                    break;

                case 5:
                    manager.sortByMarks();
                    break;

                case 6:
                    manager.sortByName();
                    break;

                case 7:
                    FileUtil.writeToFile(filename, manager.getStudents());
                    System.out.println("Records saved successfully! Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 7);

        sc.close();
    }
}

# VanshTanwar_Java_labAssignment-4
#  Student Record Management System (Java)

# Project Overview

This project implements a **Student Record Management System** in Java using **File Handling** and the **Java Collections Framework**.
It provides persistent storage of student records (`students.txt`) and allows operations such as adding, viewing, searching, deleting, and sorting students.
The system uses:

* `ArrayList` to store records
* `Comparator` and `Iterator` for sorting and traversal
* `BufferedReader`, `BufferedWriter`, and `RandomAccessFile` for file operations

---

# **Objectives**

* Implement file handling to store and retrieve student data.
* Use Java Collections API to manage records efficiently.
* Perform sorting and searching using Comparator and Iterator.
* Demonstrate persistent storage with read/write operations.
* Use `File` class to show file attributes and `RandomAccessFile` for random reads.

---

# **Features**

✅ Load student records from file at startup
✅ Add new student details
✅ View all student records
✅ Search student by name
✅ Delete student by name
✅ Sort records by marks or name using `Comparator`
✅ Display using `Iterator`
✅ Save updated records to file on exit
✅ Display file attributes (name, path, size, permissions)
✅ Read a record randomly using `RandomAccessFile`

---

# **Class Design**

All classes are implemented inside one file `StudentRecordSystem.java`.

| Class                          | Description                                                                   |
| ------------------------------ | ----------------------------------------------------------------------------- |
| **Student**                    | Represents a student entity with roll number, name, email, course, and marks. |
| **FileUtil**                   | Handles reading, writing, random access, and file attributes.                 |
| **StudentManager**             | Performs all operations like add, view, search, delete, and sort.             |
| **Main (StudentRecordSystem)** | Contains the main method and menu-driven interface.                           |

---

# **File Used**

**`students.txt`** — stores student records in CSV format.
Example content:

```
101,Ankit,ankit@mail.com,B.Tech,85.5
102,Riya,riya@mail.com,M.Tech,91.0
```

---

# **Technologies Used**

* **Language:** Java
* **Concepts Used:**

  * File Handling (`BufferedReader`, `BufferedWriter`, `RandomAccessFile`)
  * Collections (`ArrayList`)
  * Sorting (`Comparator`, `Comparable`)
  * Iterators
  * Exception Handling
  * OOP (Encapsulation, Classes, Methods)

---

#  **Menu Options**

| Option | Description       |
| ------ | ----------------- |
| 1      | Add Student       |
| 2      | View All Students |
| 3      | Search by Name    |
| 4      | Delete by Name    |
| 5      | Sort by Marks     |
| 6      | Sort by Name      |
| 7      | Save and Exit     |

---

# **How to Run**

### **Step 1:** Save all files

Create `StudentRecordSystem.java` and `students.txt` in the same directory.

# **Step 2:** Compile

```bash
javac StudentRecordSystem.java
```

# **Step 3:** Run

```bash
java StudentRecordSystem
```

# **Step 4:** Use Menu

Add, view, delete, search, sort, and save student records easily.

---

# **Sample Output**

```
Loaded students from file:
Roll No: 101
Name: Ankit
Email: ankit@mail.com
Course: B.Tech
Marks: 85.5

Roll No: 102
Name: Riya
Email: riya@mail.com
Course: M.Tech
Marks: 91.0

===== Capstone Student Menu =====
1. Add Student
2. View All Students
3. Search by Name
4. Delete by Name
5. Sort by Marks
6. Sort by Name
7. Save and Exit
Enter choice: 1
Enter Roll No: 103
Enter Name: Karan
Enter Email: karan@mail.com
Enter Course: BCA
Enter Marks: 76.2
Student added successfully!
```

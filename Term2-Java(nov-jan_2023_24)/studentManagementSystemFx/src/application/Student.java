package application;

/**
 * Student: with private instance variables for storing
 * student information such as name, ID, age, and grade.
 */
class Student{
    private String name;
    private int ID;
    private int age;
    private float grade;

    // initializing the variables
    public Student(String _name, int _ID, int _age, float _grade) {
        this.name = _name;
        this.ID = _ID;
        this.age = _age;
        this.grade = _grade;
    }

    // update new Id
    public void setId(int id){
        this.ID = id;
    }

    // update new name
    public void setName(String name){
        this.name = name;
    }

    // update new age
    public void setAge(int age){
        this.age = age;
    }

    // update new grade
    public void setGrade(float grade){
        this.grade = grade;
    }

    // return id demanded
    public Integer returnId(){
        return this.ID;
    }

    // return name demanded
    public String returnName(){
        return this.name;
    }

    // return age demanded
    public Integer returnAge(){
        return this.age;
    }

    // return grade demanded
    public Float returnGrade(){
        return this.grade;
    }
}

package app;

public class CourseGrade {
    private Courses _course;
    private float _grade;

    public CourseGrade(Courses course, float grade){
        this._course = course;
        this._grade =  grade;
    }

    //getters
    public float grad(){return _grade;}
    public Courses cour(){return _course;}
}

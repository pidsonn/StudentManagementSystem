package pms.student;




public class Student {
      //declare variables
  private String name;
  private String grade;
  private int id;
  private int age;
  
  
    
        //Default constructors
    public Student(){}

        //Constructors with parameters
    public Student( int id, String name,int age, String grade)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
            //Getters and Setters.
        public int getId()
        {
            return id;
        }
        public void setId(int id)
        {
            this.id = id;
        }
        public String getName()
        {
            return name;
        }
        public void setName(String name)
        {
            this.name = name;
        }
        public String getGrade()
        {
            return grade;
        }
        public void setGrade(String grade){
            this.grade = grade;
        }
        public int getAge()
        {
            return age;
        }   
        public void setAge(int age)
        {
            this.age = age;
        }
        @Override
        public String toString()
        {
            return "ID:" + id + ", Name:" + name + ",Age:" + age + ",Grade:" + grade;
        }

       
        
        

} 
    


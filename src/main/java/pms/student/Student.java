package pms.student;




public class Student {
      //declare variables
  private int id;
  private String name;
  private int age;
  private String grade;
  
  
  
    
        //Default constructor
    public Student(){
        this.id = 0;      //default id
        this.name = "";   // default name
        this.age = 0;     //default age
        this.grade = "";  //default grade
    }

        //Constructor with parameters
    public Student(int id, String name, int age, String grade)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
            //Getters and Setters and validations
        public int getId(){
            return id;
        }
        public void setId(int id){
        if(id<=0){
            throw new IllegalArgumentException("ID must be greater than 0.");
        }

            this.id = id;
        }
        public String getName()
        {
            return name;
        }
        public void setName(String name){
          if(name == null || name.trim().isEmpty()){ 
            throw new IllegalArgumentException("The name can't be null or empty.");
        }       
            this.name = name;
        }
        public String getGrade()
        {
            return grade;
        }
        public void setGrade(String grade){
            if(grade == null || grade.trim().isEmpty()){
                throw new IllegalArgumentException("The grade can't be null or empty");
            }
            this.grade = grade;
        }
        public int getAge()
        {
            return age;
        }   
        public void setAge(int age){
            if(age<=0 ){
                throw new IllegalArgumentException("The age can't be zero");
            }
           this.age = age;
        }
        @Override
        public String toString()
        {
            return "ID:" + id + ", Name:" + name + ",Age:" + age + ",Grade:" + grade;
        }

        
        

} 
    


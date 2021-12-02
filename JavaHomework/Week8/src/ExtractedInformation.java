public class ExtractedInformation {
    String firstName, kidFirstName;
    String lastName, kidLastName;
    String address, phone;
    String positionInSociety;
    String gender;
    int age, kidAge;
    int salary, pension;
    boolean kid = false, hasSalary = false, hasPension = false;



    public void setPositionInSociety(String positionInSociety) {
        this.positionInSociety = positionInSociety;
    }

    public void setKidFirstName(String kidFirstName) {
        this.kidFirstName = kidFirstName;
    }

    public void setKidLastName(String kidLastName) {
        this.kidLastName = kidLastName;
    }

    public void setKidAge(int kidAge) {
        this.kidAge = kidAge;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setPension(int pension) {
        this.pension = pension;
    }

    public void getAll(){
        System.out.print( "First name: " + firstName +
                            " | Last name: " + lastName +
                            " | Age: " + age +
                            " | Address: " + address +
                            " | Position in society: " + positionInSociety +
                            " | Gender: " + gender);
        if(hasSalary) System.out.print(" | Salary: " + salary);
        if(hasPension) System.out.print(" | Pension: " + pension);
        if(kid) System.out.print(   " | Kid first name: " + kidFirstName +
                                    " | Kid last name: " + kidLastName +
                                    " | Kid age: " + kidAge);
    }

    public int getSalary() {
        return salary;
    }

    public int getPension() {
        return pension;
    }

    public String getPhone() {
        return phone;
    }

    public String getKidFirstName() {
        return kidFirstName;
    }

    public String getKidLastName() {
        return kidLastName;
    }

    public int getKidAge() {
        return kidAge;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getPositionInSociety() {
        return positionInSociety;
    }
}

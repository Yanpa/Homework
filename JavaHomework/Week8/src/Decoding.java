import static java.lang.Integer.parseInt;

public class Decoding {

    ExtractedInformation exInfForP1 = new ExtractedInformation();
    ExtractedInformation exInfForP2 = new ExtractedInformation();
    ExtractedInformation exInfForP3 = new ExtractedInformation();

    public Decoding(String[] arrayWithInformation){
        dividingTheInformationIntoPieces(arrayWithInformation);
        if(areTheValuesValid(exInfForP1.getFirstName(), exInfForP1.getLastName(), exInfForP1.getAddress(),
                exInfForP1.getAge(), exInfForP1.getKidAge())
                && areTheValuesValid(exInfForP2.getFirstName(), exInfForP2.getLastName(), exInfForP2.getAddress(),
                exInfForP2.getAge(), exInfForP2.getKidAge())
                && areTheValuesValid(exInfForP3.getFirstName(), exInfForP3.getLastName(), exInfForP3.getAddress(),
                exInfForP3.getAge(), exInfForP3.getKidAge())){
            System.out.println("The values are valid");
        }
        else System.out.println("The values are NOT valid, you can still work, but the results will be wrong");
    }

    private void dividingTheInformationIntoPieces(String[] array){
        String singularPieceOfInformation = array[0];
        cuttingTheInformation(singularPieceOfInformation, exInfForP1);

        singularPieceOfInformation = array[1];
        cuttingTheInformation(singularPieceOfInformation, exInfForP2);

        singularPieceOfInformation = array[2];
        cuttingTheInformation(singularPieceOfInformation, exInfForP3);
    }


    /**
     * Програма която приема като параметри класът ExtractedInformation и все още ненарязана информация.
     * Реже информацията на парчета и ги разпределя в класа ExInf.
     * @param cut
     * @param exInf
     */
    private void cuttingTheInformation(String cut, ExtractedInformation exInf){
        String[] informationParts = cut.split("@");

        int age, salary, pension, kidAge;
        String firstName, lastName, sex, address, phone, kidFirstName, kidLastName;

        for(int i = 0; i < informationParts.length; i++){
            if(informationParts[i].contains("{TYPE}=[")){
                String typeOfPerson = informationParts[i].substring(8, informationParts[i].length() - 1);
                exInf.setPositionInSociety(typeOfPerson);
            }
            if(informationParts[i].contains("{FNAME}=[")){
                firstName = informationParts[i].substring(9, informationParts[i].length() - 1);
                exInf.setFirstName(firstName);
            }
            if(informationParts[i].contains("{LNAME}=[")){
                lastName = informationParts[i].substring(9, informationParts[i].length() - 1);
                exInf.setLastName(lastName);
            }
            if(informationParts[i].contains("{AGE}=[")){
                age = parseInt(informationParts[i].substring(7, informationParts[i].length() - 1));
                exInf.setAge(age);
            }
            if(informationParts[i].contains("{SEX}=[")){
                sex = informationParts[i].substring(7, informationParts[i].length() - 1);
                exInf.setGender(sex);
            }
            if(informationParts[i].contains("{ADDRESS}=[")){
                address = informationParts[i].substring(11, informationParts[i].length() - 1);
                exInf.setAddress(address);
            }
            if(informationParts[i].contains("{PHONE}=[")){
                phone = informationParts[i].substring(9, informationParts[i].length() - 1);
                exInf.setPhone(phone);
            }
            if(informationParts[i].contains("{SPECIAL_PROPERTY}::{SALARY}=[")){
                salary = parseInt(informationParts[i].substring(30, informationParts[i].length() - 1));
                exInf.hasSalary = true;
                exInf.setSalary(salary);
            }
            if(informationParts[i].contains("{SPECIAL_PROPERTY}::{PENSION}=[")){
                pension = parseInt(informationParts[i].substring(31, informationParts[i].length() - 1));
                exInf.hasPension = true;
                exInf.setPension(pension);
            }
            if(informationParts[i].contains("{SPECIAL_PROPERTY}::{KID}=[{KFNAME}=[")){
                kidFirstName = informationParts[i].substring(37, informationParts[i].length() - 1);
                exInf.kid = true;
                exInf.setKidFirstName(kidFirstName);
            }
            if(informationParts[i].contains("{KLNAME}=[")){
                kidLastName = informationParts[i].substring(10, informationParts[i].length() - 1);
                exInf.setKidLastName(kidLastName);
            }
            if(informationParts[i].contains("{KAGE}=[")){
                kidAge = parseInt(informationParts[i].substring(8, informationParts[i].length() - 2));
                exInf.setKidAge(kidAge);
            }
        }
    }


    /**
     * Проверява дали данните са верни
     * @param firstName
     * @param lastName
     * @param address
     * @param age
     * @param kidAge
     * @return
     */
    private boolean areTheValuesValid(String firstName, String lastName, String address, int age, int kidAge){
        return firstName.charAt(0) >= 'A' && firstName.charAt(0) <= 'Z' &&
                lastName.charAt(0) >= 'A' && lastName.charAt(0) <= 'Z' &&
                address.charAt(0) >= 'A' && address.charAt(0) <= 'Z' &&
                age >= 0 && age <= 150 && kidAge >= 0 && kidAge <= 150;
    }
}

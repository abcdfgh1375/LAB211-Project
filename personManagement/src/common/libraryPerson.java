
package common;

import Model.Person;

/**
 *
 * @author THANH HUYEN
 */
public class libraryPerson {

    public Person[] sortBySalary(Person[] person) throws Exception {
        try{
            person = bubbleSort(person);
        }catch(Exception e){
            System.out.println("Can't Sort Person");
        }
        return person;
    }

    public Person[] bubbleSort(Person[] person) {
        for (int i = 0; i < person.length - 1; i++) {
            for (int j = 0; j < person.length - i - 1; j++) {
                if (person[j].getSalary() > person[j + 1].getSalary()) {
                    swap(person, j, j + 1);
                }
            }
        }
        return person;
    }

    public void swap(Person[] arr, int index1, int index2) {
        if (index1 >= 0 && index1 < arr.length && index2 >= 0 && index2 < arr.length) {
            Person temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;
        } else {
            System.out.println("Invalid indices");
        }
    }
}

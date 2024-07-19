package org.example;

import java.io.*;

public class TestSerialization {
    public static void main(String[] args) {

        ///////////-----Serialization-----//////////

        //Creating the object
        Customer customer1 = new Customer(1, "shyamantha");

        try {
            //Creating the stream
            FileOutputStream fileOutputStream = new FileOutputStream("customer.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            //Writing the object
            objectOutputStream.writeObject(customer1);

            fileOutputStream.close();
            objectOutputStream.close();

            System.out.println("Object has been serialized");

        } catch (IOException e) {
            e.printStackTrace();
        }

        ///////////-----Deserialization-----//////////

        try {

            // Reading the object from a file
            FileInputStream fileInputStream = new FileInputStream("customer.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            // Method for deserialization of object
            final Customer customer2 = (Customer) objectInputStream.readObject();

            fileInputStream.close();
            objectInputStream.close();

            System.out.println("Object has been deserialized ");
            System.out.println("deserialized customer = " + customer2);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
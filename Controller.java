package com.phonebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {

    List<PhoneBook> phoneBooks=new ArrayList<>();
    String name;
    String phone;
    Scanner scanner=new Scanner(System.in);
    public void menu(){


        try {
            while (true) {
                Menu.mainMenu();
                System.out.println("Enter choose:");
                int choose=scanner.nextInt();

                switch (choose) {
                    case 1:insert();
                        break;

                    case 2:
                        delete();

                        break;
                    case 3:
                        lookUp();
                        break;
                    case 4:
                        System.out.println("See you!");
                        System.exit(0);
                        break;
                    case 5:

                    default:
                        System.out.println("Invalid");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void insert(){
        boolean check=false;
        String newphone;
        try {int i=0;
            System.out.println("Enter name:");
            name=scanner.next();
            System.out.println("Enter phone:");
            newphone=scanner.next();
            while (!check){
                do {

                    if (phoneBooks.size()==0){
                        phoneBooks.add(new PhoneBook(name,newphone));
                        System.out.println(phoneBooks.get(phoneBooks.size()-1));
                        i++;
                        check=true;
                    }else if (name.equals(phoneBooks.get(i).getName())){
                        phoneBooks.add(new PhoneBook(name,newphone));
                        System.out.println(phoneBooks.get(phoneBooks.size()-1));
                        check=true;
                        Menu.mainMenu();
                        i++;
                    }else {
                        System.out.println("Name already exist");
                    }

                }while (i<phoneBooks.size());
            }

        } catch (RuntimeException e) {
            System.out.println(e.getMessage()+",Invalid");
        }
    }
    public  void delete() {
        boolean check = false;
        try {

            while (!check) {
                if (phoneBooks.size() == 0) {
                    System.out.println("Phone List Empty");
                    menu();
                } else {
                    System.out.println("Enter name:");
                    String findname = scanner.next();
                    for (int i = 0; i < phoneBooks.size(); i++) {

                        if (findname.equals(phoneBooks.get(i).getName())) {

                            Menu.accessDelete();
                            int ch = scanner.nextInt();
                            switch (ch) {
                                case 1:
                                    phoneBooks.remove(phoneBooks.contains(name));
                                    System.out.println("Delete succes");
                                    check = true;
                                    break;

                                case 2:
                                    System.out.println("No Success");
                                    delete();
                            }
                        } else {
                            System.out.println("Can not find name ");
                            check = true;
                        }
                    }
                }
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage()+",Invalid");
        }
    }

    public  void lookUp(){

        try {
            if (phoneBooks.size()==0){
                System.out.println("Phone Book Empty");
            } else {
                System.out.println("Enter name:");
                String findname=scanner.next();
                for (int i=0;i<= phoneBooks.size();i++){
                    if (findname.contains(phoneBooks.get(i).getName())){
                        System.out.println(phoneBooks.get(i).toString());
                    }else {
                        System.out.println("Can not find name");
                    }
                }
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage()+"Invalid");
        }
    }
}

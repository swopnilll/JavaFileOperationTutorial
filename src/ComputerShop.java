import java.io.*;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class ComputerShop {

    private List<Part> partsList;

    public ComputerShop() {

    this.partsList = new ArrayList<Part>();
    }

    public void loadPartsData(){
        File f1 = new File("src/parts.txt");

            try(Scanner dataReader = new Scanner(f1)){
                if(dataReader.hasNextInt()){
                    int numberOfRecords = dataReader.nextInt();
                    dataReader.nextLine();

                    for(int i = 0; i < numberOfRecords; i++){
                        Part part = new Part();

                        if(dataReader.hasNextLine()){
                            part.setName(dataReader.nextLine());

                            if(dataReader.hasNextLine()){
                                part.setDescription(dataReader.nextLine());

                                if(dataReader.hasNextLine()){
                                    part.setPrice(dataReader.nextDouble());
                                    dataReader.nextLine();

                                    part.setQuantityInStock(5);

                                    this.addPart(part);
                                }
                            }
                        }
                    }
                }
            } catch (FileNotFoundException fileNotFoundException){
                System.out.println("File not found: " + fileNotFoundException.getMessage());
                fileNotFoundException.printStackTrace();
            }

    }

    public void showParts(){
        this.partsList.forEach(part -> {
            System.out.println("Part Details");
            System.out.println("Name = " +part.getName());
            System.out.println("Description = " +part.getDescription());
            System.out.println("Price = " +part.getPrice());
            System.out.println("Quantity in Stock = " +part.getQuantityInStock());
            System.out.println("--------------");
        });
    }

    public void reportParts(){
        File newFile = new File("src/parts-report.txt");

        try (PrintWriter out = new PrintWriter(newFile)) {
            for (Part part : this.partsList) {
                out.println("Name: " + part.getName());
                out.println("Description: " + part.getDescription());
                out.println("Price: " + part.getPrice());
                out.println("Quantity: " +part.getQuantityInStock());
                out.println();  // Add a blank line between parts
            }
            System.out.println("Parts data written to " + newFile.getAbsolutePath());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }



    }

    public List<Part> getPartsList() {
        return partsList;
    }

    public void addPart(Part part){
        this.partsList.add(part);
    }
}

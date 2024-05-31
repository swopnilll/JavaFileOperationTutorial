import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ComputerShop computerShop = new ComputerShop();

        computerShop.loadPartsData();

        if (computerShop.getPartsList().isEmpty()) {
            System.out.println("No parts loaded from file. Exiting.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Menu:");
            System.out.println("1. Show all parts");
            System.out.println("2. Report parts to file");
            System.out.println("3. Sell a part");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    computerShop.showParts();
                    break;
                case 2:
                    computerShop.reportParts();
                    break;
                case 3:
                    sellPart(computerShop, scanner);
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void sellPart(ComputerShop computerShop, Scanner scanner) {
        // Show all parts
        computerShop.showParts();

        // Ask user to select a part by entering its index
        System.out.print("Enter the part number to sell: ");
        int partIndex = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        if (partIndex >= 0 && partIndex < computerShop.getPartsList().size()) {
            Part selectedPart = computerShop.getPartsList().get(partIndex);
            if (selectedPart.getQuantityInStock() > 0) {
                selectedPart.setQuantityInStock(selectedPart.getQuantityInStock() - 1);
                System.out.println("Sold 1 unit of " + selectedPart.getName() + ". Quantity left: " + selectedPart.getQuantityInStock());
            } else {
                System.out.println("Part " + selectedPart.getName() + " is out of stock.");
            }
        } else {
            System.out.println("Invalid part number. Please try again.");
        }
    }
}

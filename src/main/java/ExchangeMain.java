import java.util.Scanner;


public class ExchangeMain {
    public static void main(String[] args) {
        ExchangeRON exchangeRON = new ExchangeRON(2000, 0.20, 0.22);

        ExchangeEUR exchangeEUR = new ExchangeEUR(2000, 1.09, 4.97);
        ExchangeUSD exchangeUSD = new ExchangeUSD(2000, 0.92, 4.58);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.print("Pick an option by typing the number: \n" +
                    "1. Exchange\n" +
                    "2. Admin settings\n" +
                    "3. Exit\n");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    System.out.print("Choose the currency you want to exchange from:\n" +
                            "1. EUR\n" +
                            "2. USD\n" +
                            "3. RON\n");
                    int currencyFROM = Integer.parseInt(scanner.nextLine());
                    System.out.println("Choose the currency you want to exchange into:\n" +
                            "1. EUR\n" +
                            "2. USD\n" +
                            "3. RON\n");
                    int currencyINTO = Integer.parseInt(scanner.nextLine());
                    System.out.println("Insert the sum you want to exchange: ");
                    double sum = Double.parseDouble(scanner.nextLine());
                    double exchanged;
                    switch (currencyFROM) {
                        case 1:
                            if (currencyINTO == 2) {
                                exchanged = exchangeEUR.toUSD(sum);
                                exchangeUSD.setBalanceUSD(exchangeUSD.updateUSD(exchanged));
                                System.out.println("You have exchanged " + sum + " EUR into " + exchanged + " USD.");
                            } else if (currencyINTO == 3) {
                                exchanged = exchangeEUR.toRON(sum);
                                exchangeRON.setBalanceRON(exchangeRON.updateRON(exchanged));
                                System.out.println("You have exchanged " + sum + " EUR into " + exchanged + " RON.");
                            } else {
                                System.out.println("That is not a valid currency!");
                                System.exit(0);
                            }
                            break;
                        case 2:
                            if (currencyINTO == 1) {
                                exchanged = exchangeUSD.toEUR(sum);
                                exchangeEUR.setBalanceEUR(exchangeEUR.updateEUR(exchanged));
                                System.out.println("You have exchanged " + sum + " USD into " + exchanged + " EUR.");
                            } else if (currencyINTO == 3) {
                                exchanged = exchangeUSD.toRON(sum);
                                exchangeRON.setBalanceRON(exchangeRON.updateRON(exchanged));
                                System.out.println("You have exchanged " + sum + " USD into " + exchanged + " RON.");
                            } else {
                                System.out.println("That is not a valid currency!");
                                System.exit(0);
                            }
                            break;
                        case 3:
                            if (currencyINTO == 1) {
                                exchanged = exchangeRON.toEUR(sum);
                                exchangeEUR.setBalanceEUR(exchangeEUR.updateEUR(exchanged));
                                System.out.println("You have exchanged " + sum + " RON into " + exchanged + " EUR.");
                            } else if (currencyINTO == 2) {
                                exchanged = exchangeRON.toUSD(sum);
                                exchangeUSD.setBalanceUSD(exchangeUSD.updateUSD(exchanged));
                                System.out.println("You have exchanged " + sum + " RON into " + exchanged + " USD.");
                            } else {
                                System.out.println("That is not a valid currency!");
                                System.exit(0);
                            }
                            break;
                        default:
                            System.out.println("That is not a valid currency!");
                            break;
                    }
                    break;
                case 2:
                    System.out.print("Choose the currency you want to modify:\n" +
                            "1. EUR\n" +
                            "2. USD\n" +
                            "3. RON\n");
                    int adminCurrency = Integer.parseInt(scanner.nextLine());
                    int adminChoice;
                    switch (adminCurrency) {
                        case 1:
                            System.out.print("Choose the value you want to modify:\n" +
                                    "1. Modify balance\n" +
                                    "2. Modify exchange rate to USD\n" +
                                    "3. Modify exchange rate to RON\n");
                            adminChoice = Integer.parseInt(scanner.nextLine());
                            if (adminChoice == 1) {
                                System.out.println("The current EUR balance available is: " + exchangeEUR.getBalanceEUR());
                                System.out.println("Insert new balance: ");
                                double balance = Double.parseDouble(scanner.nextLine());
                                exchangeEUR.setBalanceEUR(balance);
                                System.out.println("Balance updated!");
                            } else if (adminChoice == 2) {
                                System.out.println("The current EUR exchange ratio into USD is: " + exchangeEUR.getUSD());
                                System.out.println("Insert new ratio: ");
                                double ratio = Double.parseDouble(scanner.nextLine());
                                exchangeEUR.setUSD(ratio);
                            } else if (adminChoice == 3) {
                                System.out.println("The current EUR exchange ratio into RON is: " + exchangeEUR.getRON());
                                System.out.println("Insert new ratio: ");
                                double ratio = Double.parseDouble(scanner.nextLine());
                                exchangeEUR.setRON(ratio);
                            }
                            break;
                        case 2:
                            System.out.print("Choose the value you want to modify:\n" +
                                    "1. Modify balance\n" +
                                    "2. Modify exchange rate to EUR\n" +
                                    "3. Modify exchange rate to RON\n");
                            adminChoice = Integer.parseInt(scanner.nextLine());
                            if (adminChoice == 1) {
                                System.out.println("The current USD balance available is: " + exchangeUSD.getBalanceUSD());
                                System.out.println("Insert new balance: ");
                                double balance = Double.parseDouble(scanner.nextLine());
                                exchangeUSD.setBalanceUSD(balance);
                                System.out.println("Balance updated!");
                            } else if (adminChoice == 2) {
                                System.out.println("The current USD exchange ratio into EUR is: " + exchangeUSD.getEUR());
                                System.out.println("Insert new ratio: ");
                                double ratio = Double.parseDouble(scanner.nextLine());
                                exchangeUSD.setEUR(ratio);
                            } else if (adminChoice == 3) {
                                System.out.println("The current USD exchange ratio into RON is: " + exchangeUSD.getRON());
                                System.out.println("Insert new ratio: ");
                                double ratio = Double.parseDouble(scanner.nextLine());
                                exchangeUSD.setRON(ratio);
                            }
                            break;
                        case 3:
                            System.out.print("Choose the value you want to modify:\n" +
                                    "1. Modify balance\n" +
                                    "2. Modify exchange rate to EUR\n" +
                                    "3. Modify exchange rate to USD\n");
                            adminChoice = Integer.parseInt(scanner.nextLine());
                            if (adminChoice == 1) {
                                System.out.println("The current RON balance available is: " + exchangeRON.getBalanceRON());
                                System.out.println("Insert new balance: ");
                                double balance = Double.parseDouble(scanner.nextLine());
                                exchangeRON.setBalanceRON(balance);
                                System.out.println("Balance updated!");
                            } else if (adminChoice == 2) {
                                System.out.println("The current RON exchange ratio into EUR is: " + exchangeRON.getEUR());
                                System.out.println("Insert new ratio: ");
                                double ratio = Double.parseDouble(scanner.nextLine());
                                exchangeRON.setEUR(ratio);
                            } else if (adminChoice == 3) {
                                System.out.println("The current RON exchange ratio into USD is: " + exchangeRON.getUSD());
                                System.out.println("Insert new ratio: ");
                                double ratio = Double.parseDouble(scanner.nextLine());
                                exchangeRON.setUSD(ratio);
                            }
                        default:
                            System.out.println("You did not select a valid option!");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Thank you for using our application!");
                    running = false;
                    System.exit(0);

            }
        }
    }

}



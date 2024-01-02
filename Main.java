import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    File file = new File("myFile.txt");
    try {
      if (!file.exists()) {
        file.createNewFile();
      }
      BufferedReader br = new BufferedReader(new FileReader(file));
      String line = br.readLine();
      if (line != null) {
        System.out.println("Existing text in the file: " + line);
      } else {
        System.out.println("The file is empty.");
      }
      br.close();

      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter a new line of text: ");
      String inputLine = scanner.nextLine();

      BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
      writer.write(inputLine);
      writer.close();

      System.out.println("The new text has been saved to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
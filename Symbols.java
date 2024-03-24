import java.io.*;
import java.util.Scanner;

public class Symbols {
	private FileInputStream InputFile;
	private FileOutputStream OutputFile;
	private String input, output;
	private static int LettersQuantity = 52;
	private int[] Symbols = new int[LettersQuantity];
	
    public Symbols() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя входного файла: ");
        input = scanner.nextLine();
        System.out.println("Введите имя выходного файла: ");
        output = scanner.nextLine();
        for (int i = 0; i < LettersQuantity; i++) {
        	Symbols[i] = 0;
        }
        read();
        write();
    }
    
    private void read() {
    	try {
    		InputFile = new FileInputStream(input);
    		int symbol;
    		while ((symbol = InputFile.read()) != -1) {
    			if (symbol >= 'A' && symbol <= 'Z') {
    				Symbols[symbol - 65]++;
    			}
    			else if (symbol >='a' && symbol <= 'z') {
    				Symbols[symbol - 71]++;
    			}
    		}
    		InputFile.close();
    	}
        catch (FileNotFoundException ex) {
            System.out.println("Файла не существует!");
        }
        catch (IOException ex) {
            System.out.println("Ошибка чтения файла!" );
        }
    }
    
    private void write() {
        try {
            OutputFile = new FileOutputStream(output, false);
            for(int i = 0; i < LettersQuantity; i++) {
            	if (Symbols[i] != 0) {
                	if (i < 26) {
                        OutputFile.write(((char)(i+65) + " : " + Symbols[i] + "\n").getBytes());
                	}
                	else {
                        OutputFile.write(((char)(i+71) + " : " + Symbols[i] + "\n").getBytes());
                	}
            	}
            }
            OutputFile.close();
        }
        catch (IOException ex) {
            System.out.println("Ошибка записи в файл!" );
        }

    }
}

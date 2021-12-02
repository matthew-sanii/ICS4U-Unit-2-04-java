/*
* This program solves
* the Tower of Hanoi riddle.
*
* @author  Matthew Sanii
* @version 1.0
* @since   2021-12-02
*/

import java.io.IOException;
import java.util.Scanner;

/**
* This is the TowerOfHanoi program.
*/
final class TowerOfHanoi {

    /**
    * Prevent instantiation
    * Throw an exception IllegalStateException.
    * if this ever is called
    *
    * @throws IllegalStateException
    *
    */
    private TowerOfHanoi() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * Function does the TowerOfHanoi game by itself.
    *
    * @param nOfDisks the number of disks
    * @param startPeg the start peg value
    * @param endPeg The end peg value
    */
    static void hanoi(final int nOfDisks, final int startPeg,
                             final int endPeg) {
        final int pegNumber = 6;
        final String pegVal = " to peg ";
        if (nOfDisks == 1) {
            System.out.println("Move disk 1 from peg " + startPeg + pegVal
                               + endPeg);
        }
        else {
            hanoi(nOfDisks - 1, startPeg, pegNumber - startPeg - endPeg);
            System.out.println("Move disk " + nOfDisks + " from peg "
                + startPeg + pegVal + endPeg);
            hanoi(nOfDisks - 1, pegNumber - startPeg - endPeg, endPeg);
        }
    }

    /**
    * The starting main() function.
    *
    * @param args Name of file containing a string of numbers
    * @throws IOException when error occurs
    */
    public static void main(final String[] args) {
        final int startPeg = 1;
        final int endPeg = 3;
        System.out.println("Tower of Hanoi");
        final Scanner userInput = new Scanner(System.in);
        System.out.print("\nHow many disks do you want?: ");
        final String usrInput = userInput.nextLine();
        try {
            final int nOfDisks = Integer.valueOf(usrInput);
            System.out.println();
            if (nOfDisks > 0) {
                hanoi(nOfDisks, startPeg, endPeg);
            }
            else {
                System.out.println("\nPlease enter a positive integer.");
            }
        }
        catch (NumberFormatException errorCode) {
            System.err.print("\nThis is not an integer.");
        }
    }
}

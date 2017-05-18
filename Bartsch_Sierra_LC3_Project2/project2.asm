.orig x3000
BEGIN LEA R0, PromptA          ;print out a string asking for a number
    PUTS                       ;
    GETC                       ;
    ADD R1, R0, #0             ;set the number entered to r1
    ADD R5, R1, 0              ;copy the number to r5
    LD R6, ASCIIOFF            ;load r6 with ASCIIOFF
    NOT R6, R6                 ;
    ADD R2, R2, #10            ;add 10 to r2 as a guessing counter
    ADD R1, R0, R6             ;
    NOT R1, R1                 ;
    ADD R1, R1, #1             ;make the number entered into a non ascii number
START LEA R0, PromptB          ;print out a stream asking for a guess
    PUTS                       ;
    GETC                       ;
    ADD R3, R0, 0              ;
    ADD R3, R6, R3             ;
    BRnzp DATA_VALIDATION      ;
DATA_VALIDATION  ADD R3, R3, 0 ;checks to see if the character entered is a number between 0-9
    BRn NOTVALID               ;add the number entered and the ascii offset, if its negative its not valid
    AND R4, R4, 0              ;
    ADD R4, R4, -9             ;add negative 9 to the number to see if its more than 9
    ADD R4, R3, R4             ;
    BRp NOTVALID               ;if the number is more than one its not valid
    BRnz HIGHORLOW             ;
NOTVALID  LEA R0, NOTAVALIDTHING; 
    PUTS                       ;print out a statement saying the number is not valid
    ADD R2, R2, #-1            ;takes away a guess 
    BRnzp START                ;
HIGHORLOW   ADD R4, R3, R1     ;
    BRp TooHigh                ;if its too high branch to toohigh
    BRn TooLow                 ;if its too low branch to toolow
    BRz Correct                ;if its correct branch to correct
TooHigh LEA R0, HIGHGUESS      ;
    PUTS                       ;tells the user their guess was too high and asks for another number
    AND R4, R4, 0              ;
    ADD R2, R2, -1             ;
    BRp START                  ;
    BRz TOOMANYGUESSES         ; if the user is out of guesses brach to toomanyguesses
TooLow LEA R0, LOWGUESS        ;
    PUTS                       ;tells the user their guess was too low and asks for another guess
    AND R4, R4, 0              ;
    ADD R2, R2, -1             ;
    BRp START                  ;
    BRz TOOMANYGUESSES         ;if the user is out of guesses branch to toomanyguesses
TOOMANYGUESSES LEA R0, OUTOFGUESSES;
    PUTS                       ;tell the user they are out of guesses and say that player one wins
    AND R0, R0, 0              ;
    ADD R0, R5, R0             ;
    OUT                        ;
    BRnzp END                  ;
Correct LEA R0, CORRECTGUESS   ;print out a string saying that player 2 has won
    PUTS                       ;
    LEA R0, NUMBEROFGUESSES    ;prints out a string saying the number of guesses it took
    PUTS                       ;
    AND R0, R0, 0              ;
    NOT R6, R6                 ;
    ADD R6, R6, 1              ;
    ADD R0, R2, R6             ;
    OUT                        ;
    NOT R6, R6                 ;
    ADD R6, R6, 1              ;
END LEA R0, STARTOVERQ         ;prints out a string asking if the players would like to play again
    PUTS                       ;
    AND R0, R0, 0              ;
    GETC                       ;
    ADD R0, R0, R6             ; 
    BRnz DONE                  ;if the user enters a 1 the game restarts if they enter a 0 the game ends
    BRp BEGIN                  ;
DONE HALT

ASCIIOFF            .FILL x002F 
PromptA             .stringz "Enter a # to be guessed"
PromptB             .stringz "\nPlease guess a number:"
NOTAVALIDTHING      .stringz "\nNot a valid input. Please try again."
OUTOFGUESSES        .stringz "\nOut of guesses Player 1 Wins. Correct Answer was "
LOWGUESS            .stringz "\nToo low, guess again!"
HIGHGUESS           .stringz "\nToo high, guess again!"
NUMBEROFGUESSES     .stringz "\n# of guesses left:  "
CORRECTGUESS        .stringz "\nYou guessed correctly! Player 2 Wins!"
STARTOVERQ          .stringz "\nStart over? 1 yes 0 no.\n"
.end

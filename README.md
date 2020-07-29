# Encryption-Decryption
Command-line project for making the ciphertext and encrypt the ciphertext. JetBrains Academy_Hiperskill.
To start a program you should write for example "java Main -mode enc -key 5 -data "Welcome to hyperskill!" in command-line.

##The program parses arguments from command-line:
-ul mode (enc - encryption or dec - decryption),
-ul key (integer number) to encrypt/decrypt messages,
-ul in to specify the full name of a file to read data,
-ul out to specify the full name of a file to write the result,
-ul data is a text or ciphertext to encrypt or decrypt.

Arguments may be in a different order.

##Note:
-ul If there is no -mode, the program work in enc mode.
-ul If there is no -key, the program considers that key = 0.
-ul If there is no -data, and there is no -in the program assume that the data is an empty string.
-ul If there is no -out argument, the program print data to the standard output.
-ul If there are both -data and -in arguments, program prefer -data over -in.
-ul If there is a non-standard situation (an input file does not exist or an argument doesn’t have a value), the program displays a message about the problem and stop successfully.

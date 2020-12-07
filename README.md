# Encryption-Decryption
Command-line project for making the ciphertext and encrypt the ciphertext. JetBrains Academy_Hiperskill.  
To start a program you should write for example "java Main -mode enc -key 5 -data "Welcome to hyperskill!" in command-line.  
The output will be: \jqhtrj%yt%m~ujwxpnqq&.

## The program parses arguments from command-line:
- alg (shift or unicode),
- mode (enc - encryption or dec - decryption),
- key (integer number) to encrypt/decrypt messages,
- in to specify the full name of a file to read data,
- out to specify the full name of a file to write the result,
- data is a text or ciphertext to encrypt or decrypt.

Arguments may be in any order.

## Note:
- If there is no -alg, the program work with shift algorithm.
- If there is no -mode, the program work in enc mode.
- If there is no -key, the program considers that key = 0.
- If there is no -data, and there is no -in the program assume that the data is an empty string.
- If there is no -out argument, the program print data to the standard output.
- If there are both -data and -in arguments, program prefer -data over -in.
- If there is a non-standard situation (an input file does not exist or an argument doesn’t have a value),  
  the program displays a message about the problem and stop successfully.

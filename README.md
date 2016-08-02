# Hill_Cipher
Hill cipher is a type of substitution cipher. In this type of cipher encoding process is actually done by dividing the plaintext into units and replacing those plaintext blocks with cipher text by using linear algebra. 
While decoding even the cipher text is divided into blocks and the conversion of cipher text blocks into plaintext is done by using same linear algebra.In this technique, each letter used in the process is mainly represented by using the number modulo 26. The matrix is used as a key for the actual encryption and decryption process. 

ENCRYPTION PROCESS:

In encryption process the given message is divided into blocks and these blocks are represented in the form of a vector(matrix )with numbers corresponding to letters in the blocks. The key matrix and the plaintext block matrix are multiplied. The resultant matrix modulo 26 is the actual required cipher text matrix, which is further converted in to a block of cipher text and replaced with the given plaintext block.
 C=PKmod26
where
C-Cipher text
P-Plaintext
 K-Key

DECRYPTION PROCESS:

In decryption process the cipher text obtained is turned back into a vector(matrix) and multiplied with inverse of the matrix. The resultant matrix modulo 26 is the actual required plain text matrix, which is further converted in to a block of plaintext and replaced with the given cipher text block.
P= CKmod26
where
C-Cipher text
P-Plaintext
K- Inverse of the Key

PROGRAM DESCRIPTION:

Here I used Java language in order to build the source code for implementing Hill cipher technique and geany Editor. Here I used ARRAYS as a container in order to hold the values of key and Message, those actually participate in both encryption and decryption process. The array used here actually stores the numerical value of the character value in the plaintext block. Math function is used in order to perform the mathematical linear algebra required in the actual encryption and decryption process. Separate determinant values are found for performing inverse depending on the matrix length i.e, 4 for 2x2 and 9 for 3x3 matrix.

The actual Code compilation here is done by using javac filename.java and execution is done by using java filename followed by –e for encryption process and –d for decryption process. The file name used here is lab2.So code execution can be done by using java lab2 –e for encryption process and java lab2 –d for decryption process.

If I start executing the program by typing java Hill_Cipher –e for encryption process, we will get a prompt asking to enter the key (Enter your key). Once I enter the key it will again prompt to enter the message that should be encrypted (Enter your message). After entering values for both the key and the Message the encryption process that described will be taken place i.e, the actual multiplication process of key and message mod26 and we will get a cipher text block for the plain text block under the word encryption.

If I start executing the program by typing java Hill_Cipher –d for decryption process, we will get a prompt asking to enter the key (Enter your key). Once I enter the key it will again prompt to enter the message that should be decrypted (Enter your message). After entering values for both the key and the Message the encryption process that described will be taken place i.e, the actual multiplication process of message and inverse of key mod26 is done and we will get a plaintext block for the encrypted cipher text block under the word decryption.

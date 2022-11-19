- First step, open your terminal in this path `src/main/resources/certs` and generate the private key:

`openssl genrsa -out keypair.pem 2048`

- Second step, generate the public key:

`openssl rsa -in keypair.pem -pubout -out public.pem`

- Third step, convert the private key to a pcks8 format:

`openssl pkcs8 -topk8 -inform PEM -outform PEM -nocrypt -in keypair.pem -out private.pem`
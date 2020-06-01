# Secret Keeper

This application provides a secure way to share secrets over the internet. It makes use of Advanced Encryption Standard (AES) via the [Crypto JS](https://github.com/brix/crypto-js) library to encypt secrets. Ciphers are temporarily cached; once the cipher is retieved, it expires and can never be retrieved again. Hope you enjoy!

## Local Development

- Java 14
- Maven
- NPM

### Running the application

- Backend: `mvn spring-boot:run`
- Frontend: `cd client && npm install && npm run serve`
- Build: `./build.sh`

[Current Deployment](https://vangos-secret-keeper.herokuapp.com)

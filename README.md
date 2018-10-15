# Bank Account
spring boot project     
H2 DataBase       
swagger URL : http://localhost:8080/swagger-ui.html     

### Services :
```sh
GET /clients
```
find all clients
```sh
GET /account?clientId=10001
```
find all client accounts
return a list of accounts (number and balance)

```sh
GET /transaction?accountId=10001
```
find all account transactions
return a list of transactions (transaction type, amount, transaction date)
```sh
POST /transaction?accountId=10001
```
Create a DEBIT or CREDIT transaction     
Calculate post transation balance    
Update account balance    
Transactional supported (Rollback activated for any exception)       
Optimistic concurrency control on Account table supported (protect balance value integrity)     

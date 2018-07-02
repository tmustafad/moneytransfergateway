
#  moneytransfergateway-Instructions
The Rest api is developed with **JAX-RS** and its implementation **JERSEY**. A standalone **HTTPSERVER** is started via main method and all the endpoints start to serve via this http server.
Core JPA and hibernate is used for managing entities,and interacting with db.

A custom Exception named **MoneyTransferGatewayException** is created for covering business exceptions raised from service layer.

### Installing
Once you import project into your workspace as exsisting maven project, all you need to do install the maven project and run it.

You can run the project via **StartMoneyTransferApp** class which is the starting point for all . This can be accomplished with maven **exec** command also which I detailed the command to start app in relevant section of readme file.

The **HSQLDB** is used for keeping data. This is an in-memory database, it starts just before the http server starts and I load some test data to test the api. 

While starting the app, an argument is being passed to open the hsqldb viewver or not. If **yes** is passed along with the maven command ,hsqldb viewver starts, if sth other than yes is specified no viewver starts. All data is accessible via rest api also ,you can find the rest api endpoints and sample requests for creating data and transfer,withdraw or deposit money.


## The Endpoints to reach after running the project
| Method        | Path          										                  |Usage
| ------------- | ----------------------------------------------------------------------  |------------------------------------------ |
| GET           | http://localhost:7777/transferGateway/getAllCustomers                   |get all Customers
| GET           | http://localhost:7777/transferGateway/getAllAccounts                    |get all Accounts     
| GET           | http://localhost:7777/transferGateway/getAccountById/{id}               |get account with the given id
| GET           | http://localhost:7777/transferGateway/getCustomerById/1                 |get customer with the given id     
| POST          | http://localhost:7777/transferGateway/createAccount                     |create a new Account
| POST          | http://localhost:7777/transferGateway/createCustomer                    |create a new Customer
| DELETE        | http://localhost:7777/transferGateway/deleteCustomer                    |delete customer
| DELETE        | http://localhost:7777/transferGateway/deleteAccount                     |delete account 
| PUT           | http://localhost:7777/transferGateway/transferMoney/{from}/{to}/{amount}|transfer money from one account to other
| PUT           | http://localhost:7777/transferGateway/withdraw/{from}/{amount}          |wtihdraw money from specified account
| PUT           | http://localhost:7777/transferGateway/deposit/{to}/{amount}             |deposit money to specified account                                       


##  Sample Json Request for creating Customer
```
{"name": "TOM", "surname": "JACKSON", "accounts":[]}
```

##  Sample Json Request for creating Account
```
{
	"customer":{
		"id":2
	},
	"type":"CHECKING",
	"balance":"500"
}
```
## Sample request for deposit money to account id 4(here 6500 is deposited)
http://localhost:7777/transferGateway/deposit/4/6500

## Sample request for withdraw money from  account id 1(here 2000 is withdrawed)
http://localhost:7777/transferGateway/withdraw/1/2000

## Sample request for transfer  money from  account A to account B (here account 3 gets 6500 from account A)
http://localhost:7777/transferGateway/transferMoney/4/3/6500

## Running the tests(MoneyTransferApiTests in test package)
mvn -Dtest=MoneyTransferApiTests test

## Running the application
mvn exec:java -DshowHsqlViewer=no


